import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*
import hudson.security.*

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
def adminUsername = System.getenv('JENKINS_ADMIN_USERNAME') ?: 'admin'
def adminPassword = System.getenv('JENKINS_ADMIN_PASSWORD') ?: 'password'
hudsonRealm.createAccount(adminUsername, adminPassword)
hudsonRealm.createAccount("fudongbai","111111")

def instance = Jenkins.getInstance()
instance.setSecurityRealm(hudsonRealm)
instance.save()

def strategy = new GlobalMatrixAuthorizationStrategy()

// Slave Permissions
strategy.add(hudson.model.Computer.BUILD,'fudongbai')
strategy.add(hudson.model.Computer.CONFIGURE,'fudongbai')
strategy.add(hudson.model.Computer.CONNECT,'fudongbai')
strategy.add(hudson.model.Computer.CREATE,'fudongbai')
strategy.add(hudson.model.Computer.DELETE,'fudongbai')
strategy.add(hudson.model.Computer.DISCONNECT,'fudongbai')

// Overall Permissions
strategy.add(hudson.model.Hudson.ADMINISTER,'fudongbai')
strategy.add(hudson.PluginManager.CONFIGURE_UPDATECENTER,'fudongbai')
strategy.add(hudson.model.Hudson.READ,'fudongbai')
strategy.add(hudson.model.Hudson.RUN_SCRIPTS,'fudongbai')
strategy.add(hudson.PluginManager.UPLOAD_PLUGINS,'fudongbai')

// Job Permissions
strategy.add(hudson.model.Item.BUILD,'fudongbai')
strategy.add(hudson.model.Item.CANCEL,'fudongbai')
strategy.add(hudson.model.Item.CONFIGURE,'fudongbai')
strategy.add(hudson.model.Item.CREATE,'fudongbai')
strategy.add(hudson.model.Item.DELETE,'fudongbai')
strategy.add(hudson.model.Item.DISCOVER,'fudongbai')
strategy.add(hudson.model.Item.READ,'fudongbai')
strategy.add(hudson.model.Item.WORKSPACE,'fudongbai')

// Run Permissions
strategy.add(hudson.model.Run.DELETE,'fudongbai')
strategy.add(hudson.model.Run.UPDATE,'fudongbai')

// View Permissions
strategy.add(hudson.model.View.CONFIGURE,'fudongbai')
strategy.add(hudson.model.View.CREATE,'fudongbai')
strategy.add(hudson.model.View.DELETE,'fudongbai')
strategy.add(hudson.model.View.READ,'fudongbai')

// Setting Admin Permissions
strategy.add(Jenkins.ADMINISTER, "admin")

instance.setAuthorizationStrategy(strategy)
instance.save()
