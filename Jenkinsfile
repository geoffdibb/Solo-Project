pipeline{
        agent any
        stages{
stage('---setup---'){
                        steps{
                                sh "sudo rm -rf /var/lib/wildfly-10.1.0.Final/standalone/deployments/*"
                        }
                }
                stage('---clean---'){
                        steps{
                                sh "mvn clean"
                        }
                }
                stage('--test--'){
                        steps{
                                sh "mvn test"
                        }
                }
                stage('--package--'){
                        steps{
                                sh "mvn verify"
                        }
                }
		stage('--verify--'){
                        steps{
                                sh "mvn package"
                        }
                }
		stage('--deploy--'){
                        steps{
                                sh "cd /"
				sh "pwd"
				sh "sudo cp /var/lib/jenkins/workspace/${JOB_NAME}/target/SoloProject.war /var/lib/wildfly-10.1.0.Final/standalone/deployments/"
				sh "sudo ls /var/lib/wildfly-10.1.0.Final/standalone/deployments/"
                        }
                }
        }
}
