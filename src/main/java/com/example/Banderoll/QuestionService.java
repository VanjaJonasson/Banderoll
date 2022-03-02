package com.example.Banderoll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private ApiController apicontroller;
    @Autowired
    CountryRepository repository;
}
