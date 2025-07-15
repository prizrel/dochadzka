package com.example.dochadzka.repository;

import com.example.dochadzka.model.Tabulka;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TabulkaRepository extends JpaRepository<Tabulka, Long> {
    List<Tabulka> findAllByOrderByDatumAsc();
}