package de.comsystoreply.spring.core.bootcamp;

import java.io.IOException;
import java.nio.file.Files;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class of the application.
 */
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     * The port the embedded Tomcat server should listen on.
     * <p/>
     * For real applications it would be a smart to provide an option to configure the port at start up. In the training
     * we will just start with an hard coded port.
     */
    private static final int SERVER_PORT = 8090;
    private Tomcat tomcat;


    public void start() throws IOException, LifecycleException {
        LOGGER.info("Application is starting.");

        /*
         * Configure embedded Tomcat instance.
         */
        var basedir = Files.createTempDirectory("bootcamp-tomcat").toAbsolutePath().toString();
        var appBase = ".";

        tomcat = new Tomcat();
        tomcat.setBaseDir(basedir);
        tomcat.setPort(SERVER_PORT);
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp("", appBase);

        /*
         * Ensure that a connector listening to the given port is created.
         */
        tomcat.getConnector();

        /*
         * Start embedded Tomcat server.
         */
        tomcat.start();

        /*
         * Check if Tomcat connector could be started and shut down Tomcat when start up failed.
         *
         * Failures to start up are commonly due to the specified port already being in use.
         */
        if (tomcat.getConnector().getState() != LifecycleState.STARTED) {
            LOGGER.error("Could not start Tomcat connector.");
            tomcat.stop();
            throw new IllegalStateException("Could not start Tomcat connector.");
        }
    }

    public void stop() throws LifecycleException {
        if(this.tomcat != null){
            this.tomcat.stop();
        }
    }

    public void await() {
        /*
         * Keep the application alive until Tomcat is terminated.
         */
        tomcat.getServer().await();
    }


    public static void main(String... args) throws Exception {
        var application = new Application();
        application.start();
        application.await();
    }
}
