package com.example.TaskManager.Services.Interfaces;

import com.example.TaskManager.DTOs.FieldValueDTO;
import com.example.TaskManager.Entities.FieldValue;

import java.util.List;
import java.util.Optional;

public interface FieldValueService {
    FieldValue createFieldValue(FieldValueDTO fieldValueDTO);

    List<FieldValue> getAllFieldValues();

    Optional<FieldValue> findFieldValueById(Long id);

    FieldValue updateFieldValue(FieldValueDTO fieldValueDTO);

    void deleteFieldValueById(Long id);
}
