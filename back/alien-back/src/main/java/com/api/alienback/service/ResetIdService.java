package com.api.alienback.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResetIdService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ResetIdService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void resetSequence() {
        String sql = "ALTER SEQUENCE ALIEN_ID_seq RESTART WITH 1";
        jdbcTemplate.execute(sql);
    }

}
