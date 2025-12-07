pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    options {
        timestamps()
        ansiColor('xterm')
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/Shubham3588/cucumber-framework-selenium.git'
            }
        }

        stage('Build') {
            steps {
                bat "mvn clean install -DskipTests"
            }
        }

        stage('Run Tests') {
            steps {
                bat "mvn test"
            }
        }

        stage('Generate Reports') {
            steps {
                bat "mvn allure:report || exit 0"
            }
        }

        stage('Cucumber Report') {
            steps {
                cucumber fileIncludePattern: 'target/cucumber-reports/*.json'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/**/*.*', fingerprint: true
        }
    }
}
