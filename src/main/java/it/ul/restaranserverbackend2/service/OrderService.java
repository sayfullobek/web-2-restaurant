//package it.ul.restaranserverbackend2.service;
//
//import it.ul.restaranserverbackend2.entity.Order;
//import it.ul.restaranserverbackend2.entity.Product;
//import it.ul.restaranserverbackend2.entity.User;
//import it.ul.restaranserverbackend2.payload.ApiResponse;
//import it.ul.restaranserverbackend2.payload.orderDto;
//import it.ul.restaranserverbackend2.repository.AuthRepository;
//import it.ul.restaranserverbackend2.repository.orderRepository;
//import it.ul.restaranserverbackend2.repository.ProductRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.jaxb.SpringDataJaxb;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//import java.util.UUID;
//@Service
//@RequiredArgsConstructor
//public class OrderService {
//    private final AuthRepository authRepository;
//    private final ProductRepository productRepository;
//    private final orderRepository orderRepository;
//
//    public ApiResponse saveOrderProduct(orderDto orderDto , UUID userId) {
//        try {
//            Product getProduct = productRepository.findById(orderDto.getProductId()).orElseThrow(() -> new ResourceNotFoundException("getProduct"));
//            Optional<User> byId = authRepository.findById(userId);
//            Order order = Order.builder()
//                    .Adres(orderDto.getAdres())
//                    .isActive(true)
//                    .user(byId.get())
//                    .build();
//            getProduct.setOrder(order);
//
//            productRepository.save(getProduct);
//            orderRepository.save(order);
//            return new ApiResponse("saqlandi", true);
//        } catch (Exception e) {
//            return new ApiResponse("Mahsulot buyrutma berishda hatolik", false);
//        }
//    }
//
//}
//

