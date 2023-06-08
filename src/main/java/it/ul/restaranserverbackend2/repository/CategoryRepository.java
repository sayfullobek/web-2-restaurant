package it.ul.restaranserverbackend2.repository;

import it.ul.restaranserverbackend2.entity.Category;
import it.ul.restaranserverbackend2.projection.CustomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "list", path = "category", excerptProjection = CustomCategory.class)
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
