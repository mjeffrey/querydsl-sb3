package com.example.sb3;

import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("Just test we can execute the query")
    void emptyQueryTest() {
        QCustomer customer = QCustomer.customer;
        JPAQuery<QCustomer> query = new JPAQuery<>(entityManager);

        query.from(customer).where(customer.firstName.eq("Bob"));
        assertThat(query.fetch().size()).isEqualTo(0);
    }

}
