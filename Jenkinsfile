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

        stage('Generate Allure Report') {
            steps {
                bat "mvn allure:report || exit 0"
            }
        }

        stage('Publish Cucumber HTML Report') {
            steps {
                publishHTML([
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'cucumber.html',
                    reportName: 'Cucumber HTML Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: true
                ])
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    reportDir: 'target/extent-report',
                    reportFiles: 'index.html',
                    reportName: 'Extent HTML Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: true
                ])
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
