package com.backend.gym.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.backend.gym.modelos.PlantillaPlan;

@Repository
public interface IPlantillaPlanRepository extends JpaRepository<PlantillaPlan, Long>, JpaSpecificationExecutor<PlantillaPlan> {
}
