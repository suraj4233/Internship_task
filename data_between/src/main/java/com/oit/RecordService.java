package com.oit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;

    public Record addRecord(Record record) {
        return recordRepository.save(record);
    }
}
