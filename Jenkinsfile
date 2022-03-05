pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage("Compile") {
            steps {
                sh "./mvn compileJava"
            }
        }
        stage("Unit test") {
            steps {
                sh "./mvn test"
            }
        }
        stage("Code coverage") {
            steps {
        	    sh "./mvn jacocoTestReport"
        	 	publishHTML (target: [
         	        reportDir: 'build/reports/jacoco/test/html',
         			reportFiles: 'index.html',
         			reportName: 'JacocoReport'
         	    ])
         		sh "./mvn jacocoTestCoverageVerification"
         	}
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQubePruebas') {
                    sh './mvn sonarqube'
                }
            }
        }
    }
}
