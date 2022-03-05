#!groovy

pipeline {
    agent any 
    stages {
        
        stage("Git Clone"){
            steps {
                cleans()
                   checkout([$class: 'GitSCM',
                   branches: [[name: '*/main']],
                   doGenerateSubmoduleConfigurations: false,
                   extensions: [[$class: 'CleanCheckout']],
                   submoduleCfg: [],
                   userRemoteConfigs: [
                       [url: 'https://github.com/josephflorian365/ms-certidigital-title-backend.git', credentialsId: 'jenkins_github']
                       ]]) 
                 sh 'pwd'
                 sh'ls -l' 
              } //steps
            } //stage
                              
            stage("Build Project') {
                 agent any 
                   steps {
                            sh 'mvn clean install'
                       }
                   }
             stage("SonarQube Analysis) {
                 agent any 
                   steps {
                            sh'mvn clean verify sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login='
                   }
                }
                   
             }      
         }
