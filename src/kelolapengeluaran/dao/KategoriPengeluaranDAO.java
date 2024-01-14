package kelolapengeluaran.dao;

import kelolapengeluaran.model.KategoriPengeluaran;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class KategoriPengeluaranDAO {
    private final Connection connection;
    
    public KategoriPengeluaranDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<KategoriPengeluaran> getAllCategories() {
        List<KategoriPengeluaran> categories = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM kategori_pengeluaran";
            
            try (
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_kategori");
                    String nama = resultSet.getString("nama_kategori");
                    
                    KategoriPengeluaran category = new KategoriPengeluaran(id, nama);
                    categories.add(category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return categories;
    }
    
    public void addCategory(KategoriPengeluaran category) {
        try {
            String query = "INSERT INTO kategori_pengeluaran (nama_kategori) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, category.getNama());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteCategory(int categoryId) {
        try {
            String query = "DELETE FROM kategori_pengeluaran WHERE id_kategori = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, categoryId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
