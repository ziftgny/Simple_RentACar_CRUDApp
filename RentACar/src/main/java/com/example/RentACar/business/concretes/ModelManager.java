package com.example.RentACar.business.concretes;

import com.example.RentACar.business.abstracts.ModelService;
import com.example.RentACar.business.request.CreateModelRequest;
import com.example.RentACar.business.response.GetAllBrandsResponse;
import com.example.RentACar.business.response.GetAllModelsResponse;
import com.example.RentACar.core.utilities.mappers.ModelMapperService;
import com.example.RentACar.dataAccess.abstracts.ModelRepository;
import com.example.RentACar.entities.concretes.Brand;
import com.example.RentACar.entities.concretes.Model;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model->this.modelMapperService.forResponse().
                        map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponse;

    }

    @Override
    public void add( CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);
    }
}
