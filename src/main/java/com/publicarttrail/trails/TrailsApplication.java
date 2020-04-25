package com.publicarttrail.trails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://stackoverflow.com/questions/52648330/spring-data-jpa-manytomany-relationship-with-extra-column
// https://stackoverflow.com/questions/5127129/mapping-many-to-many-association-table-with-extra-columns
// http://www.davismol.net/2015/06/05/jackson-using-jsonserialize-or-jsondeserialize-annotation-to-register-a-custom-serializer-or-deserializer/

@SpringBootApplication
public class TrailsApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrailsApplication.class, args);
    }
}
