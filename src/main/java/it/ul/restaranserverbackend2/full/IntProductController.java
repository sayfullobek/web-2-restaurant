package it.ul.restaranserverbackend2.full;

import it.ul.restaranserverbackend2.payload.ProductDto;
import org.springframework.http.HttpEntity;

public interface IntProductController {
    HttpEntity<?> getProduct();

    HttpEntity<?> getOneProduct(Integer id);

    HttpEntity<?> addProduct(ProductDto productDto);

    HttpEntity<?> editProduct(Integer id, ProductDto productDto);

    HttpEntity<?> deleteProduct(Integer id);
}
