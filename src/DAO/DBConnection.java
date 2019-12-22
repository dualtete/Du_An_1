package DAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bumte
 */
public class DBConnection {

    private static String DB_URL = "jdbc:sqlserver://Localhost;"
            + "databaseName=data_vituan;";
    private static String USER = "sa";
    private static String PASSWORD = "songlong";
    public static Connection conn = null;

    public DBConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connect successfully!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi thiếu thư viện!");
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối SQL!");
        }
    }

    public static ResultSet getData(String cauLenh) {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cauLenh);
            return rs;
        } catch (SQLException ex) {
            System.out.println("Lỗi truy vấn get data!");
            return null;
        }

    }

    public static int ExecuteData(String cauLenh) {
        try {
            Statement stm = conn.createStatement();
            return stm.executeUpdate(cauLenh);
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn");
            return -1;
        }

    }
}
