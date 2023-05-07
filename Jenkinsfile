pipeline{
    agent any
    stages{
        stage('prepare'){
            steps{
                sh 'echo "prepare"'
            }

        }
        stage('build'){
            steps{
                sh 'echo "build"'
               sh 'mvn clean install'
            }
        }
        stage('test'){
            steps{
                sh 'echo "test"'
            }
        }
        stage('deploy'){
            steps{
                sh 'echo "deploy"'
            }
        }
    }
}
