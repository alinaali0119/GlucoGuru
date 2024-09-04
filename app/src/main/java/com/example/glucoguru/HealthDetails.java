package com.example.glucoguru;

public class HealthDetails {
    private String id;
    private static String fullName;
    private String age;
    private String gender;
    private String medicalConditions;
    private String medications;
    private String smokingStatus;
    private String alcoholConsumption;
    private String height;
    private String weight;
    private String glucose;
    private String insulin;
    private String bmi;
    private String bloodPressure;
    private String diabetesPedigree;

    public HealthDetails() {
    }

    public HealthDetails(String id, String fullName, String age, String gender, String medicalConditions, String medications, String smokingStatus, String alcoholConsumption, String height, String weight, String glucose, String insulin, String bmi, String bloodPressure, String diabetesPedigree) {
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
        this.glucose = glucose;
        this.insulin = insulin;
        this.bmi = bmi;
        this.bloodPressure = bloodPressure;
        this.diabetesPedigree = diabetesPedigree;
    }

    public String getId() {
        return id;
    }

    public static String getFullName() {
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
    public String getGlucose() {
        return glucose;
    }
    public String getInsulin() {
        return insulin;
    }
    public String getBmi() {
        return bmi;
    }
    public String getBloodPressure() {
        return bloodPressure;
    }
    public String getDiabetesPedigree() {
        return diabetesPedigree;
    }
}
