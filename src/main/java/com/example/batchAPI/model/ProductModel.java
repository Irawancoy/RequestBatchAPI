package com.example.batchAPI.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class ProductModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   private String category;
   private double price;
   
}
