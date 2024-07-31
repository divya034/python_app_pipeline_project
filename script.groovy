def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t divya9593776/dockerflask-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push divya9593776/dockerflask-1.0'
    }
} 

return this
