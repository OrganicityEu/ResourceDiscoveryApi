package eu.organicity.discovery;


import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@ComponentScan(basePackages = "eu.organicity.discovery")
@PropertySource("classpath:application.properties")
@EnableAsync
@EnableScheduling
@EnableAspectJAutoProxy
@EnableAutoConfiguration(exclude = {VelocityAutoConfiguration.class})
public class Application implements CommandLineRunner {


    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = Logger.getLogger(Application.class);

    public static void main(String[] args)
            throws Exception {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        for (String name : ctx.getBeanDefinitionNames()) {
            LOGGER.info(name);
        }
    }

    public void run(String... args) throws Exception {

    }
}