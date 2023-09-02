package com.ritik.Dashboard.DataRepository;

import com.ritik.Dashboard.DataEntity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<DataEntity, Long> {
    List<DataEntity> findByEndYearBetween(Integer startYear, Integer endYear);

    List<DataEntity> findByTopic(String topic);

    List<DataEntity> findBySector(String sector);

    List<DataEntity> findByRegion(String region);

    List<DataEntity> findByPestle(String pestle);

    List<DataEntity> findBySource(String source);

    List<DataEntity> findBySwot(String swot);
}