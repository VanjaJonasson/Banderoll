package com.example.Banderoll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApiRunner implements CommandLineRunner {

        @Autowired
        ApiController controller;


        @Override
        public void run(String... args) throws Exception {
            //Körs en gång vid uppstart
            controller.innit();
        }
    }

