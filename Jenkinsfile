pipeline {
    agent {label 'built-in'}
    stages {
            stage('Docker Build Image and Push') {
                steps {
                //Using DockerHub as Container Image repo. Log in, build image, and then push it to DockerHub using credentials.
                withCredentials([usernamePassword(credentialsId: 'yuteng-dockerhub-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh """
                    docker login --username $USERNAME --password $PASSWORD
                    docker build -t $USERNAME/marketplace-backend:${env.BUILD_NUMBER} -t latest .
                    docker push $USERNAME/marketplace-backend:${env.BUILD_NUMBER} latest
                    docker image prune -f
                    """
                }
                    echo '========== Continuous Integration ends here =========='
                }
            }
        stage('Deploy to Kubernetes') {
            steps {
                echo '========== Continuous Deployment begins here =========='
                    sh """
                    kubectl create namespace demo-ascend-marketplace-backend --dry-run=client -o yaml
                    kubectl apply --namespace demo-ascend-marketplace-backend -f 'deployment.yaml' --validate=false
                    sleep 30
                    kubectl get all --namespace demo-ascend-marketplace-backend
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
