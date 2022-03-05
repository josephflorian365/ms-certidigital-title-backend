#!groovy
pipeline {
    agent any
    tools {
        jdk 'jdk'
        maven 'mavenTool'
    }
    stages {
        stage("build project") {
            steps {
               // git 'https://github.com/josephflorian365/ms-certidigital-title-backend.git'
                echo "Java VERSION"
                sh 'java -version'
                echo "Maven VERSION"
                sh 'mvn -version'
                echo 'building project...'
                sh "mvn compile"
                sh "mvn package"
                //sh "mvn test"
                sh "mvn clean install"
            }
        }
    }
}
