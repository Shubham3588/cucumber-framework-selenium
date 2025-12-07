pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Shubham3588/cucumber-framework-selenium.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh "mvn clean install -DskipTests"
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                sh "mvn test"
            }
        }

        stage('Generate Cucumber Report') {
            steps {
                cucumber fileIncludePattern: 'target/cucumber-reports/*.json'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*.json'
            junit 'target/surefire-reports/*.xml'
        }
        failure {
            echo 'Build failed! Sending email…'
        }
    }
}
