package com.example.demo.entity;

import com.example.demo.entity.enums.MessuringUnitType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@Table(name = "item")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Iteam {

    @Id
    @Column(name = "iteam_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;


    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type", length = 25, nullable = false)
    private MessuringUnitType messuringUnitType; // Must NOT be null

    @Column(name = "balance_qty", length = 50, nullable = false)
    private double balanceQty;

    @Column (name = "supplier_price", length = 50, nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price", length = 50, nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }



}
