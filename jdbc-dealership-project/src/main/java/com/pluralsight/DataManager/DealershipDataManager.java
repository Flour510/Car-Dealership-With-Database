package com.pluralsight.DataManager;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DealershipDataManager {
    DataSource dataSource;

    private String connection;
    private String username;
    private String password;

    public DealershipDataManager()
    {
        readProperties();
        // build a BasicDataSource
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(connection);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // set our class dataSource to the BasicDataSource
        this.dataSource = dataSource;

    }

    private void readProperties()
    {
        Properties properties = new Properties();

        try(FileInputStream stream = new FileInputStream("src/main/resources/config.properties"))
        {
            properties.load(stream);
            connection = properties.getProperty("db.connectionstring");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        // create a new method , phase 1 here
        // create vehicleDao class (follow gregors git hub example)
    }


}