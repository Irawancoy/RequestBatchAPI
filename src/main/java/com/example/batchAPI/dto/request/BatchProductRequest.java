package com.example.batchAPI.dto.request;

import java.util.List;

import com.example.batchAPI.model.ProductModel;

import lombok.*;

@Data
public class BatchProductRequest {
   private List<ProductModel> productsToAdd;
   private List<ProductModel> productsToUpdate;
   private List<Integer> productIdsToDelete;

   
}
