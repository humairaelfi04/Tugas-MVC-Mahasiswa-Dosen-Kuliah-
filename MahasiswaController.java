/*
Nama: HUMAIRA ELFI PUTRI
NIM: 2301093015
Kelas: MI 1C
Matkul: PBO Praktek
 */
package IRA30052024.controller;

import IRA30052024.model.Mahasiswa;
import IRA30052024.model.MahasiswaDao;
import IRA30052024.view.FormMahasiswa;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author HumairaElfiPutri
 */
public class MahasiswaController {
    FormMahasiswa formMahasiswa;
    Mahasiswa Mahasiswa;
    MahasiswaDao MahasiswaDao;
    int index;
    
    
    public MahasiswaController(FormMahasiswa formMahasiswa){
        this.formMahasiswa = formMahasiswa;
        MahasiswaDao = new MahasiswaDao();
    }
    
    public void cancel(){
        formMahasiswa.getTxtNobp().setText("");
        formMahasiswa.getTxtNama().setText("");
        formMahasiswa.getTxtAlamat().setText("");
        formMahasiswa.getTxtTglLahir().setText("");
        isiJenisKelamin();
    }
    
    public void isiJenisKelamin(){
        formMahasiswa.getCboJenisKelamin().removeAllItems();
        formMahasiswa.getCboJenisKelamin().addItem("L");
        formMahasiswa.getCboJenisKelamin().addItem("P");
    }
    
    public void insert(){
        
        Mahasiswa = new Mahasiswa();
        Mahasiswa.setNobp(formMahasiswa.getTxtNobp().getText());
        Mahasiswa.setNama(formMahasiswa.getTxtNama().getText());
        Mahasiswa.setAlamat(formMahasiswa.getTxtAlamat().getText());
        Mahasiswa.setJenisKelamin(formMahasiswa.getCboJenisKelamin()
                .getSelectedItem().toString());
        Mahasiswa.setTglLahir(formMahasiswa.getTxtTglLahir().getText());
        MahasiswaDao.insert(Mahasiswa);
        JOptionPane.showMessageDialog(formMahasiswa,"Entri Data OK");
    }
    
    public void getMahasiswa(){
        int index = formMahasiswa.getTableMahasiswa().getSelectedRow();
        Mahasiswa = MahasiswaDao.getMahasiswa(index);
        if(Mahasiswa !=null){
            formMahasiswa.getTxtNobp().setText(Mahasiswa.getNobp());
            formMahasiswa.getTxtNama().setText(Mahasiswa.getNama());
            formMahasiswa.getTxtAlamat().setText(Mahasiswa.getAlamat());
            formMahasiswa.getCboJenisKelamin()
                    .setSelectedItem(Mahasiswa.getJenisKelamin());
            formMahasiswa.getTxtTglLahir().setText(Mahasiswa.getTglLahir());
        }else{
            JOptionPane.showMessageDialog(formMahasiswa, "Mahasiswa Tidak ada");
        }
    }
    
    public void viewData(){
        DefaultTableModel tableModel = (DefaultTableModel)formMahasiswa.getTableMahasiswa().getModel();
        tableModel.setRowCount(0);
        List<Mahasiswa> data = MahasiswaDao.getAllMahasiswa();
        for (Mahasiswa mahasiswa : data){
            Object[] row = {
                mahasiswa.getNobp(),
                mahasiswa.getNama(),
                mahasiswa.getAlamat(),
                mahasiswa.getJenisKelamin(),
                mahasiswa.getTglLahir()
            };
            tableModel.addRow(row);
        }
    }
    
    public void update(){
        Mahasiswa.setNobp(formMahasiswa.getTxtNobp().getText());
        Mahasiswa.setNama(formMahasiswa.getTxtNama().getText());
        Mahasiswa.setAlamat(formMahasiswa.getTxtAlamat().getText());
        Mahasiswa.setJenisKelamin(formMahasiswa.getCboJenisKelamin().getSelectedItem().toString());
        Mahasiswa.setTglLahir(formMahasiswa.getTxtTglLahir().getText());
        MahasiswaDao.update(index, Mahasiswa);
        JOptionPane.showMessageDialog(formMahasiswa, "Update Data Ok");
    }
    
    public void delete(){
        MahasiswaDao.delete(index);
        JOptionPane.showMessageDialog(formMahasiswa, "Delete Data OK");
    }
}
