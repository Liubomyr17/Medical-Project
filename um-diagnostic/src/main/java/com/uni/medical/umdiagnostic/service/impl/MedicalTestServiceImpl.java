package com.uni.medical.umdiagnostic.service.impl;

import com.uni.medical.umdiagnostic.dao.MedicalTestRepository;
import com.uni.medical.umdiagnostic.dao.entity.MedicalTest;
import com.uni.medical.umdiagnostic.service.MedicalTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MedicalTestServiceImpl implements MedicalTestService {

    @Autowired
    private MedicalTestRepository repository;

    @Override
    public List<MedicalTest> getAllMedicalTest() {
        return repository.findAll();
    }

    @Override
    public MedicalTest getMedicalTestById(long id) {
        return repository.findOne(id);
    }

    @Override
    public long saveMedicalTest(MedicalTest medicalTest) {
        MedicalTest test = repository.save(medicalTest);
        return test.getId();
    }

    @Override
    public MedicalTest updateMedicalTest(Long id, MedicalTest test) {
        MedicalTest currentTest = repository.findOne(id);
        if (currentTest == null) {
            throw new RuntimeException("could not find test by id:" + id);
        }
        currentTest.setMedicalTestId(test.getMedicalTestId());
        currentTest.setTreatmentId(test.getTreatmentId());
        this.repository.save(currentTest);
        return currentTest;
    }

    @Override
    public void deleteMedicalTestById(long id) {
        repository.delete(id);
    }

    @Override
    public boolean isMedicalTestExist(long id) {
        return repository.findOne(id) != null ? true : false;
    }

    @Override
    public boolean isMedicalTestExist(MedicalTest test) {
        return false;
    }
}


