package com.softwareacademy.sprint1.p9jb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
@SpringBootApplication
/*@Configuration
@EnableAutoConfiguration(
        exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})*/
public class MedicreenP9JbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicreenP9JbApplication.class, args);
    }

}
