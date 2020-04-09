package com.codeorange.api.management.customerservice.bean;

import com.github.fabiomaffioletti.firebase.document.FirebaseDocument;
import com.github.fabiomaffioletti.firebase.document.FirebaseId;

import java.util.Date;

import static com.codeorange.api.management.customerservice.util.DateUtil.getAgeFromBirthDate;

@FirebaseDocument("/customers")
public class Customer {

    @FirebaseId
    private String id;

    private String firstName;
    private String lastName;
    private String birthDate;
    private String createdAt;

    public String getId() {
        return id;
    }

    public String getCode() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getAge() {
        return getAgeFromBirthDate(this.birthDate);
    }

}
