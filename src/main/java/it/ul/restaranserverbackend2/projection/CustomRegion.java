package it.ul.restaranserverbackend2.projection;

import it.ul.restaranserverbackend2.entity.Category;
import it.ul.restaranserverbackend2.entity.Region;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customRegion", types = Region.class)
public interface CustomRegion {
    Integer getId();

    String getName();
}
