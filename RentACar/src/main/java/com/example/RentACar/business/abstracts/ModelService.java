package com.example.RentACar.business.abstracts;

import com.example.RentACar.business.request.CreateBrandRequest;
import com.example.RentACar.business.request.CreateModelRequest;
import com.example.RentACar.business.response.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
