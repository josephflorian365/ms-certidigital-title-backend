pipeline {
    agent any
     tools {
        jdk 'jdk'
        maven 'mavenTool'
       
    }
    stages {
        stage("Git Clone"){ 
            steps { 
                cleanWs()
                    checkout([$class: 'GitSCM', 
                              branches: [[name: '*/main']], 
                              doGenerateSubmoduleConfigurations: false, 
                              extensions: [[$class: 'CleanCheckout']], 
                              submoduleCfg: [], 
                              userRemoteConfigs: [
                                    [url: 'https://github.com/josephflorian365/ms-certidigital-title-backend.git', credentialsId: 'jenkins github']
                                    ]]) 
                           sh 'pwd'
                           sh'ls -l' 
            } //steps 
        } //stage
        
            stage('Build Project') {
                agent any 
                steps {
                        sh 'mvn clean install'
                }
            }

            stage('SonarQube analysis') {
                steps {
                    script{
                        def scannerHome = tool 'SonarQubePruebas';
                    withSonarQubeEnv('SonarQubePruebas') {
                        sh "${tool("SonarQubePruebas")}/bin/sonar-scanner \
                            -Dsonar.projectKey=springapp \
                            -Dsonar.projectName=springapp"
                                         }
                                }
                        }
                }
    }
}
