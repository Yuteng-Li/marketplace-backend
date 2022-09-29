pipeline {
    
    agent {label 'built-in'}

    stages {
        stage('Clean up docker image') {
            steps {
                sh "docker image prune -f"
            }
        }
        stage('Maven Build') {
            agent { docker { image 'maven:3.8.1-adoptopenjdk-11' } }
            stages {
                stage('log version info') {
                    steps {
                        sh 'mvn --version'
                        sh 'mvn clean -DskipTests package'
                    }
                }
        }
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
        // stage('Deploy to Kubernetes') {
        //     steps {
        //         echo '========== Continuous Deployment begins here =========='
        //         withCredentials([usernamePassword(credentialsId: 'mebad-demo-dockerhub-creds', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        //             //Create namespace (if it doesn't exist), generate kubernetes manifest through helm, and deploy to kubernetes.
        //             sh """
        //             kubectl create namespace demo-ascend-namespace --dry-run=client -o yaml | kubectl apply -f -
        //             helm template ./petclinic-helm -f petclinic-helm/values.yaml --set image.repository=$USERNAME/springboot-demo-app --set image.tag=${env.BUILD_NUMBER} | kubectl apply --namespace demo-ascend-namespace -f -  &&\
        //             sleep 30
        //             kubectl get all --namespace demo-ascend-namespace
        //             """
        //         }
        //         echo '========== Continuous Deployment ends here =========='
        //     }
        // }
        stage('Clean Workspace'){
            steps{
                cleanWs()
            }
        }
    }
}
