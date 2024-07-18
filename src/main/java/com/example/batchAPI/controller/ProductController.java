package com.example.batchAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.batchAPI.dto.request.BatchProductRequest;
import com.example.batchAPI.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/products")
public class ProductController {
   @Autowired
   private ProductService productService;

   @PostMapping(
      path ={"batch"},consumes = {
         MediaType.APPLICATION_JSON_VALUE,
         MediaType.MULTIPART_FORM_DATA_VALUE
          },produces={MediaType.APPLICATION_JSON_VALUE})

   public ResponseEntity<?> batchProcess(@RequestPart("request") BatchProductRequest request) {
      return productService.batchProcess(request);

   }

}
