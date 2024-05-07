package com.example.doctorpoint;

public class model {
    String name,qualification,address,experience,charges;

    public model() {

    }

    public model(String name, String qualification, String address, String experience, String charges) {
        this.name = name;
        this.qualification = qualification;
        this.address = address;
        this.experience = experience;
        this.charges = charges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }
}
