package it.ul.restaranserverbackend2.service;

import it.ul.restaranserverbackend2.entity.District;
import it.ul.restaranserverbackend2.entity.Region;
import it.ul.restaranserverbackend2.payload.ApiResponse;
import it.ul.restaranserverbackend2.repository.DistrictRepository;
import it.ul.restaranserverbackend2.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictRepository districtRepository;
    private final RegionRepository repository;
    public ApiResponse addDistrict(String name,Integer regionId){
        Region getRegion = repository.findById(regionId).orElseThrow(() -> new ResourceNotFoundException("getRegion"));
        try {
            District district=new District();
            district.setRegion(getRegion);
            district.setName(name);
            districtRepository.save(district);
            return new ApiResponse("Qo'shildi",true);
        }catch (Exception e){
            return new  ApiResponse("xato",false);
        }
    }
    public ApiResponse editDistrict(Integer districtId,String name){
        District district = districtRepository.findById(districtId).orElseThrow(() -> new ResourceNotFoundException("getDistrict"));
        district.setName(name);
        districtRepository.save(district);
        return new ApiResponse("taxrirlandi",true);
    }
    public ApiResponse deleteDistrict(Integer id){
        District district = districtRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getDistrict"));
        districtRepository.delete(district);
        return new ApiResponse("o'chirildi",true);
    }
}
