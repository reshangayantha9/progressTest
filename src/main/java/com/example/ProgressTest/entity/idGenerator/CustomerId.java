package com.example.ProgressTest.entity.idGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.jdbc.core.JdbcTemplate;
import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
public class CustomerId implements IdentifierGenerator {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o)throws HibernateException {
        try {
            int nextId;
            String lastId = jdbcTemplate.queryForObject("SELECT id FROM progresstest.customer ORDER BY ID DESC LIMIT 1", String.class);
            nextId = Integer.parseInt(lastId.substring(4)) + 1;
            return "cus_" + nextId;
        } catch (Exception ex) {
            System.out.println(+1);
            return "cus_"+1;
        }
    }
}
