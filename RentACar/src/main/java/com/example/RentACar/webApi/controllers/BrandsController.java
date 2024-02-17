package com.example.RentACar.webApi.controllers;

import com.example.RentACar.business.abstracts.BrandService;
import com.example.RentACar.business.request.CreateBrandRequest;
import com.example.RentACar.business.request.UpdateBrandRequest;
import com.example.RentACar.business.response.GetAllBrandsResponse;
import com.example.RentACar.business.response.GetByIDBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;
    @GetMapping()
    List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }
    @GetMapping("/{id}")
    GetByIDBrandResponse getById(@PathVariable int id){
        return brandService.getByID(id);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }
    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
