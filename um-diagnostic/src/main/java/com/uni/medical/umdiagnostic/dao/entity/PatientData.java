package com.uni.medical.umdiagnostic.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "patient_data")

public class PatientData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;

    @Column(name = "patient_card_id", nullable = false)
    private Long patientCardId;

    @Column(name = "allergies", nullable = false)
    private String allergies;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

    @Column(name = "notice", nullable = false)
    private String notice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private PatientCard patientCard;
    public PatientCard getPatientCard() {
        return patientCard;
    }
    public void setPatientCard(PatientCard patientCard) {
        this.patientCard = patientCard;
    }

    public PatientData(){}

    public PatientData(Long patientCardId, String allergies, Integer age, String bloodGroup, String notice) {
        this.patientCardId = patientCardId;
        this.allergies = allergies;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.notice = notice;
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

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "PatientData{" +
                "id=" + id +
                ", patientCardId=" + patientCardId +
                ", allergies='" + allergies + '\'' +
                ", age=" + age +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", notice='" + notice + '\'' +
                '}';
    }
}