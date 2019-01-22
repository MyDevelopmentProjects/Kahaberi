package ge.unknown;

import ge.unknown.configuration.StorageConfiguration;
import ge.unknown.service.StorageService;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.servlet.ServletException;
import javax.sql.DataSource;

/**
 * Created by MJaniko on 3/3/2017.
 */
@SpringBootApplication(exclude = {
    HibernateJpaAutoConfiguration.class,
    DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    ErrorMvcAutoConfiguration.class
})
@EnableConfigurationProperties(StorageConfiguration.class)
@PropertySource("classpath:application.properties")
public class Application {

    @Autowired
    DataSource dataSource;

    @Autowired
    private StorageService serv;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            //storageService.deleteAll(); // Delete all files on startup
            //storageService.init();
        };
    }


    @Bean
    public EmbeddedServletContainerFactory servletContainerFactory() {
        return new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) {
                Context root = null;
                try {
                    root = tomcat.addWebapp("/uploads", serv.getRootLocation().toAbsolutePath().toString());
                    root.setAllowCasualMultipartParsing(true);
                } catch (ServletException e) {
                    //e.printStackTrace();
                }
                return super.getTomcatEmbeddedServletContainer(tomcat);
            }
        };
    }
}
