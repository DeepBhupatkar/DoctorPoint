package com.example.doctorpoint;

public class doctor
{
    String name,email,phone,qualification,experience,charges,address,password;

    public doctor()
    {

    }

    public doctor(String name, String email, String phone, String qualification, String experience, String charges, String address,String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.qualification = qualification;
        this.experience = experience;
        this.charges = charges;
        this.address = address;
        this.password=password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
