package com.example.demo.repository;
import com.example.demo.entitiy.Magaza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazaRepository extends JpaRepository<Magaza, Long> {
}
