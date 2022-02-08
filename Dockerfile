FROM jenkins/jenkins:lts
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
ENV CASC_JENKINS_CONFIG /var/jenkins_home/casc.yml
COPY --chown=jenkins:jenkins plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY --chown=jenkins:jenkins casc.yml /var/jenkins_home/casc.yml
COPY seedjob.groovy /usr/local/seedjob.groovy
ADD init.groovy.d /usr/share/jenkins/ref/init.groovy.d
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt
