package com.example.ProgressTest.entity.idGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OrderId implements IdentifierGenerator {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o)throws HibernateException {
        try {
            int nextId;
            String lastId = jdbcTemplate.queryForObject("SELECT order_id FROM progresstest.order ORDER BY order_id DESC LIMIT 1", String.class);
            nextId = Integer.parseInt(lastId.substring(3)) + 1;
            return "LM_" + nextId;
        } catch (Exception ex) {
            System.out.println(+1);
            return "LM_"+1;
        }
    }
}
