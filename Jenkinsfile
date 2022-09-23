pipeline {
    agent { dockerfile true }
    stages {
        stage('Test') {
            steps {
                echo 'Built and packed into docker image!'
                echo 'cleaning workspace'
                cleanWs()
            }
        }
    }
}
