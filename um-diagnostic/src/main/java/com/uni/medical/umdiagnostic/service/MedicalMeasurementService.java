package com.uni.medical.umdiagnostic.service;

import com.uni.medical.umdiagnostic.dao.entity.MedicalMeasurement;

import java.util.List;

public interface MedicalMeasurementService {

    List<MedicalMeasurement> getAllMedicalMeasurement();
    MedicalMeasurement getMedicalMeasurementById(long id);
    long saveMedicalMeasurement(MedicalMeasurement medicalMeasurement);
    MedicalMeasurement updateMedicalMeasurement(Long id, MedicalMeasurement measurement);
    void deleteMedicalMeasurementById(long id);
    boolean isMedicalMeasurementExist(long id);
    boolean isMedicalMeasurementExist(MedicalMeasurement measurement);
}
