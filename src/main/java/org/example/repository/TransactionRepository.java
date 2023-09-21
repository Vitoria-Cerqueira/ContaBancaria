package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDB.connection;

public class TransactionRepository {
    private Connection conn = connection();
    private PreparedStatement preparedStatement;

    public boolean registerTransaction(String date, double value, int id_origin_account,int id_destination_account){
        try {
            String sql = "INSERT INTO tbtransaction (date,value_total,id_origin_account,id_destination_account) VALUES (?,?,?,?) ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, date);
            preparedStatement.setDouble(2, value);
            preparedStatement.setInt(3, id_origin_account);
            preparedStatement.setInt(4, id_destination_account);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean showAllTransactionsofaSpecificAccount(int id_origin_account){
        try{
            String SQL = "SELECT * FROM tbtransaction WHERE id_origin_account = ?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setInt(1, id_origin_account);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("DATA DA TRANSAÇÃO: " + resultSet.getString("date"));
                System.out.println("VALOR TRANSFERIDO: " + resultSet.getString("value_total"));
                System.out.println("ID DE ORIGEM: " + resultSet.getString("id_origin_account"));
                System.out.println("ID DE DESTINO: " + resultSet.getString("id_destination_account"));
                System.out.println();
            }
            preparedStatement.close();
            conn.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
