package com.uni.medical.umdiagnostic.dto;

import java.io.Serializable;

public class MedicalTestDTO implements Serializable {
    private Long id;
    private Long medicalTestId;
    private Long treatmentId;

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
}
