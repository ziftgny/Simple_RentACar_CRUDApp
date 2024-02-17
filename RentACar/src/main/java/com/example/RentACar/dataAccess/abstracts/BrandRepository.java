package com.example.RentACar.dataAccess.abstracts;

import com.example.RentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name);
}
