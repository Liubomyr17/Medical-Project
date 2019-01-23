package com.uni.medical.umdiagnostic.dto;

import java.io.Serializable;

public class PatientDataDTO implements Serializable {

    private Long id;
    private Long patientCardId;
    private String allergies;
    private Integer age;
    private String bloodGroup;
    private String notice;

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
}
