#!groovy

pipeline {
    agent any
       tools {
                 maven 'mavenTool'
     }   
    stages {
    stage("checkout"){
        steps {
             checkout ([$class: 'GitsCM', branches: [[name: */main']], doGenerateSubmoduleConfigurations: false, extensions: [],
             submodulecfg: [], userRemoteConfigs: [[credentialsId: 'josephflorian365',
             url: "https://github.com/josephflorian365/ms-certidigital-title-backend.git"]]])
    }    
   }
