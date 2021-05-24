package com.github.samuelferreira.citiesapi.cities;

import com.github.samuelferreira.citiesapi.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    // executa a pesquisa e calculo  no BD para distancia por coordenadas (milhas)
    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
    Double distanceByPoints(Long city1, Long city2);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    // executa a pesquisa e calculo no BD para a distancia por cubo (metros)
    Double distanceByCube(double x, double y, double x1, double y1);
}
