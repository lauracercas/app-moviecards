package com.lauracercas.moviecards.integrationtest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"/test-context.xml"})
public abstract class SpringTest {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session session() {
        return this.sessionFactory.getCurrentSession();
    }
    
}
