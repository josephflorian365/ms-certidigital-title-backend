#!groovy

pipeline {
    agent any

stages {
    stages {
        stage("Build") {
            steps {
                sh "mvn -version"
                sh "mvn clean install"
             }
          }
       }
    }
}
