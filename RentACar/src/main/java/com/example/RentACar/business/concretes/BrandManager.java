package com.example.RentACar.business.concretes;
import com.example.RentACar.business.abstracts.BrandService;
import com.example.RentACar.business.request.CreateBrandRequest;
import com.example.RentACar.business.request.UpdateBrandRequest;
import com.example.RentACar.business.response.GetAllBrandsResponse;
import com.example.RentACar.business.response.GetByIDBrandResponse;
import com.example.RentACar.business.rules.BrandBusinessRules;
import com.example.RentACar.core.utilities.mappers.ModelMapperService;
import com.example.RentACar.dataAccess.abstracts.BrandRepository;
import com.example.RentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;
    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses = brands.stream()
                .map(brand->this.modelMapperService.forResponse().
                map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponses;
    }
    @Override
    public void add(CreateBrandRequest createBrandRequest){
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIDBrandResponse getByID(int id) {
        Optional<Brand> brand = brandRepository.findById(id);
        GetByIDBrandResponse response = this.modelMapperService.forResponse()
                .map(brand,GetByIDBrandResponse.class);
        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
