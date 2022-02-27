pipeline {
    agent {
        dockerfile true
    }
    stages {
     	stage('Maven Clean Build') {
            steps {
                sh 'call mvn clean install -f F:\SPRING_BOOT_PROJECTS\BackOfficeChargeCalculationModule\pom.xml'
            }
        }
        stage('Custom Build') {
            steps {
                sh 'docker build -t bo-charge-module .'
            }
        }
    }
}