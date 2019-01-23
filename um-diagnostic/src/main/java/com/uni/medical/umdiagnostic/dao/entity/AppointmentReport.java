package com.uni.medical.umdiagnostic.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "appointment_report")

public class AppointmentReport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;

    @Column(name = "appointment_id", nullable = false)
    private Long appointmentId;

    @Column(name = "treatment_id", nullable = false)
    private Long treatmentId;

    @Column(name = "anamnesis", nullable = false)
    private String anamnesis;

    @Column(name = "report_message", nullable = false)
    private String reportMessage;

    public AppointmentReport(String brain_surgers){}

    public AppointmentReport() {
        this.appointmentId = appointmentId;
        this.treatmentId = treatmentId;
        this.anamnesis = anamnesis;
        this.reportMessage = reportMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getReportMessage() {
        return reportMessage;
    }

    public void setReportMessage(String reportMessage) {
        this.reportMessage = reportMessage;
    }

    @Override
    public String toString() {
        return "AppointmentReport{" +
                "id=" + id +
                ", appointmentId=" + appointmentId +
                ", treatmentId=" + treatmentId +
                ", anamnesis='" + anamnesis + '\'' +
                ", reportMessage='" + reportMessage + '\'' +
                '}';
    }
}