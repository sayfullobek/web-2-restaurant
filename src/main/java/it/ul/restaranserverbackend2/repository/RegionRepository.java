package it.ul.restaranserverbackend2.repository;

import it.ul.restaranserverbackend2.entity.Region;
import it.ul.restaranserverbackend2.projection.CustomCategory;
import it.ul.restaranserverbackend2.projection.CustomRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "list", path = "region", excerptProjection = CustomRegion.class)
public interface RegionRepository extends JpaRepository<Region,Integer> {

}
