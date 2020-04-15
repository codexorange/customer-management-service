package com.codeorange.api.management.customerservice.bean;

import com.github.fabiomaffioletti.firebase.document.FirebaseDocument;
import com.github.fabiomaffioletti.firebase.document.FirebaseId;

import static com.codeorange.api.management.customerservice.util.DateUtil.getDateFromString;

@FirebaseDocument("/customers")
public class Customer implements Comparable<Customer> {

    @FirebaseId
    private String id;

    private String firstName;
    private String lastName;
    private String birthDate;
    private int age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int compareTo(Customer c) {
        if (getDateFromString(getCreatedAt()) == null ||
            getDateFromString(c.getCreatedAt()) == null) {
            return 0;
        }
        return getDateFromString(c.getCreatedAt()).compareTo(getDateFromString(getCreatedAt()));
    }

}
