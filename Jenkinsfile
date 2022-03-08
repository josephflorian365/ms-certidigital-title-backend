node {
       stage('SCM') {
    git 'https://github.com/josephflorian365/ms-certidigital-title-backend.git'
  }
  withMaven( maven: 'mavenTool 3.8.4'){
      sh "mvn clean install"
  }

  stage('SonarQube analysis') {
    // requires SonarQube Scanner 2.8+
    def scannerHome = tool 'SonarScanner4.7';//Mismo nombre que pusimos // en el global tool configuration
    withSonarQubeEnv('sonarExample') { // El nombre de servidor que //pusimos en Configuración del sistema.
      sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=fr.demo:my-project -Dsonar.sources=. -Dsonar.java.binaries=."
    }
  }
}
