package com.github.samuelferreira.citiesapi.countries.repository;

import com.github.samuelferreira.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
