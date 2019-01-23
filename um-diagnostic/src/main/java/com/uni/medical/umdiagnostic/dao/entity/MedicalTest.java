package com.uni.medical.umdiagnostic.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medical_test")

public class MedicalTest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private Long id;

    @Column(name = "medical_test_id", nullable = false)
    private Long medicalTestId;

    @Column(name = "treatment_id", nullable = false)
    private Long treatmentId;

    public MedicalTest(){}

    public MedicalTest(Long medicalTestId, Long treatmentId) {
        this.medicalTestId = medicalTestId;
        this.treatmentId = treatmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMedicalTestId() {
        return medicalTestId;
    }

    public void setMedicalTestId(Long medicalTestId) {
        this.medicalTestId = medicalTestId;
    }

    public Long getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
    }

    @Override
    public String toString() {
        return "MedicalTest{" +
                "id=" + id +
                ", medicalTestId=" + medicalTestId +
                ", treatmentId=" + treatmentId +
                '}';
    }
}