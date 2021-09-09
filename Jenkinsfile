pipeline {
    agent any
    tools {
        maven 'MAVEN_HOME'
        jdk 'JAVA_HOME'
    }
stages{
    stage ('SCM checkout'){
        steps{
    		git "https://github.com/sangeetha-rageswaran/Mendixhttps://github.com/sangeetha-rageswaran/Mendix"
    		}

    }
    stage ('Build') {
        steps{
            sh "mvn clean install"
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: '..\\Pipeline TestAutomation\\test-output', reportFiles: '*.html', reportName: 'test-output', reportTitles: 'ExtentReportsTestNG.html'])
    }
}
}
}