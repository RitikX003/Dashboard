package com.ritik.Dashboard.DataService;

import com.ritik.Dashboard.DataEntity.DataEntity;
import com.ritik.Dashboard.DataRepository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    public List<DataEntity> getAllData() {
        return dataRepository.findAll();
    }

    public DataEntity getDataById(Long id) throws ResourceNotFoundException {
        return dataRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found with id: " + id));
    }

    public List<DataEntity> getDataByFilter(String startYear, Integer endYear, String topic, String sector,
                                            String region, String pestle, String source, String swot) {
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

        return data;
    }

}
