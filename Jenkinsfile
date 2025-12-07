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
                withEnv(["JAVA_HOME=${tool 'JDK17'}", "PATH+JDK=${tool 'JDK17'}/bin"]) {
                    bat "mvn clean install -DskipTests"
                }
            }
        }

        stage('Run Tests') {
            steps {
                withEnv(["JAVA_HOME=${tool 'JDK17'}", "PATH+JDK=${tool 'JDK17'}/bin"]) {
                    bat "mvn test"
                }
            }
        }

        stage('Generate Reports') {
            steps {
                bat "mvn allure:report || exit 0"
            }
        }

        stage('Cucumber Report') {
            steps {
                publishHTML([
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'cucumber-html-reports.html',
                    reportName: 'Cucumber HTML Report'
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
