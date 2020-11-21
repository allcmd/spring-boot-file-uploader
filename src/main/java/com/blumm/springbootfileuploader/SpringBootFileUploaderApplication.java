package com.blumm.springbootfileuploader;

import com.blumm.springbootfileuploader.properties.StorageProperties;
import com.blumm.springbootfileuploader.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringBootFileUploaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFileUploaderApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
