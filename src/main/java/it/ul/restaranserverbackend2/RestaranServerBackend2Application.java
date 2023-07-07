package it.ul.restaranserverbackend2;

import it.ul.restaranserverbackend2.config.InitConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaranServerBackend2Application {
    public static void main(String[] args) {
        if (InitConfig.isStart()) {
            System.out.println("hello Shavkat");
            SpringApplication.run(RestaranServerBackend2Application.class, args);
        }
    }

}
