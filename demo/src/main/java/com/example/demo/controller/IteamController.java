package com.example.demo.controller;

import com.example.demo.dto.IteamDTO;
import com.example.demo.dto.request.RequestSaveIteamDTO;
import com.example.demo.service.IteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/iteam")
@CrossOrigin

public class IteamController {
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
    public List <IteamDTO> getAllItems(){
        List<IteamDTO> itemDTOS = iteamService.getAllItems();
        return itemDTOS;
    }
}
