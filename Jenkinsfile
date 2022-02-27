pipeline {
    agent {
        dockerfile true
    }
    stages {
     	
        stage('Custom Build') {
            steps {
                sh 'docker build -t bo-charge-module .'
            }
        }
    }
}