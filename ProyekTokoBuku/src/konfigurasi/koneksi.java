package konfigurasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    private static Connection koneksiDatabase;
    
    public static Connection getConfig() throws SQLException {
        if (koneksiDatabase == null) {
            try {
                // URL Koneksi ke MySQL dan nama database yang tadi dibuat
                String url = "jdbc:mysql://localhost:3306/db_toko_buku";
                String user = "root"; // User default XAMPP
                String password = ""; // Password default XAMPP (kosong)
                
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksiDatabase = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi ke Database Berhasil!");
            } catch (Exception e) {
                System.err.println("Koneksi Gagal: " + e.getMessage());
            }
        }
        return koneksiDatabase;
    }
}