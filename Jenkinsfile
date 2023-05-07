pipeline{
    agent any
    stages{
        stage('prepare'){
            steps{
                sh 'echo "prepare"'
                sh 'mvn clean'
            }

        }
        stage('build'){
            steps{
                sh 'echo "build"'
                sh 'mvn install'
            }
        }
        stage('test'){
            steps{
                sh 'echo "test"'
                sh 'mvn test'
            }
        }
        stage('deploy'){
            steps{
                sh 'echo "deploy"'
            }
        }
    }
}
