package kelolapengeluaran.model;

/**
 *
 * @author Lenovo
 */
public class KategoriPengeluaran {
    private int id;
    private String nama;
    
    public KategoriPengeluaran(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
