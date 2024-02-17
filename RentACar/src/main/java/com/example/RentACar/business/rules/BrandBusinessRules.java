package com.example.RentACar.business.rules;

import com.example.RentACar.core.utilities.exceptions.BusinessException;
import com.example.RentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("brand name already exists");
        }
    }
}
