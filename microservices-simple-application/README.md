##########################################################################
#           Building the Docker Images
##########################################################################
Run the following maven command. This command will execute the Spotify docker plugin defined in the pom.xml file.

mvn clean package docker:build

If everything builds successfully you should see a message indicating that the build was successful.

ERROR:
[ERROR] Failed to execute goal com.spotify:docker-maven-plugin:0.4.10:build (default-cli) on project microservices-simple-application: Exception caught: java.util.concurrent.ExecutionException: com.spotify.docker.client.shaded.javax.ws.rs.ProcessingException: org.apache.http.conn.HttpHostConnectException: Connect to localhost:2375 [localhost/127.0.0.1, localhost/0:0:0:0:0:0:0:1] failed: Connection refused: connect -> [Help 1]

Solution:
Go into settings/General tab of docker and turned on "Expose daemon to tcp://localhost:2375 without TLS" and it started working.

##########################################################################
#           Running the Application as Docker Container
##########################################################################
docker-compose -f docker/common/docker-compose.yml up

If everything starts correctly you should see a bunch of spring boot information fly by on standard out. 
At this point all of the services needed for the chapter code examples will be running.

##########################################################################
#           Running the application as Spring Boot
##########################################################################
Run the following maven command. 

mvn spring-boot:run

If everything builds successfully you should see a message indicating that the build was successful.