import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.INFO

def baseLogFileName = 'JMarathonProxyAgent'
def logFileHome = System.getProperty('log.dir', "/var/log/JMarathonProxy")
def enabledLoggers = ['STDOUT']

if(enabledLoggers.contains('FILE'))
{
   new File(logFileHome).mkdirs()

   appender('FILE', RollingFileAppender) {
      file = "${logFileHome}/${baseLogFileName}Agent.log"
      append = true
      encoder(PatternLayoutEncoder) {
         pattern = '%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n'
      }
      rollingPolicy(TimeBasedRollingPolicy) {
         FileNamePattern = "${logFileHome}/${baseLogFileName}.%d{yyyy-MM-dd}.log"
         maxHistory = 20
      }
   }
}

if(enabledLoggers.contains('STDOUT'))
{
   appender('STDOUT', ConsoleAppender) {
      encoder(PatternLayoutEncoder) {
         pattern = '%d{HH:mm:ss.SSS} %-5level %logger - %msg%n'
      }
   }
}

logger('org.springframework', ERROR)
logger('org.apache', ERROR)
logger('org.eclipse', ERROR)

root(DEBUG, enabledLoggers)
