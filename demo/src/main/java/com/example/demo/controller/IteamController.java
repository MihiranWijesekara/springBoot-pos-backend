package com.example.demo.controller;

import com.example.demo.dto.IteamDTO;
import com.example.demo.dto.paginated.PaginatedResponseItemDTO;
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
    @GetMapping(path = "/get-all-items")
    public ResponseEntity<StandardResponse> getAllItems() {
        List<IteamDTO> iteamDTOList = iteamService.getAllItems();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", iteamDTOList),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = {"/get-all-item-active"},
            params = {"page", "size","activeState"}
    )
    public  ResponseEntity<StandardResponse> getAllItemsActive(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size")  int size,
            @RequestParam(value = "activeState") boolean activeState
    ) {

        PaginatedResponseItemDTO paginatedResponseItemDTO = iteamService.getAllItemsActive(page,size,activeState);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", paginatedResponseItemDTO),
                HttpStatus.OK
        );


    }
}


