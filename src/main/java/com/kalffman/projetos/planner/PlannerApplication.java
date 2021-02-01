package com.kalffman.projetos.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

import static java.util.TimeZone.setDefault;

@SpringBootApplication
public class PlannerApplication {

    public static void main(String[] args) {
        setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(PlannerApplication.class, args);
    }

}
