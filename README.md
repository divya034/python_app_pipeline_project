## Creating flask dockerfile

- Exposed port
- Run command using Entrypoint and CMD

## Setup EKS cluster using terraform

- Using Hashicorp official github terraform files, giving roles to master and worker with respective policies
- Changed region of operation in variables.tf file, took around 15 mins to setup cluster
- copied kubeconfig file in .kube/config location, setup aws-iam-authenticator to access eks in local terminal
- changed v1beta1 to v1alpha1 in config file to avoid some version mismatched errors
- created clusterrolebinding, to avoid permission errors as by default system user doesnt help to deploy things in eks

## Setup Jenkins jobs and jenkinsfile

- Provided dockerhub credentials and used withCredentials
- Built image in dockerhub format, and pushed to dockerhub after auto login in stage
- Used kubernetes build plugin, provided kubeconfig file there and used kubernetesDeploy object in stage
- Created a local jenkins docker image providing jenkins and docker volume
- Gave executable permission to jenkins user in /var/run/docker.sock file for docker image build stage


-Used Ngrok for webhook, as webhook dont work on localhost, and jenkins is running on localhost

-After pod is running in eks, using port-forward, can access application output on localhost
