package com.example.demo.dto;


import com.example.demo.entity.enums.MessuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IteamDTO {

    private int itemId;
    private String itemName;
    private MessuringUnitType messuringUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;

}
