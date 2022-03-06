pipeline {
    agent any
     tools {
        jdk 'jdk'
        maven 'mavenTool'
       
    }
    stages {
        stage("Git Clone"){ 
            steps { 
                cleansWs()
                    checkout([$class: 'GitSCM', 
                              branches: [[name: '*/feature/sonarqube']], 
                              doGenerateSubmoduleConfigurations: false, 
                              extensions: [[$class: 'CleanCheckout']], 
                              submoduleCfg: [], 
                              userRemoteConfigs: [
                                    [url: 'https://github.com/vallegrande/A520153 TO2_Educasi.git', credentialsId: 'jenkins github']
                                    ]]) 
                           sh 'pwd
                           sh'ls -l' 
            } //steps 
        } //stage
        
            stage('Build Project') {
                agent any 
                steps {
                        sh 'mvn clean install'
                }
            }
        
            stage('SonarQube Analysis') {
                agent any 
                steps {
                        sh 'mvn clean verify sonar:sonar -Dsonar.host.url=http://localhost:9000 - Dsonar.login=4cca8803902a0cdea51c45fba00b07369788e9e9'
                    }
            }
    }
}
