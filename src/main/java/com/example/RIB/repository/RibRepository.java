package com.example.RIB.repository;

import com.example.RIB.entity.Rib;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RibRepository extends JpaRepository<Rib,Integer> {

    List<Rib> findRibById(Integer id);
}
