package com.company.repository;

import com.company.entity.CarpetEnt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarpetRep implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public CarpetRep() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "nimamonsefi", "myjava123");
        connection.setAutoCommit(false);
    }

    public void insert(CarpetEnt carpetEnt) throws Exception {
        preparedStatement = connection.prepareStatement("INSERT INTO carpet(num, year, color) VALUES (?,?,?)");
        preparedStatement.setLong(1, carpetEnt.getNum());
        preparedStatement.setLong(2, carpetEnt.getYear());
        preparedStatement.setString(3, carpetEnt.getColor());
        preparedStatement.executeUpdate();
    }

    public void update(CarpetEnt carpetEnt) throws Exception {
        preparedStatement = connection.prepareStatement("UPDATE carpet SET year=?, color=? WHERE num=?");
        preparedStatement.setLong(1, carpetEnt.getYear());
        preparedStatement.setString(2, carpetEnt.getColor());
        preparedStatement.setLong(3, carpetEnt.getNum());
        preparedStatement.executeUpdate();
    }

    public void delete(long num) throws Exception {
        preparedStatement = connection.prepareStatement("DELETE FROM carpet WHERE num=?");
        preparedStatement.setLong(1, num);
        preparedStatement.executeUpdate();
    }

    public List<CarpetEnt> select() throws Exception {
        preparedStatement = connection.prepareStatement("SELECT * FROM carpet");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<CarpetEnt> carpetlist = new ArrayList<>();
        while (resultSet.next()) {
            CarpetEnt carpetEnt = new CarpetEnt();
            carpetEnt.setNum(resultSet.getLong("num"));
            carpetEnt.setYear(resultSet.getInt("year"));
            carpetEnt.setColor(resultSet.getString("color"));
            carpetlist.add(carpetEnt);
        }
        return carpetlist;
    }

    public void commit() throws Exception {
        connection.commit();
    }

    public void rollback() throws Exception {
        connection.rollback();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
