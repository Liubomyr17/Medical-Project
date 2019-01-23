package com.uni.medical.umdiagnostic.dao;

import com.uni.medical.umdiagnostic.dao.entity.PatientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDataRepository extends JpaRepository<PatientData, Long> {
    PatientData findPatientDataByPatientCardId(long patientId);
}