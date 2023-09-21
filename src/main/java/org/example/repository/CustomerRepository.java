package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDB.connection;

public class CustomerRepository {
    private Connection conn = connection();
    private PreparedStatement preparedStatement;

    public boolean registerCustomer(String name, String cpf, String address) {
        try {
            String sql = "INSERT INTO customer (name,cpf,address) VALUES (?,?,?) ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, address);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean logIn(String cpf) {
        try {
            String SQL = "SELECT * FROM customer WHERE cpf=?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("cpf").equals(cpf)) {
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
    public boolean deleteCustomer(String cpf) {
        try {
            String SQL = "DELETE FROM customer WHERE cpf = ?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, cpf);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    public boolean changeAddress(String cpf, String address) {
        try {
            String sql = "UPDATE customer " +
                    "SET address = ?  " +
                    "WHERE cpf = ? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, address);
            preparedStatement.setString(2, cpf);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}



