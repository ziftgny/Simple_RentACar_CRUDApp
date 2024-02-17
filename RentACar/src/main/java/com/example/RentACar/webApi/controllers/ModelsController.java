package com.example.RentACar.webApi.controllers;

import com.example.RentACar.business.abstracts.ModelService;
import com.example.RentACar.business.request.CreateModelRequest;
import com.example.RentACar.business.response.GetAllModelsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;
    @GetMapping
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest){
        modelService.add(createModelRequest);
    }
}
