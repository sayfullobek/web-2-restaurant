package it.ul.restaranserverbackend2.controller;

import it.ul.restaranserverbackend2.payload.ResStatistics;
import it.ul.restaranserverbackend2.repository.CategoryRepository;
import it.ul.restaranserverbackend2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    //    private final ProductRepository productRepository;
    @GetMapping
    public HttpEntity<?> getStatistics() {
        ResStatistics build = ResStatistics.builder()
                .categorySize(categoryRepository.findAll().size())
                .productSize(productRepository.findAll().size())
                .buySize(0)
                .protcent(0)
                .build();
        return ResponseEntity.ok(build);
    }
}
