package it.ul.restaranserverbackend2.repository;

import it.ul.restaranserverbackend2.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface DistrictRepository extends JpaRepository<District,Integer> {
}
