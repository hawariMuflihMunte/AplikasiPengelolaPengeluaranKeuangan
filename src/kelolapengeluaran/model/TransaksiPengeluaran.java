package kelolapengeluaran.model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class TransaksiPengeluaran {
    private int id;
    private String tanggal_transaksi;
    private Double jumlah_pengeluaran;
    private int id_kategori;
    private String deskripsi_transaksi;
    
    public TransaksiPengeluaran(
        int id,
        String tanggal_transaksi,
        Double jumlah_pengeluaran,
        int id_kategori,
        String deskripsi_transaksi
    ) {
        this.id = id;
        this.tanggal_transaksi = tanggal_transaksi;
        this.jumlah_pengeluaran = jumlah_pengeluaran;
        this.id_kategori = id_kategori;
        this.deskripsi_transaksi = deskripsi_transaksi;
    }
    
    public int getId_transaksi() {
        return this.id;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id = id_transaksi;
    }

    public String getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public void setTanggal_transaksi(String tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public Double getJumlah_pengeluaran() {
        return jumlah_pengeluaran;
    }

    public void setJumlah_pengeluaran(Double jumlah_pengeluaran) {
        this.jumlah_pengeluaran = jumlah_pengeluaran;
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getDeskripsi_transaksi() {
        return deskripsi_transaksi;
    }

    public void setDeskripsi_transaksi(String deskripsi_transaksi) {
        this.deskripsi_transaksi = deskripsi_transaksi;
    }

    @Override
    public String toString() {
        return "TransaksiPengeluaran{" +
                "id=" + id +
                ", tanggal_transaksi=" + tanggal_transaksi +
                ", jumlah_pengeluaran=" + jumlah_pengeluaran +
                ", id_kategori=" + id_kategori +
                ", deskripsi_transaksi='" + deskripsi_transaksi + '\'' +
                '}';
    }
}
