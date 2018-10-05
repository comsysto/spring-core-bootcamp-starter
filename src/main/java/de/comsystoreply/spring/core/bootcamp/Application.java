package de.comsystoreply.spring.core.bootcamp;

import org.apache.catalina.LifecycleState;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;


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
    private static final int SERVER_PORT = 8080;

    /**
     * Main method that acts as the entry point into the application.
     *
     * @param args the command line arguments the application is started with
     * @throws Exception any kind of exception will just be thrown up resulting in the application crashing
     */
    public static void main(String... args) throws Exception {
        LOGGER.info("Application is running.");

        /*
         * Configure embedded Tomcat instance.
         */
        String basedir = Files.createTempDirectory("bootcamp-tomcat").toAbsolutePath().toString();
        String appBase = ".";

        Tomcat tomcat = new Tomcat();
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
        }

        /*
         * Keep the application alive until Tomcat is terminated.
         */
        tomcat.getServer().await();
    }
}
