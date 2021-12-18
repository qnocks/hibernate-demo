package ru.qnocks.hibernateconnectionexample.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.qnocks.hibernateconnectionexample.domain.Contribution;
import ru.qnocks.hibernateconnectionexample.domain.Garden;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GardenDao implements CrudDao<Garden, Long> {

    private String databaseUrl = "jdbc:postgresql://localhost:5432/gardering";

    private final String JDBC_DRIVER = "org.postgresql.Driver";

    private final String USER = "postgres";
    private final String PASSWORD = "qnocks";

    @Override
    public void save(Garden entity) {
    }

    @Override
    public void deleteById(Long aLong) {
    }

    @Override
    public void update(Long aLong, Garden entity) {
    }

    @Override
    public Garden findById(Long aLong) {
        return null;
    }

    @Override
    public Iterable<Garden> findAll() {
        return executeFindAll("SELECT * FROM garden");
    }

    private List<Garden> executeFindAll(String query) {
        List<Garden> gardens = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(databaseUrl, USER, PASSWORD);
            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String number = resultSet.getString(2);
                int area = resultSet.getInt(3);
                long cost = resultSet.getLong(4);

                gardens.add(new Garden(id, number, area, cost));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return gardens;
    }
}
