package com.example.Banderoll;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public interface CountryRepository extends CrudRepository<Country, Long> {

}
