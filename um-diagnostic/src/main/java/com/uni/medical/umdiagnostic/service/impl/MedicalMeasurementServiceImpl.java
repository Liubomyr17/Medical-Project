package com.uni.medical.umdiagnostic.service.impl;

import com.uni.medical.umdiagnostic.dao.MedicalMeasurementRepository;
import com.uni.medical.umdiagnostic.dao.entity.MedicalMeasurement;
import com.uni.medical.umdiagnostic.service.MedicalMeasurementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MedicalMeasurementServiceImpl implements MedicalMeasurementService {

    @Autowired
    private MedicalMeasurementRepository repository;

    @Override
    public List<MedicalMeasurement> getAllMedicalMeasurement() {
        return repository.findAll();
    }

    @Override
    public MedicalMeasurement getMedicalMeasurementById(long id) {
        return repository.findOne(id);
    }

    @Override
    public long saveMedicalMeasurement(MedicalMeasurement medicalMeasurement) {
        MedicalMeasurement measurement = repository.save(medicalMeasurement);
        return measurement.getId();
    }

    @Override
    public MedicalMeasurement updateMedicalMeasurement(Long id, MedicalMeasurement measurement) {
        MedicalMeasurement currentMeasurement = repository.findOne(id);
        if (currentMeasurement == null) {
            throw new RuntimeException("could not find measurement by id:" + id);
        }
        currentMeasurement.setPatientCardId(measurement.getPatientCardId());
        currentMeasurement.setDate(measurement.getDate());
        currentMeasurement.setHeight(measurement.getHeight());
        currentMeasurement.setWeight(measurement.getWeight());
        currentMeasurement.setBodyArea(measurement.getBodyArea());
        currentMeasurement.setPulse(measurement.getPulse());
        currentMeasurement.setTemperature(measurement.getTemperature());
        currentMeasurement.setBloodPressHeight(measurement.getBloodPressHeight());
        currentMeasurement.setBloodPressLow(measurement.getBloodPressLow());
        this.repository.save(currentMeasurement);
        return currentMeasurement;
    }

    @Override
    public void deleteMedicalMeasurementById(long id) {
        repository.delete(id);
    }

    @Override
    public boolean isMedicalMeasurementExist(long id) {
        return repository.findOne(id) != null ? true : false;
    }

    @Override
    public boolean isMedicalMeasurementExist(MedicalMeasurement measurement) {
        return false;
    }
}
