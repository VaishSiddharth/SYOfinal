package com.example.siddharthvaish.syo;

/**
 * Created by Siddharth Vaish on 4/7/2018.
 */

public class product {
    String itemId;
    String name;
    String email;
    String adress;
    String specification;
    String phone;
    String category;
    String condition;
    String price;

    public product(String itemId, String name, String email, String adress, String specification, String phone, String category, String condition, String price) {
        this.itemId =itemId;
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.specification = specification;
        this.phone = phone;
        this.category = category;
        this.condition = condition;
        this.price=price;
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;

    }

    public product(){}

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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
