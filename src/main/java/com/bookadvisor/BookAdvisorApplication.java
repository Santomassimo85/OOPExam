package com.bookadvisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point for the BookAdvisor Spring Boot application.
 * <p>
 * This class bootstraps the application using Spring Boot's {@code @SpringBootApplication} annotation,
 * which enables component scanning, auto-configuration, and property support.
 * </p>
 *
 * <p>
 * To start the application, run the {@link #main(String[])} method.
 * </p>
 *
 * @author luxxion
 * @version 1.0
 */

@SpringBootApplication
public class BookAdvisorApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookAdvisorApplication.class, args);
    }
}
