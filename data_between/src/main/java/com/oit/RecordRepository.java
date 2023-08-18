package com.oit;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
