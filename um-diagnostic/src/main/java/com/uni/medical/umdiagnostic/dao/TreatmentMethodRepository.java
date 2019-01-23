package com.uni.medical.umdiagnostic.dao;

import com.uni.medical.umdiagnostic.dao.entity.TreatmentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentMethodRepository extends JpaRepository<TreatmentMethod, Long> {
    TreatmentMethod findTreatmentMethodByPatientCardId(long patientId);
}
