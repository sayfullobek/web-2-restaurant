package it.ul.restaranserverbackend2.service;

import it.ul.restaranserverbackend2.entity.Product;
import it.ul.restaranserverbackend2.entity.SaveProduct;
import it.ul.restaranserverbackend2.entity.User;
import it.ul.restaranserverbackend2.payload.ApiResponse;
import it.ul.restaranserverbackend2.repository.AuthRepository;
import it.ul.restaranserverbackend2.repository.ProductRepository;
import it.ul.restaranserverbackend2.repository.SaveProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaveProductService {
    private final SaveProductRepository saveProductRepository;
    private final AuthRepository authRepository;
    private final ProductRepository productRepository;

    public ApiResponse saveProduct(UUID userId, Integer id) {
        try {
            User user = authRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("getUser"));
            Product getProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getProduct"));
            SaveProduct saveProduct = user.getSaveProduct();
            if (saveProduct != null) {
                saveProduct.getProducts().add(getProduct);
                saveProductRepository.save(saveProduct);
                authRepository.save(user);
                return new ApiResponse("Mahsulot savatga saqlandi", true);
            }
            SaveProduct saveProduct1 = new SaveProduct();
            SaveProduct save = saveProductRepository.save(saveProduct1);
            user.setSaveProduct(save);
            saveProduct1.getProducts().add(getProduct);
            authRepository.save(user);
            return new ApiResponse("Mahsulot savatga saqlandi", true);

        } catch (Exception e) {
            return new ApiResponse("Mahsulot savatga saqlashda hatolik", false);
        }
    }

    public ApiResponse deleteProduct(UUID userId, Integer Id) {
        User user = authRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("getUser"));
        for (Product product : user.getSaveProduct().getProducts()) {
            if (product.getId().equals(Id)) {
                user.getSaveProduct().getProducts().remove(product);
                return new ApiResponse("Mahsulot O'chirildi", true);
            }
        }
        return new ApiResponse("Mahsulot ochirilmadi", false);
    }
}
