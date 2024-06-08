/*
Nama: HUMAIRA ELFI PUTRI
NIM: 2301093015
Kelas: MI 1C
Matkul: PBO Praktek
 */
package Dosen.model;

/**
 *
 * @author HumairaElfiPutri
 */
public class Dosen {
     private String nip;
    private String nama;
    private String alamat;
    private String jenisKelamin;
    private String tglLahir;
    
    public Dosen(){
        
    }

    public Dosen(String nip, String nama, String alamat, String jenisKelamin, String tglLahir) {
        this.nip = nip;
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.tglLahir = tglLahir;
    }


    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

}
