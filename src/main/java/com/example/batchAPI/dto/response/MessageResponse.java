package com.example.batchAPI.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;


@Data
@AllArgsConstructor
public class MessageResponse {

   private String messageAddData;
   private List<String> messageUpdateData;
   private List<String> messageDeleteData;   
   
}
