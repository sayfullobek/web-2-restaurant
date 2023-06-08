package it.ul.restaranserverbackend2.projection;

import it.ul.restaranserverbackend2.entity.Category;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customCategory", types = Category.class)
public interface CustomCategory {
    Integer getId();

    String getName();
}
