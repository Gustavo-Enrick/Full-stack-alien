package com.api.alienback.repository;

import com.api.alienback.model.AlienModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlienRepository extends JpaRepository <AlienModel,Long> {

    Optional<AlienModel> findByEmail(String email);


}
