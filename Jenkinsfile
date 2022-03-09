pipeline {
    agent any
     tools {
        jdk 'jdk'
        maven 'mavenTool 3.8.4'
       
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
                                    [url: 'https://github.com/josephflorian365/ms-certidigital-title-backend.git', credentialsId: 'jenkins_github']
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
        
            stage('SonarQube Analysis') {
                agent any 
                steps {
                    sh 'mvn clean package sonar:sonar -Dsonar.host.url=http://ec2-44-203-160-37.compute-1.amazonaws.com:9000 -Dsonar.login=72feaeaf0512a2c00484fbe00e24dccef76fccb7'
                }
               }
    }
}
