package com.uni.medical.umdiagnostic.service;

import com.uni.medical.umdiagnostic.dao.entity.TreatmentMethod;

import java.util.List;

public interface TreatmentMethodService {
    List<TreatmentMethod> getAllTreatmentMethod();
    TreatmentMethod getTreatmentMethodById(long id);
    long saveTreatmentMethod(TreatmentMethod treatmentMethod);
    TreatmentMethod updateTreatmentMethod(Long id, TreatmentMethod method);
    void deleteTreatmentMethodById(long id);
    boolean isTreatmentMethodExist(long id);
    boolean isTreatmentMethodExist(TreatmentMethod method);
}