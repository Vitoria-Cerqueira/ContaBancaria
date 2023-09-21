package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDB.connection;

public class BankAccountRepository {
    private Connection conn = connection();
    private PreparedStatement preparedStatement;

    public boolean registerAccount(String number_account, double balence, int idCustomer) {
        try {
            String sql = "INSERT INTO bank (number_account,balence,idCustomer) VALUES (?,?,?) ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, number_account);
            preparedStatement.setDouble(2, balence);
            preparedStatement.setInt(3, idCustomer);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteAccount(String number_account) {
        try {
            String SQL = "DELETE FROM bank WHERE number_account = ? ";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, number_account);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();

            return true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
    public boolean showBalance(String number_account) {
        try {
            String sql = "SELECT balence FROM bank WHERE number_account = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,number_account);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Saldo: R$"+ resultSet.getString("balence"));
            }
            preparedStatement.close();
            conn.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateBalance(int id_account_bank, double value_total){
        try {
            String sql = "UPDATE  bank SET balence = balence - ? WHERE id_bank = ? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDouble(1, value_total);
            preparedStatement.setInt(2, id_account_bank);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addUpdateBalance(int id_account_bank, double value_total){
        try {
            String sql = "UPDATE  bank SET balence = balence + ?  WHERE id_bank = ? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDouble(1, value_total);
            preparedStatement.setInt(2, id_account_bank);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean showCustomerAccount(int idCustomer) {
        try {
            String sql = "SELECT number_account FROM bank WHERE idCustomer = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,idCustomer);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Numero da conta:  " + resultSet.getString("number_account"));
            }
            preparedStatement.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


