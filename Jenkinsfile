pipeline {
    agent {label 'built-in'}
    stages {
            stage('Docker Build Image and Push') {
                steps {
                //Using DockerHub as Container Image repo. Log in, build image, and then push it to DockerHub using credentials.
                withCredentials([usernamePassword(credentialsId: 'yuteng-dockerhub-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh """
                    docker login --username $USERNAME --password $PASSWORD
                    docker build -t $USERNAME/marketplace-backend:${env.BUILD_NUMBER} -t $USERNAME/marketplace-backend:latest .
                    docker push $USERNAME/marketplace-backend --all-tags

                    docker image prune -f
                    """
                }
                    echo '========== Continuous Integration ends here =========='
                }
            }
        stage('Deploy to Kubernetes') {
            steps {
                echo '========== Continuous Deployment begins here =========='
                    // kubectl create namespace demo-ascend-marketplace-backend --dry-run=client -o yaml

                    sh """
                    sleep 5
                    sleep 10
                    kubectl apply --namespace demo-ascend-namespace -f 'deployment.yaml' --validate=false
                    sleep 30
                    kubectl get all --namespace demo-ascend-namespace
                    """
                echo '========== Continuous Deployment ends here =========='
            }
        }
    }
    post {
        always {
            echo 'Cleaning workspace'
            cleanWs()
        }
    }
}
