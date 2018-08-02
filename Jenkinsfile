@Library('bcd-jenkins-configuration@task/BCDT-10623-Add-Changelog') _

bcdPipeline {
  projectName = 'library'
  useJacocoPlugin = true
  useCloudAmqp = false
  deployPlaybook = true
  runRemoteAcceptanceTests = true
}

gradleRemoteAcceptanceTest {}
