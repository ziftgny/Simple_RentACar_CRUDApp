package com.example.RentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="models")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;
    @OneToMany(mappedBy = "model")
    private List<Car> cars;
}
