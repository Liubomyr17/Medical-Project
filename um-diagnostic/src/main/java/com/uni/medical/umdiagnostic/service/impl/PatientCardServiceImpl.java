package com.uni.medical.umdiagnostic.service.impl;

import com.uni.medical.umdiagnostic.dao.PatientCardRepository;
import com.uni.medical.umdiagnostic.dao.entity.PatientCard;
import com.uni.medical.umdiagnostic.service.PatientCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PatientCardServiceImpl implements PatientCardService {

    @Autowired
    private PatientCardRepository repository;

    @Override
    public List<PatientCard> getAllPatientCard() {
        return repository.findAll();
    }

    @Override
    public PatientCard getPatientCardById(long id) {
        return repository.findOne(id);
    }

    @Override
    public long savePatientCard(PatientCard patientCard) {
        PatientCard card = repository.save(patientCard);
        return card.getId();
    }

    @Override
    public PatientCard updatePatientCard(Long id, PatientCard card){
        PatientCard currentCard = repository.findOne(id);
        if (currentCard == null) {
            throw new RuntimeException("could not find card by id:" + id);
        }
        currentCard.setPatientId(card.getPatientId());
        currentCard.setDoctorId(card.getDoctorId());
        currentCard.setCreateDate(card.getCreateDate());
        currentCard.setLastUpdatedDate(card.getLastUpdatedDate());
        currentCard.setStatus(card.getStatus());
        this.repository.save(currentCard);
        return currentCard;    }

    @Override
    public void deletePatientCardById(long id) {
        repository.delete(id);
    }

    @Override
    public boolean isPatientCardExist(long id) {
        return repository.findOne(id) != null ? true : false;
    }

    @Override
    public boolean isPatientCardExist(PatientCard card) {
        return false;
    }
}