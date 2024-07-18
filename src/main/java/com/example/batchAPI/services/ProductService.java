package com.example.batchAPI.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.batchAPI.repository.ProductRepository;
import com.example.batchAPI.dto.request.BatchProductRequest;


@Service
public class ProductService {

   @Autowired
   private ProductRepository productRepository;

   @Transactional
   public void batchProcess(BatchProductRequest batchProductRequest) {
      if (batchProductRequest.getProductsToAdd() != null) {
         productRepository.saveAll(batchProductRequest.getProductsToAdd());
      }
      if (batchProductRequest.getProductsToUpdate() != null) {
         productRepository.saveAll(batchProductRequest.getProductsToUpdate());
      }
      if (batchProductRequest.getProductIdsToDelete() != null) {
         for (Integer id : batchProductRequest.getProductIdsToDelete()) {
            productRepository.deleteById(id);
         }
      }
   }

   
}
