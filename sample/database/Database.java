package sample.database;

import java.sql.*;

public class Database {
    /**
     * Metoda bezpiecznego laczenia do bazy danych
     * @return conn
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     */
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

    /**
     * metoda bezpiecznego wykonania polaczenia
     * @param sql baza
     * @param tab tabele
     * @return result
     * @throws SQLException Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
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

    /**
     * metoda bezpiecznego dodawania do bazy danych
     * @param sql baza
     * @param tab tabele
     * @throws SQLException  Rzuca kiedy występuje problem z zapytaniem SQL
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     */
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

    /**
     * metoda
     * @return results
     * @throws ClassNotFoundException Rzuca, gdy aplikacja nie może znaleźć klasy
     * @throws SQLException  Rzuca kiedy występuje problem z zapytaniem SQL
     */
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

    /**
     * metoda wykonywania
     * @param sql baza
     * @return result
     */
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

    /**
     * metoda aktualizacji bazy
     * @param sql baza
     */
    public static void update(String sql) {
        try {
            Statement stmt = Database.prepareStatement();

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
