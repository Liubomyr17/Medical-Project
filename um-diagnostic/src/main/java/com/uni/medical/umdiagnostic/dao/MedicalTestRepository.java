package com.uni.medical.umdiagnostic.dao;


import com.uni.medical.umdiagnostic.dao.entity.MedicalTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalTestRepository extends JpaRepository<MedicalTest, Long> {
    MedicalTest findMedicalTestByMedicalTestId(long patientId);
}
