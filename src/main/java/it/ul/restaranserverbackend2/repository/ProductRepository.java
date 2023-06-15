package it.ul.restaranserverbackend2.repository;

import it.ul.restaranserverbackend2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
