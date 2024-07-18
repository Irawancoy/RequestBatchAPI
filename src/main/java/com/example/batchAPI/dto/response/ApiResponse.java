package com.example.batchAPI.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
   private String message;
   private int statusCode;
   private Object data;
   
}
