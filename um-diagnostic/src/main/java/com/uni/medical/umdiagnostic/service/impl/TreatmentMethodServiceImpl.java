package com.uni.medical.umdiagnostic.service.impl;

import com.uni.medical.umdiagnostic.dao.TreatmentMethodRepository;
import com.uni.medical.umdiagnostic.dao.entity.TreatmentMethod;
import com.uni.medical.umdiagnostic.service.TreatmentMethodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TreatmentMethodServiceImpl implements TreatmentMethodService {

    @Autowired
    private TreatmentMethodRepository repository;

    @Override
    public List<TreatmentMethod> getAllTreatmentMethod() {
        return repository.findAll();
    }

    @Override
    public TreatmentMethod getTreatmentMethodById(long id) {
        return repository.findOne(id);
    }

    @Override
    public long saveTreatmentMethod(TreatmentMethod treatmentMethod) {
        TreatmentMethod method = repository.save(treatmentMethod);
        return method.getId();
    }

    @Override
    public TreatmentMethod updateTreatmentMethod(Long id, TreatmentMethod method) {
        TreatmentMethod currentMethod = repository.findOne(id);
        if (currentMethod == null) {
            throw new RuntimeException("could not find report by id:" + id);
        }
        currentMethod.setPatientCardId(method.getPatientCardId());
        currentMethod.setStartDate(method.getStartDate());
        currentMethod.setFinishDate(method.getFinishDate());
        currentMethod.setDiagnosis(method.getDiagnosis());
        currentMethod.setDescription(method.getDescription());
        currentMethod.setStatus(method.getStatus());
        this.repository.save(currentMethod);
        return currentMethod;
    }

    @Override
    public void deleteTreatmentMethodById(long id) {
        repository.delete(id);
    }

    @Override
    public boolean isTreatmentMethodExist(long id) {
        return repository.findOne(id) != null ? true : false;
    }

    @Override
    public boolean isTreatmentMethodExist(TreatmentMethod method) {
        return false;
    }
}