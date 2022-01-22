package com.example.runWith.controller;

import com.example.runWith.domain.RecordDomain;
import com.example.runWith.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/find")
    public RecordDomain findRecord(@RequestParam("id") String id, @RequestParam("day") String day) {
        return recordService.findRecord(id, day);
    }

    @PostMapping("/add")
    public void addRecord(@RequestBody RecordDomain newRecord) { recordService.addRecord(newRecord);}
}
