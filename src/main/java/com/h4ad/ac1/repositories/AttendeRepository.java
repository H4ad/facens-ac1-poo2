package com.h4ad.ac1.repositories;

import com.h4ad.ac1.entities.Attende;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeRepository extends JpaRepository<Attende, Long>, JpaSpecificationExecutor<Attende>{

    @Nullable
    Attende findByEmail(@Nullable String email); 
    
}