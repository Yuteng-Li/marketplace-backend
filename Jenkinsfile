pipeline {
    agent {label 'built-in'}
    stages {
            stage('Docker Build Image and Push') {
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
        stage('Deploy to Kubernetes') {
            steps {
                echo '========== Continuous Deployment begins here =========='
                    //Create namespace (if it doesn't exist), generate kubernetes manifest through helm, and deploy to kubernetes.
                    sh """
                    kubectl create namespace demo-ascend-marketplace-backend --dry-run=client -o yaml | kubectl apply -f -
                    kubectl apply --namespace demo-ascend-marketplace-backend -f 'deployment.yaml'
                    sleep 30
                    kubectl get all --namespace demo-ascend-namespace
                    """
                echo '========== Continuous Deployment ends here =========='
            }
        }
    }
    post {
        always {
            echo 'Cleaning ws'
            cleanWs()
        }
    }
}
