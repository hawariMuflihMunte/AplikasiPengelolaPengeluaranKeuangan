package kelolapengeluaran.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Config {
    private static Connection mysqlconfig;
    
    public static Connection configDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/pengeluarankeuangan";
            String user = "root";
            String pass = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.err.println("Koneksi gagal " + e.getMessage());
        }
        
        return mysqlconfig;
    }
}
