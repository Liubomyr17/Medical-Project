package com.uni.medical.umdiagnostic.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "treatment_method")

public class TreatmentMethod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "patient_card_id", nullable = false)
    private Long patientCardId;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "finish_date", nullable = false)
    private Date finishDate;

    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "treatment_id")
    private List<MedicalTest> medicalTests = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "treatment_id")
    private List<AppointmentReport> appointmentReports = new ArrayList<>();

    public TreatmentMethod(){}

    public TreatmentMethod(Long patientCardId, Date startDate, Date finishDate, String diagnosis, String description, String status) {
        this.patientCardId = patientCardId;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.diagnosis = diagnosis;
        this.description = description;
        this.status = status;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TreatmentMethod{" +
                "id=" + id +
                ", patientCardId=" + patientCardId +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", diagnosis='" + diagnosis + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}