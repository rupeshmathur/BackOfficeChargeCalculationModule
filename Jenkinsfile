pipeline {
    agent {
        Dockerfile true
    }
    stages {
        stage('Custom Build') {
            steps {
                sh 'docker build -t bo-charge-module -f Dockerfile .'
            }
        }
    }
}