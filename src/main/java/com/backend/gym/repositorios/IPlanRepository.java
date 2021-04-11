package com.backend.gym.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.backend.gym.modelos.Plan;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Long>, JpaSpecificationExecutor<Plan> {
}
