package com.fineline;

import com.fineline.dao.StudentDAO;
import com.fineline.repo.StudentRepo;
import com.fineline.utils.PopulateData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring boot application starter
 * @author Sreeram Maram
 */
@SpringBootApplication
public class FinelineApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(FinelineApplication.class, args);
    }

    @Bean
    public CommandLineRunner startup(StudentRepo studentRepo) {
        return args -> PopulateData.init(studentRepo);
    }

    @Bean
    public StudentDAO applicant() {
        return new StudentDAO();
    }

}
