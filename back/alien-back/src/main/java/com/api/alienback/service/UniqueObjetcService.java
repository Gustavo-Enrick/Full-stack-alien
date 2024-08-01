package com.api.alienback.service;

import com.api.alienback.DTOs.AlienDTO;
import com.api.alienback.model.AlienModel;
import com.api.alienback.repository.AlienRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UniqueObjetcService {
    @Autowired
    private final AlienRepository alienRepository;

    public boolean isUnique(String email){
        Optional<AlienModel> exist = alienRepository.findByEmail(email);
        return exist.isPresent();
    }

    public boolean valideFieldsService(AlienDTO alienDTO){
        return !(alienDTO.name().isBlank() && alienDTO.email().isBlank() && alienDTO.password().isBlank());
    }
}
