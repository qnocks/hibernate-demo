package ru.qnocks.jdbcconnectionexample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class JdbcMain {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/gardering";
        String user = "postgres";
        String password = "qnocks";

        Connection con = DriverManager.getConnection(url, user, password);

        String query = "SELECT * FROM garden";

        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery(query);

        String columns[] = { "ID", "Number", "Area", "Cost" };
        String data[][] = new String[10][4];

        int i = 0;
        while (res.next()) {
            long id = res.getLong(1);
            String number = res.getString(2);
            int area = res.getInt(3);
            long cost = res.getLong(4);
            data[i][0] = id + "";
            data[i][1] = number;
            data[i][2] = area + "";
            data[i][3] = cost + "";
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        JScrollPane pane = new JScrollPane(table);
        JFrame f = new JFrame("Populate JTable from Database");
        JPanel panel = new JPanel();
        panel.add(pane);
        f.add(panel);
        f.setSize(500, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
