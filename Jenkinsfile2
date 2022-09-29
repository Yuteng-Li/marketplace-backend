pipeline {
    agent {label 'built-in'}
    stages {
        stage('Checkout') {
            steps {
                sh "docker image prune -f"
            }
        }
        stage('Build') {
            agent { dockerfile true }
            steps {
                    //Using DockerHub as Container Image repo. Log in, build image, and then push it to DockerHub using credentials.
                    withCredentials([usernamePassword(credentialsId: 'yuteng-dockerhub-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh """
                    docker login --username $USERNAME --password $PASSWORD
                    docker build -t $USERNAME/marketplace-backend:${env.BUILD_NUMBER} .
                    docker push $USERNAME/marketplace-backend:${env.BUILD_NUMBER}
                    docker image prune -f
                    """
                }
                echo '========== Continuous Integration ends here =========='
            }
        }
        stage('Clean up') {
            steps {
                echo 'Built and packed into docker image!'
                echo 'Cleaning workspace...'
                cleanWs()
            }
        }
        //         stage('Build Docker Image') {
        //     steps {
        //         echo 'Building image...'
        //         sh 'docker build -t marketplace-backend'
        //     }
        // }
    }
}
