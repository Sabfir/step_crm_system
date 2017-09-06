package org.itstep.j2_16.config;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

@Service
public class StartHsqlDbManager {

    @PostConstruct
    public static void startDBManager() {
        DatabaseManagerSwing.main(
                new String[]{"--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "sa"});
    }
}
