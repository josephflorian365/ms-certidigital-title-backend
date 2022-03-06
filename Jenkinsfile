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
            withSonarQubeEnv(credentialsId: '21b09307d8b9e92b9e038e44e9c7590d15d8d060', installationName: 'My SonarQube Server') { // You can override the credential to be used
                        sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
                }
            }
        
            stage('SonarQube Analysis') {
                agent any 
                steps {
                        sh 'mvn clean verify sonar:sonar -Dsonar.host.url=https://sonarcloud.io - Dsonar.login=dc90bb680b6a532f5e283d94b2d8d5687d35ca4c'
                    }
            }
    }
}
