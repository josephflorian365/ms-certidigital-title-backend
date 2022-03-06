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
                withSonarQubeEnv('SonarCloud') {
                    
                    def urlcomponents = env.CHANGE_URL.split("/")
                    def org = urlcomponents[3]
                    def repo = urlcomponents[4]
                    
                sh "./mvnw sonar:sonar \
    -Dsonar.pullrequest.provider=GitHub \
    -Dsonar.pullrequest.github.repository=${org}/${repo} \
    -Dsonar.pullrequest.key=${env.CHANGE_ID} \
    -Dsonar.pullrequest.branch=${env.CHANGE_BRANCH}"
                    }
               }
            }
    }
}
