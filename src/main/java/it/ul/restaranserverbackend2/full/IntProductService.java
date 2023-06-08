package it.ul.restaranserverbackend2.full;

import it.ul.restaranserverbackend2.payload.ApiResponse;
import it.ul.restaranserverbackend2.payload.ProductDto;

public interface IntProductService {
    ApiResponse addProduct(ProductDto productDto);

    ApiResponse editProduct(Integer id, ProductDto productDto);

    ApiResponse deleteProduct(Integer id);
}
