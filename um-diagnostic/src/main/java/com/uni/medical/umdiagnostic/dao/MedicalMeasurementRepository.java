package com.uni.medical.umdiagnostic.dao;

import com.uni.medical.umdiagnostic.dao.entity.MedicalMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalMeasurementRepository extends JpaRepository<MedicalMeasurement, Long> {
    MedicalMeasurement findMedicalMeasurementByPatientCardId(long patientId);
}