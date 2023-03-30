package com.stevenhornghub.promotionrequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;


/**
 * @author Steven Horng
 */
@SpringBootApplication(scanBasePackages = "com.stevenhornghub")
@EnableScheduling
@Slf4j
public class PromotionRequestApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(PromotionRequestApplication.class, args);
        Environment env = applicationContext.getEnvironment();
        String[] activeProfiles = env.getActiveProfiles();
        log.info("##################################################");
        log.info("startSuccess : " + Arrays.toString(activeProfiles));
        log.info("##################################################");
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n\t" +
                        "Doc: \thttp://{}:{}/exchange-otc-api/doc.html\n" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"));
    }
}
