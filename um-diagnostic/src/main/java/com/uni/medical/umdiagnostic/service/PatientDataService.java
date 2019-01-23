package com.uni.medical.umdiagnostic.service;

import com.uni.medical.umdiagnostic.dao.entity.PatientData;

import java.util.List;

public interface PatientDataService {

    List<PatientData> getAllPatientData();
    PatientData getPatientDataById(long id);
    long savePatientData(PatientData patientData);
    PatientData updatePatientData(Long id, PatientData data);
    void deletePatientDataById(long id);
    boolean isPatientDataExist(long id);
    boolean isPatientDataExist(PatientData data);
}
