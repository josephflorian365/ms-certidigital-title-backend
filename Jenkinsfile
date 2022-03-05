#!groovy

pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                sh "mvn compile test"
                sh "mvn clean install"
             }
          }
       }
}
