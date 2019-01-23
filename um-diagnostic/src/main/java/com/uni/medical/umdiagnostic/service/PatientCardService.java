package com.uni.medical.umdiagnostic.service;

import com.uni.medical.umdiagnostic.dao.entity.PatientCard;

import java.util.List;

public interface PatientCardService {
    List<PatientCard> getAllPatientCard();
    PatientCard getPatientCardById(long id);
    long savePatientCard(PatientCard patientCard);
    PatientCard updatePatientCard(Long id, PatientCard card);
    void deletePatientCardById(long id);
    boolean isPatientCardExist(long id);
    boolean isPatientCardExist(PatientCard card);
}
