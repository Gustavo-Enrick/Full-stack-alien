package com.api.alienback.controller;

import com.api.alienback.DTOs.AlienDTO;
import com.api.alienback.model.AlienModel;
import com.api.alienback.repository.AlienRepository;
//import com.api.alienback.service.ResetIdService;
import com.api.alienback.service.UniqueObjetcService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
@AllArgsConstructor
public class AlienController {

    @Autowired
    private final AlienRepository alienRepository;

//    @Autowired
//    private final ResetIdService resetId;

    @Autowired
    private final UniqueObjetcService uniqueObjetcService;

    @GetMapping("/")
    public ResponseEntity<List<AlienModel>> getListAliens(){
        List<AlienModel> users = alienRepository.findAll();
        if(users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(users);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlienModel> getAlienById(@PathVariable Long id) {
        Optional<AlienModel> optionalAlien = alienRepository.findById(id);
        if (optionalAlien.isPresent()) {
            AlienModel alien = optionalAlien.get();
            return ResponseEntity.ok().body(alien);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<HttpStatus> createUser(@RequestBody AlienDTO alienDTO){
        //valida se o alienDto está de acordo
       if(uniqueObjetcService.valideFieldsService(alienDTO)){
           if(!(uniqueObjetcService.isUnique(alienDTO.email()))){
               var alien = new AlienModel(alienDTO);
               saveUser(alien);
               return ResponseEntity.status(HttpStatus.CREATED).build();
           }else{
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
           }
       } else {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
    }


    public void saveUser(AlienModel user){ alienRepository.save(user);}

}
