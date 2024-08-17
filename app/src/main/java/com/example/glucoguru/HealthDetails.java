package com.example.glucoguru;

public class HealthDetails {
    private String id;
    private String fullName;
    private String age;
    private String gender;
    private String medicalConditions;
    private String medications;
    private String smokingStatus;
    private String alcoholConsumption;
    private String height;
    private String weight;

    public HealthDetails() {
    }

    public HealthDetails(String id, String fullName, String age, String gender, String medicalConditions, String medications, String smokingStatus, String alcoholConsumption, String height, String weight) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.medicalConditions = medicalConditions;
        this.medications = medications;
        this.smokingStatus = smokingStatus;
        this.alcoholConsumption = alcoholConsumption;
        this.height = height;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public String getMedications() {
        return medications;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public String getAlcoholConsumption() {
        return alcoholConsumption;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }
}
