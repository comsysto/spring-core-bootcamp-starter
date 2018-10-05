package de.comsystoreply.spring.core.bootcamp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Initializes the web application.
 * <p/>
 * This class is automatically picked up via some Spring magic that hooks into the Java Servlet API 3.0+ capability
 * to bootstrap the servlet context via Java classes. <br />
 * The important part for us is to know that this class will be picked and its {@link #onStartup(ServletContext)}
 * executed when the Tomcat server is starting allowing us to create our application context and register it
 * as a servlet in Tomcat.
 */
@Configuration
@EnableWebMvc
public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        /*
         * Create WebApplicationContext.
         */
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(ApplicationInitializer.class);
        applicationContext.registerShutdownHook();

        /*
         * Create DispatcherServlet.
         */
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

        /*
         * Register DispatcherServlet in root path.
         */
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
