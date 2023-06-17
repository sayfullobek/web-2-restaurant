package it.ul.restaranserverbackend2.controller;

import it.ul.restaranserverbackend2.entity.District;
import it.ul.restaranserverbackend2.payload.ApiResponse;
import it.ul.restaranserverbackend2.repository.DistrictRepository;
import it.ul.restaranserverbackend2.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/district")
public class DistrictController {
    private final DistrictService districtService;
    private final DistrictRepository districtRepository;
    @GetMapping
    public HttpEntity<?> getDistrict(){
        List<District> all = districtRepository.findAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOneDistrict(@PathVariable Integer id){
        District district = districtRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getDistrict"));
        return ResponseEntity.ok(district);
    }
    @PostMapping
    public HttpEntity<?> addDistrict(@RequestParam(name = "districtName") String name,@RequestParam(name = "regionId") Integer regionId){
        ApiResponse apiResponse = districtService.addDistrict(name, regionId);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> editDistrict(@PathVariable Integer id,@RequestParam(name = "name")String name){
        ApiResponse apiResponse = districtService.editDistrict(id, name);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteDistrict(@PathVariable Integer id){
        ApiResponse apiResponse = districtService.deleteDistrict(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}

