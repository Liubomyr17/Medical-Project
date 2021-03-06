package com.uni.medical.umdiagnostic.dao;

import com.uni.medical.umdiagnostic.dao.entity.PatientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCardRepository extends JpaRepository<PatientCard, Long> {
    PatientCard findPatientCardByPatientId(Long patientId);
}