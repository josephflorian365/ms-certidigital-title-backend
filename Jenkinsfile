pipeline {
    agent any
     tools {
        jdk 'jdk'
        maven 'mavenTool'
       
    }
    stages {
        stage ('Checking java version') {
            steps {
                    sh 'java -version'
            }
        }
        stage ('maven version') {
            steps {               
                    sh 'mvn -version'                
            }
        }
        stage ('build app test') {
            steps {               
                    sh 'mvn clean install -Dskip.unit-tests=true -Dskip.integration-tests=true -Dskip.end-to-end-tests=true'                                    
            }
        }
        
        stage ('docker image build')
        {
            steps {
                   
                        sh 'mvn dockerfile:build'
                         
                  }
          }
          stage ('docker image push to Docker Hub') {
            steps {               
                    sh 'mvn dockerfile:push'                          
            }
        }
    }
}
