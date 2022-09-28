pipeline {
    agent { dockerfile true }
    stages {
        stage('Clean up') {
            steps {
                echo 'Built and packed into docker image!'
                // echo 'Cleaning workspace...'
                // cleanWs()
            }
        }
        
        // stage('Build Docker Image') {
        //     steps {
        //         echo 'Building image...'
        //         sh 'docker build -t marketplace-backend'
        //     }
        // }
    }
}
