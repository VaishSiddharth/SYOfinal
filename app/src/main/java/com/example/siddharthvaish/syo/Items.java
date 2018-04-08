package com.example.siddharthvaish.syo;

/**
 * Created by kidd on 4/7/2018.
 */

public class Items {

    String itemId,name,email,adress,specification,phone,category,condition,price;

    public Items(){}


    public Items(String itemId, String name, String email, String adress, String specification, String phone, String category, String condition,String price) {
        this.itemId =itemId;
        this.price =price;
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.specification = specification;
        this.phone = phone;
        this.category = category;
        this.condition = condition;
    }

    public String getPrice() {
        return price;
    }
    public String getItemId() {
        return itemId;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }

    public String getSpecification() {
        return specification;
    }

    public String getPhone() {
        return phone;
    }

    public String getCategory() {
        return category;
    }

    public String getCondition() {
        return condition;
    }
}