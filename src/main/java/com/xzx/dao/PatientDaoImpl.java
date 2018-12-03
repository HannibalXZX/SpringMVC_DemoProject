package com.xzx.dao;

import com.xzx.model.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;


}
