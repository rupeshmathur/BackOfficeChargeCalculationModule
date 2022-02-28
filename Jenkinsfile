pipeline {
    agent {
        dockerfile true
    }
    stages {
     	
        stage('Custom Build') {
            steps {
                sh 'docker build -t springio/back_office_charge_module .'
            }
        }
    }
}