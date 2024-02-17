package com.example.RentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "plate" ,unique=true)
    private String plate;
    @Column(name = "dailyprice")
    private double dailyPrice;
    @Column(name = "model_year")
    private double modelYear;
    @Column(name="state")
    private int state;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
