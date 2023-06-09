package com.ynov.iot.dao;

import com.ynov.iot.dao.entity.HeatMapData;
import com.ynov.iot.dao.entity.TotalTrafficData;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

/**
 * DAO class for total_traffic
 *
 * @author ynov22
 */
@Repository
public interface HeatMapDataRepository extends CassandraRepository<HeatMapData, UUID> {

    @Query("SELECT * FROM traffickeyspace.heat_map WHERE timestamp = ?0 ALLOW FILTERING")
    Iterable<TotalTrafficData> findHeatMapByDate(Date date);
}
