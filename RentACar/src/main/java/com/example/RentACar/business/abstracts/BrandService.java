package com.example.RentACar.business.abstracts;

import com.example.RentACar.business.request.CreateBrandRequest;
import com.example.RentACar.business.request.UpdateBrandRequest;
import com.example.RentACar.business.response.GetAllBrandsResponse;
import com.example.RentACar.business.response.GetByIDBrandResponse;
import java.util.List;
public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);
    GetByIDBrandResponse getByID(int id);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
