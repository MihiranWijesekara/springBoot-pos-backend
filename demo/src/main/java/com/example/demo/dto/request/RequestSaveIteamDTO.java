package com.example.demo.dto.request;

import com.example.demo.entity.enums.MessuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestSaveIteamDTO {


    private String itemName;
    private MessuringUnitType messuringUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;

}
