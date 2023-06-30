package it.ul.restaranserverbackend2.controller;

import it.ul.restaranserverbackend2.entity.Product;
import it.ul.restaranserverbackend2.full.IntProductController;
import it.ul.restaranserverbackend2.payload.ApiResponse;
import it.ul.restaranserverbackend2.payload.ProductDto;
import it.ul.restaranserverbackend2.repository.ProductRepository;
import it.ul.restaranserverbackend2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController implements IntProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping
    @Override
    public HttpEntity<?> getProduct() {
        List<Product> all = productRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    @Override
    public HttpEntity<?> getOneProduct(@PathVariable Integer id) {
        try {
            Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getProduct"));
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping
    @Override
    public HttpEntity<?> addProduct(@RequestBody ProductDto productDto) {
        ApiResponse apiResponse = productService.addProduct(productDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PutMapping("/{id}")
    @Override
    public HttpEntity<?> editProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        ApiResponse apiResponse = productService.editProduct(id, productDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    @Override
    public HttpEntity<?> deleteProduct(@PathVariable Integer id) {
        ApiResponse apiResponse = productService.deleteProduct(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/category/{id}")
    public HttpEntity<?> getProductByCategory(@PathVariable Integer id) {
        List<Product> byCategoryId = productRepository.findByCategoryId(id);
        return ResponseEntity.ok(byCategoryId);
    }
}
