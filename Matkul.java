/*
Nama: HUMAIRA ELFI PUTRI
NIM: 2301093015
Kelas: MI 1C
Matkul: PBO Praktek
 */
package Matkul.model;

/**
 *
 * @author HumairaElfiPutri
 */
public class Matkul {
    private String kode;
    private String nama;
    private String sks;
    private String jadwal;
    private String kelas;
    
    public Matkul(){
        
    }

    public Matkul(String kode, String nama, String sks, String jadwal, String kelas) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.jadwal = jadwal;
        this.kelas = kelas;
    }


    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getKelas() {
        return kelas;
    }

    public void setkelas(String kelas) {
        this.kelas = kelas;
    }
}
