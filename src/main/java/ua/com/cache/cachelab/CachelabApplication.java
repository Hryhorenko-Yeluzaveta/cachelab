package ua.com.cache.cachelab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachelabApplication {

    public static void main(String[] args) {
        SpringApplication.run(CachelabApplication.class, args);
    }

}