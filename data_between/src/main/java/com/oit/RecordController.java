package com.oit;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RecordController {
    @Autowired
    private RecordRepository recordRepository;
    
    @Autowired
    private RecordService recordService;	

    @GetMapping("/records")
    public List<Record> getRecordsBetweenDates(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return recordRepository.findByDateBetween(startDate, endDate);
    }
    
    @PostMapping("/records")
    public Record addRecord(@RequestBody Record record) {
        return recordService.addRecord(record);
    }
}
