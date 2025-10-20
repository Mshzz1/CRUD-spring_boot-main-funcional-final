package com.example.cadastro_peixe.infrastructure.repository;

import com.example.cadastro_peixe.infrastructure.entitys.Peixe;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeixeRepository extends JpaRepository<Peixe, Integer> {
    Optional<Peixe> findById(Integer id);

    @Transactional
    void deleteById(Integer id);
}
