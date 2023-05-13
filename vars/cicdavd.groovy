def contDownload(repo)
{
  git "https://github.com/prasadcloud/${repo}"
}
def contBuild()
{
  sh 'mvn package'
}
def contDep(jobname,ipaddress,context)
{
  sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ipaddress}:/var/lib/tomcat9/webapps/${context}.war"
}
def contTest(jobname)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
