package it.ul.restaranserverbackend2.repository;

import it.ul.restaranserverbackend2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
