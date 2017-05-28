package sample.database;

import java.sql.*;

public class Database {
    public static Connection prepareSecureConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;

        DbDetailsProvider dbDetailsProvider = new DbDetailsProvider();
        String user = dbDetailsProvider.getUser();
        String pass = dbDetailsProvider.getPass();
        String host = dbDetailsProvider.getHost();

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(host, user, pass);


        return conn;
    }

    public static ResultSet secureExecute(String sql, String tab[]) throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        Connection conn = prepareSecureConnection();

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);
            for (int i = 0; i < tab.length; i++) {
                stmt.setString(i + 1, tab[i]);
            }


            result = stmt.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static void secureUpdate(String sql, String tab[]) throws SQLException, ClassNotFoundException {

        Connection conn = prepareSecureConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            for (int i = 0; i < tab.length; i++) {
                stmt.setString(i + 1, tab[i]);
            }
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public static Statement prepareStatement() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;

        DbDetailsProvider dbDetailsProvider = new DbDetailsProvider();
        String user = dbDetailsProvider.getUser();
        String pass = dbDetailsProvider.getPass();
        String host = dbDetailsProvider.getHost();

        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection(host, user, pass);
        stmt = (Statement) conn.createStatement();

        return stmt;
    }

    public static ResultSet execute(String sql) {
        ResultSet result = null;

        try {
            Statement stmt = Database.prepareStatement();

            result = stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static void update(String sql) {
        try {
            Statement stmt = Database.prepareStatement();

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
