package com.uni.medical.umdiagnostic.dto;

import java.io.Serializable;
import java.sql.Date;

public class MedicalMeasurementDTO implements Serializable {

    private Long id;
    private Long patientCardId;
    private Date date;
    private Double height;
    private Double weight;
    private String bodyArea;
    private Integer pulse;
    private Double temperature;
    private Integer bloodPressHeight;
    private Integer bloodPressLow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientCardId() {
        return patientCardId;
    }

    public void setPatientCardId(Long patientCardId) {
        this.patientCardId = patientCardId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getBodyArea() {
        return bodyArea;
    }

    public void setBodyArea(String bodyArea) {
        this.bodyArea = bodyArea;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getBloodPressHeight() {
        return bloodPressHeight;
    }

    public void setBloodPressHeight(Integer bloodPressHeight) {
        this.bloodPressHeight = bloodPressHeight;
    }

    public Integer getBloodPressLow() {
        return bloodPressLow;
    }

    public void setBloodPressLow(Integer bloodPressLow) {
        this.bloodPressLow = bloodPressLow;
    }
}