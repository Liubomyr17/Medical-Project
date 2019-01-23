package com.uni.medical.umdiagnostic.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient_card")


public class PatientCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "last_updated_date", nullable = false)
    private Date lastUpdatedDate;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_card_id")
    PatientData patientData;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_card_id")
    private List<MedicalMeasurement> medicalMeasurements = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_card_id")
    private List<TreatmentMethod> treatmentMethods = new ArrayList<>();

    public PatientCard(){}

    public PatientCard(Long patientId, Long doctorId, Date createDate, Date lastUpdatedDate, String status) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.createDate = createDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PatientCard{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", createDate=" + createDate +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", status='" + status + '\'' +
                '}';
    }
}