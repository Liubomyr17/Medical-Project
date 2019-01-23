package com.uni.medical.umdiagnostic.service;

import com.uni.medical.umdiagnostic.dao.entity.MedicalTest;

import java.util.List;

public interface MedicalTestService {

    List<MedicalTest> getAllMedicalTest();
    MedicalTest getMedicalTestById(long id);
    long saveMedicalTest(MedicalTest medicalTest);
    MedicalTest updateMedicalTest(Long id, MedicalTest test);
    void deleteMedicalTestById(long id);
    boolean isMedicalTestExist(long id);
    boolean isMedicalTestExist(MedicalTest test);
}
