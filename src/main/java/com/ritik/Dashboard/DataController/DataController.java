package com.ritik.Dashboard.DataController;

import com.ritik.Dashboard.DataEntity.DataEntity;
import com.ritik.Dashboard.DataRepository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/data1")
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @GetMapping
    public ResponseEntity<List<DataEntity>> getAllData() {
        List<DataEntity> data = dataRepository.findAll();
        return ResponseEntity.ok().body(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataEntity> getDataById(@PathVariable Long id) {
        Optional<DataEntity> data = dataRepository.findById(id);
        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<DataEntity>> getDataByFilter(
            @RequestParam(required = false) String startYear,
            @RequestParam(required = false) Integer endYear,
            @RequestParam(required = false) String topic,
            @RequestParam(required = false) String sector,
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String pestle,
            @RequestParam(required = false) String source,
            @RequestParam(required = false) String swot
    ) {
        List<DataEntity> data = dataRepository.findAll();

        if (startYear != null && endYear != null) {
            data = dataRepository.findByEndYearBetween(Integer.parseInt(startYear), endYear);
        }

        if (topic != null) {
            data = dataRepository.findByTopic(topic);
        }

        if (sector != null) {
            data = dataRepository.findBySector(sector);
        }

        if (region != null) {
            data = dataRepository.findByRegion(region);
        }

        if (pestle != null) {
            data = dataRepository.findByPestle(pestle);
        }

        if (source != null) {
            data = dataRepository.findBySource(source);
        }

        if (swot != null) {
            data = dataRepository.findBySwot(swot);
        }

        return ResponseEntity.ok().body(data);
    }
}