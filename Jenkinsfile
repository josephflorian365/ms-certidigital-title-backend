#!groovy
pipeline{
	agent any
	// Definir la dirección del almacén
	environment {
		REPOSITORY="https://github.com/josephflorian365/ms-certidigital-title-backend.git"
	}
 
	stages {
 
		 stage ('Obtener código') {
			steps {
				echo "start fetch code from git:${REPOSITORY}"
				 // Vaciar el directorio actual
				deleteDir()
				 // Tire del código	
				git "${REPOSITORY}"
			}
		}
 
		 stage ('Código de verificación estática') {
			steps {
				 // Verificación de pseudocódigo
				echo "start code check"
			}
		}		
 
		 stage ('compilar + prueba unitaria') {
			steps {
				echo "start compile"
				 // Cambiar directorio
				dir('sso-client1') {
					 // reempaquetado
					bat 'mvn -Dmaven.test.skip=true -U clean install'
				}
			}
		}
 
		 stage ('Crear imagen') {
			steps {
				echo "start build image"
				dir('sso-client1') {
					 // construir imagen
					bat 'docker build -t hub.c.163.com/longfeizheng/sso-client1:1.0 .'
					 // Inicie sesión en 163 Cloud Warehouse
					bat 'docker login -u longfei_zheng@163.com -p password hub.c.163.com'
					 // Empuja el espejo hacia el almacén 163
					bat 'docker push hub.c.163.com/longfeizheng/sso-client1:1.0'
				}
			}
		}
 
		 stage ('Iniciar servicio') {
			steps {
				echo "start sso-merryyou"
				 // Reiniciar el servicio
				bat 'docker-compose up -d --build'
			}
		}				
 
	}
}
