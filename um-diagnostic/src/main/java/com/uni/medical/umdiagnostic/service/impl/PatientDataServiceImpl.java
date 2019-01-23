package com.uni.medical.umdiagnostic.service.impl;

import com.uni.medical.umdiagnostic.dao.PatientDataRepository;
import com.uni.medical.umdiagnostic.dao.entity.PatientData;
import com.uni.medical.umdiagnostic.service.PatientDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PatientDataServiceImpl implements PatientDataService {

    @Autowired
    private PatientDataRepository repository;

    @Override
    public List<PatientData> getAllPatientData() {
        return repository.findAll();
    }

    @Override
    public PatientData getPatientDataById(long id) {
        return repository.findOne(id);
    }

    @Override
    public long savePatientData(PatientData patientData) {
        PatientData data = repository.save(patientData);
        return data.getId();
    }

    @Override
    public PatientData updatePatientData(Long id, PatientData data) {
        PatientData currentData = repository.findOne(id);
        if (currentData == null) {
            throw new RuntimeException("could not find data by id:" + id);
        }
        currentData.setPatientCardId(data.getPatientCardId());
        currentData.setAllergies(data.getAllergies());
        currentData.setAge(data.getAge());
        currentData.setBloodGroup(data.getBloodGroup());
        currentData.setNotice(data.getNotice());
        this.repository.save(currentData);
        return currentData;
    }

    @Override
    public void deletePatientDataById(long id) {
        repository.delete(id);
    }

    @Override
    public boolean isPatientDataExist(long id) {
        return repository.findOne(id) != null ? true : false;
    }

    @Override
    public boolean isPatientDataExist(PatientData data) {
        return false;
    }
}
