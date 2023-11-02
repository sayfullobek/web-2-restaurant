//package it.ul.restaranserverbackend2.controller;
//
//import it.ul.restaranserverbackend2.entity.Order;
//import it.ul.restaranserverbackend2.payload.ApiResponse;
//import it.ul.restaranserverbackend2.payload.orderDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpEntity;
//import it.ul.restaranserverbackend2.repository.orderRepository;
//import it.ul.restaranserverbackend2.service.OrderService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;
//@RestController
//@RequestMapping("/api/order")
//@RequiredArgsConstructor
//public class orderController {
//        private final orderRepository orderRepository;
//
//        private final OrderService orderService;
//
//        @PostMapping
//        public HttpEntity<?> addProduct(@RequestBody orderDto orderDto , @RequestParam UUID userId) {
//            ApiResponse apiResponse = orderService.saveOrderProduct(orderDto,userId);
//            return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
//        }
//        @GetMapping({"/{id}"})
//        public HttpEntity<?>getOreder(@PathVariable Integer id, @RequestParam UUID userId){
//            try {
//                Order byUserId = orderRepository.findByUserId(userId);
//                return ResponseEntity.ok(byUserId);
//            }catch (Exception e){
//                return null;
//            }
//        }
//    }
//
