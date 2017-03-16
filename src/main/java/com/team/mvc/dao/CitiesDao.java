package com.team.mvc.dao;

import com.team.mvc.entity.CitiesEntity;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import java.util.List;

/**
 * Created by vit on 16.03.2017.
 */
public interface CitiesDao {
    public CitiesEntity getCitiesEntity(String citiname);
    public List<CitiesEntity> getCity();
}
