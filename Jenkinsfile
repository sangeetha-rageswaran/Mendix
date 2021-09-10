pipeline {
    agent any
    tools {
        maven 'MAVEN_HOME'
        jdk 'JAVA_HOME'
    }
stages{
    stage ('build'){
        steps{
//     		git "https://github.com/sangeetha-rageswaran/Mendix"
echo 'Notify GitLab'
updateGitlabCommitStatus name: 'build',state:'pending'
echo 'build step goes here'
updateGitlabCommitStatus name: 'build', state:'success'
    		}

    }
    stage ('test') {
        steps{
            sh "mvn test"
//             publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: '..\\Pipeline TestAutomation\\test-output', reportFiles: '*.html', reportName: 'test-output', reportTitles: 'ExtentReportsTestNG.html'])
    }
}
}
}