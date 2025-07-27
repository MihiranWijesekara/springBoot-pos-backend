package com.example.demo.controller;

import com.example.demo.dto.IteamDTO;
import com.example.demo.dto.request.RequestSaveIteamDTO;
import com.example.demo.service.IteamService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/iteam")
@CrossOrigin

public class  IteamController {
    @Autowired
    private IteamService iteamService;

    @PostMapping(path = "/save")
    public  String saveIteam(@RequestBody RequestSaveIteamDTO  iteamDTO){
        iteamService.addIteam(iteamDTO);
        return "Iteam saved successfully";
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name")
    public List<IteamDTO> getCustomerById(@RequestParam(value = "name") String itemName){
        List<IteamDTO> iteamDTOList = iteamService.getIteamByName(itemName);
        return iteamDTOList;
    }

    @GetMapping(
            path = {"/get-all-item"}
    )
    public ResponseEntity<StandardResponse> getAllItems() {
        List<IteamDTO> iteamDTOS = iteamService.getAllItems();
//        if (iteamDTOS.isEmpty()) {
//            return new ResponseEntity<>(
//                    new StandardResponse(404, "No items found", null),
//                    HttpStatus.NOT_FOUND
//            );
//        }
            return new ResponseEntity<>(
                    new StandardResponse(200, "Success", iteamDTOS),
                    HttpStatus.OK
            );


        }

}
