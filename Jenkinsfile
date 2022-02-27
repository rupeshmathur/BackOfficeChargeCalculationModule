pipeline {
    agent {
        dockerfile true
    }
    stages {
        stage('Custom Build') {
            steps {
                sh 'docker -t bo-charge-module'
            }
        }
    }
}