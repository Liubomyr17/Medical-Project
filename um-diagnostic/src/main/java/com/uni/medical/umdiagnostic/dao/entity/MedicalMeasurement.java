package com.uni.medical.umdiagnostic.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medical_measurement")

public class MedicalMeasurement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "patient_card_id", nullable = false)
    private Long patientCardId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "height", nullable = false)
    private Double height;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "body_area", nullable = false)
    private String bodyArea;

    @Column(name = "pulse", nullable = false)
    private Integer pulse;

    @Column(name = "temperature", nullable = false)
    private Double temperature;

    @Column(name = "blood_press_height", nullable = false)
    private Integer bloodPressHeight;

    @Column(name = "blood_press_low", nullable = false)
    private Integer bloodPressLow;

    public MedicalMeasurement(){}

    public MedicalMeasurement(Long patientCardId, Date date, Double height, Double weight, String bodyArea, Integer pulse, Double temperature, Integer bloodPressHeight, Integer bloodPressLow) {
        this.patientCardId = patientCardId;
        this.date = date;
        this.height = height;
        this.weight = weight;
        this.bodyArea = bodyArea;
        this.pulse = pulse;
        this.temperature = temperature;
        this.bloodPressHeight = bloodPressHeight;
        this.bloodPressLow = bloodPressLow;
    }

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

    @Override
    public String toString() {
        return "MedicalMeasurement{" +
                "id=" + id +
                ", patientCardId=" + patientCardId +
                ", date=" + date +
                ", height=" + height +
                ", weight=" + weight +
                ", bodyArea='" + bodyArea + '\'' +
                ", pulse=" + pulse +
                ", temperature=" + temperature +
                ", bloodPressHeight=" + bloodPressHeight +
                ", bloodPressLow=" + bloodPressLow +
                '}';
    }
}