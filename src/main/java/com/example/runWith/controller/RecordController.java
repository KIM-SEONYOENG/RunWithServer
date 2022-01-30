package com.example.runWith.controller;

import com.example.runWith.domain.RecordDomain;
import com.example.runWith.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping
    public List<RecordDomain> findAllRecord() {
        return recordService.findAllRecord();
    }


    @GetMapping("/findRecord")
    public RecordDomain findRecord(@RequestParam("id") String id, @RequestParam("day") String day) {
        return recordService.findRecord(id, day);
    }

    @PostMapping("/addRecord")
    public void addRecord(@RequestBody RecordDomain newRecord) { recordService.addRecord(newRecord);}

    @GetMapping("/showRecord")
    public List<RecordDomain> showRecord(@RequestParam("id") String id) { return recordService.showRecord(id); }
}
