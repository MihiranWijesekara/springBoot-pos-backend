package com.example.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", length = 45)
    private int customerId;

    @Version
    private Integer version;

    @Column(name = "customer_name", length = 45, nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 255)
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Type(JsonType.class)  // Updated annotation
    @Column(name = "contact_numbers", columnDefinition = "json")
    private List<String> contactNumbers;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    public Customer(){

    }
    public Customer(int customerId,String customerName,String customerAddress,double customerSalary, List<String> contactNumbers,String nic,boolean activeState ){
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumbers = contactNumbers != null ? contactNumbers : new ArrayList<>();
        this.nic = nic;
        this.activeState = activeState;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public Double getCustomerSalary() {
        return customerSalary;
    }
    public void setCustomerSalary(Double customerSalary) {
        this.customerSalary = customerSalary;
    }
    public List<String> getContactNumbers() {
        return contactNumbers;
    }
    public void setContactNumbers(List<String> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }
    public String getNic() {
        return nic;
    }
    public void setNic(String nic) {
        this.nic = nic;
    }
    public boolean isActiveState() {
        return activeState;
    }
    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }
    @Override
    public  String toString(){
        return  "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                "', customerAddress='" + customerAddress + '\'' +
                ",customerSalary=" +     customerSalary  +
                ", contactNumbers=" + contactNumbers +
                ", nic='" + nic + '\'' +
                ", activeState=" + activeState +
                '}';
    }



}
