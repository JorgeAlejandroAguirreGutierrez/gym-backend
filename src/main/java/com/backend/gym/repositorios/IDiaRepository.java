package com.backend.gym.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.backend.gym.modelos.Dia;

@Repository
public interface IDiaRepository extends JpaRepository<Dia, Long>, JpaSpecificationExecutor<Dia> {

}
