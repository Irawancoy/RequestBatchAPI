package com.example.batchAPI.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.batchAPI.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

import com.example.batchAPI.dto.request.BatchProductRequest;

import org.springframework.http.HttpStatus;

import com.example.batchAPI.dto.response.MessageResponse;
import com.example.batchAPI.dto.response.ApiResponse;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductService {

   @Autowired
   private ProductRepository productRepository;

   @Transactional
   public ResponseEntity<Object> batchProcess(BatchProductRequest batchProductRequest) {
      String responseAdd;
      List<String> responseUpdate = new ArrayList<String>();
      List<String> responseDelete = new ArrayList<String>();

      log.info(batchProductRequest.getProductsToAdd().toString());
      try {
         if (!batchProductRequest.getProductsToAdd().isEmpty()) {
            productRepository.saveAll(batchProductRequest.getProductsToAdd());
            responseAdd = "Products Added Successfully";
         } else {
            responseAdd = "No data to add";
         }

         if (!batchProductRequest.getProductsToUpdate().isEmpty()) {
            if (batchProductRequest.getProductsToUpdate().size() > 0) {
               for (int i = 0; i < batchProductRequest.getProductsToUpdate().size(); i++) {
                  if (!productRepository.existsById(batchProductRequest.getProductsToUpdate().get(i).getId())) {
                     responseUpdate.add(
                           "Product with id " + batchProductRequest.getProductsToUpdate().get(i).getId()
                                 + " not found");
                  } else {
                     productRepository.save(batchProductRequest.getProductsToUpdate().get(i));
                     responseUpdate.add("Product with id " + batchProductRequest.getProductsToUpdate().get(i).getId()
                           + " updated successfully");
                  }

               }
            }
         } else {
            responseUpdate.add("No data to update");
         }

         if (!batchProductRequest.getProductIdsToDelete().isEmpty()) {
            for (Integer id : batchProductRequest.getProductIdsToDelete()) {
               if (productRepository.existsById(id)) {
                  productRepository.deleteById(id);
                  responseDelete.add("Product with id " + id + " deleted successfully");

               } else {
                  responseDelete.add("Product with id " + id + " not found");
               }
            }
         } else {
            responseDelete.add("No data to delete");
         }

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in Batch Processing");
      }
      MessageResponse messageResponse = new MessageResponse(responseAdd, responseUpdate, responseDelete);
      ApiResponse apiResponse = new ApiResponse("Products Batch Processed Successfully", HttpStatus.OK.value(),
            messageResponse);
      return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
   }

   public ResponseEntity<Object> getAllProducts() {
      if (productRepository.findAll().isEmpty()) {
         ApiResponse apiResponse = new ApiResponse("No Products Found", HttpStatus.OK.value(), null);
         return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
      } else {
         ApiResponse apiResponse = new ApiResponse("Products Found", HttpStatus.OK.value(), productRepository.findAll());
         return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
      }
   }

   
}
