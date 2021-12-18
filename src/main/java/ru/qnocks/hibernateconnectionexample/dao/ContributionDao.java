package ru.qnocks.hibernateconnectionexample.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.qnocks.hibernateconnectionexample.domain.Contribution;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContributionDao implements CrudDao<Contribution, Long> {

    private String databaseUrl = "jdbc:postgresql://localhost:5432/gardering";

    private final String JDBC_DRIVER = "org.postgresql.Driver";

    private final String USER = "postgres";
    private final String PASSWORD = "qnocks";

    @Override
    public void save(Contribution entity) {
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public void update(Long aLong, Contribution entity) {
    }

    @Override
    public Contribution findById(Long id) {
        return null;
    }

    @Override
    public Iterable<Contribution> findAll() {
       return executeFindAll("SELECT * FROM contribution");
    }

    private List<Contribution> executeFindAll(String query) {
        List<Contribution> contributions = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(databaseUrl, USER, PASSWORD);
            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String decs = resultSet.getString(3);
                int price = resultSet.getInt(4);
                String date = resultSet.getString(5);

                contributions.add(new Contribution(id, name, decs, price, date));
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

        return contributions;
    }
}
