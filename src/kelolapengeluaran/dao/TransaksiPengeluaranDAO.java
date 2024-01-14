package kelolapengeluaran.dao;

import kelolapengeluaran.model.TransaksiPengeluaran;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransaksiPengeluaranDAO {
    private final Connection connection;
    
    public TransaksiPengeluaranDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<TransaksiPengeluaran> getAllTransactions() {
        List<TransaksiPengeluaran> transactions = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM transaksi_pengeluaran";
            
            try (
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_transaksi");
                    String tanggal = resultSet.getString("tanggal_transaksi");
                    Double jumlah = resultSet.getDouble("jumlah_pengeluaran");
                    int id_kategori = resultSet.getInt("id_kategori");
                    String deskripsi = resultSet.getString("deskripsi_transaksi");
                    
                    TransaksiPengeluaran transaction = new TransaksiPengeluaran(id, tanggal, jumlah, id_kategori, deskripsi);
                    transactions.add(transaction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return transactions;
    }
    
    public void addTransaction(TransaksiPengeluaran transaction) {
        try {
            String query = "INSERT INTO transaksi_pengeluaran (tanggal_transaksi, jumlah_pengeluaran, id_kategori, deskripsi_transaksi) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, transaction.getTanggal_transaksi());
                statement.setDouble(2, transaction.getJumlah_pengeluaran());
                statement.setInt(3, transaction.getId_kategori());
                statement.setString(4, transaction.getDeskripsi_transaksi());
                
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTransaction(int transactionId) {
        try {
            String query = "DELETE FROM transaksi_pengeluaran WHERE id_transaksi = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, transactionId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String getCategoryById(int id) throws SQLException {
        String namaKategori = null;
        String query = "SELECT nama_kategori FROM kategori_pengeluaran WHERE id_kategori = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    namaKategori = resultSet.getString("nama_kategori");
                }
            }
        }

        return namaKategori;
    }
    
    public TransaksiPengeluaran getTransactionById(int transactionId) throws SQLException {
        String query = "SELECT * FROM transaksi_pengeluaran WHERE id_transaksi = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, transactionId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id_transaksi");
                    String tanggal = resultSet.getString("tanggal_transaksi");
                    Double jumlah = resultSet.getDouble("jumlah_pengeluaran");
                    int id_kategori = resultSet.getInt("id_kategori");
                    String deskripsi = resultSet.getString("deskripsi_transaksi");

                    return new TransaksiPengeluaran(id, tanggal, jumlah, id_kategori, deskripsi);
                }
            }
        }
        
        return null;
    }
    
    public List<String> getUniqueTransactionDates() throws SQLException {
        List<String> uniqueDates = new ArrayList<>();

        String query = "SELECT DISTINCT tanggal_transaksi FROM transaksi_pengeluaran";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String date = resultSet.getString("tanggal_transaksi");
                uniqueDates.add(date);
            }
        }

        return uniqueDates;
    }
    
    public List<TransaksiPengeluaran> getTransactionsByDate(String date) throws SQLException {
        List<TransaksiPengeluaran> transactions = new ArrayList<>();

        String query = "SELECT * FROM transaksi_pengeluaran WHERE tanggal_transaksi = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, date);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_transaksi");
                    String tanggal = resultSet.getString("tanggal_transaksi");
                    Double jumlah = resultSet.getDouble("jumlah_pengeluaran");
                    int id_kategori = resultSet.getInt("id_kategori");
                    String deskripsi = resultSet.getString("deskripsi_transaksi");

                    TransaksiPengeluaran transaction = new TransaksiPengeluaran(id, tanggal, jumlah, id_kategori, deskripsi);
                    transactions.add(transaction);
                }
            }
        }

        return transactions;
    }
}
