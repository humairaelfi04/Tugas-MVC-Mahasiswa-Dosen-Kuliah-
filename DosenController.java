/*
Nama: HUMAIRA ELFI PUTRI
NIM: 2301093015
Kelas: MI 1C
Matkul: PBO Praktek
 */
package Dosen.controller;

import Dosen.model.Dosen;
import Dosen.model.DosenDao;
import Dosen.view.FormDosen;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author HumairaElfiPutri
 */
public class DosenController {
    FormDosen formDosen;
    Dosen Dosen;
    DosenDao DosenDao;
    int index;
    
    
    public DosenController(FormDosen formDosen){
        this.formDosen = formDosen;
        DosenDao = new DosenDao();
    }
    
    public void cancel(){
        formDosen.getTxtNip().setText("");
        formDosen.getTxtNama().setText("");
        formDosen.getTxtAlamat().setText("");
        formDosen.getTxtTglLahir().setText("");
        isiJenisKelamin();
    }
    
    public void isiJenisKelamin(){
        formDosen.getCboJekel().removeAllItems();
        formDosen.getCboJekel().addItem("L");
        formDosen.getCboJekel().addItem("P");
    }
    
    public void insert(){
        
        Dosen = new Dosen();
        Dosen.setNip(formDosen.getTxtNip().getText());
        Dosen.setNama(formDosen.getTxtNama().getText());
        Dosen.setAlamat(formDosen.getTxtAlamat().getText());
        Dosen.setJenisKelamin(formDosen.getCboJekel()
                .getSelectedItem().toString());
        Dosen.setTglLahir(formDosen.getTxtTglLahir().getText());
        DosenDao.insert(Dosen);
        JOptionPane.showMessageDialog(formDosen,"Entri Data OK");
    }
    
    public void getDosen(){
        int index = formDosen.getTableDosen().getSelectedRow();
        Dosen = DosenDao.getDosen(index);
        if(Dosen !=null){
            formDosen.getTxtNip().setText(Dosen.getNip());
            formDosen.getTxtNama().setText(Dosen.getNama());
            formDosen.getTxtAlamat().setText(Dosen.getAlamat());
            formDosen.getCboJekel()
                    .setSelectedItem(Dosen.getJenisKelamin());
            formDosen.getTxtTglLahir().setText(Dosen.getTglLahir());
        }else{
            JOptionPane.showMessageDialog(formDosen, "Dosen Tidak ada");
        }
    }
    
    public void viewData(){
        DefaultTableModel tableModel = (DefaultTableModel)formDosen.getTableDosen().getModel();
        tableModel.setRowCount(0);
        List<Dosen> data = DosenDao.getAllDosen();
        for (Dosen Dosen : data){
            Object[] row = {
                Dosen.getNip(),
                Dosen.getNama(),
                Dosen.getAlamat(),
                Dosen.getJenisKelamin(),
                Dosen.getTglLahir()
            };
            tableModel.addRow(row);
        }
    }
    
    public void update(){
        Dosen.setNip(formDosen.getTxtNip().getText());
        Dosen.setNama(formDosen.getTxtNama().getText());
        Dosen.setAlamat(formDosen.getTxtAlamat().getText());
        Dosen.setJenisKelamin(formDosen.getCboJekel().getSelectedItem().toString());
        Dosen.setTglLahir(formDosen.getTxtTglLahir().getText());
        DosenDao.update(index, Dosen);
        JOptionPane.showMessageDialog(formDosen, "Update Data Ok");
    }
    
    public void delete(){
        DosenDao.delete(index);
        JOptionPane.showMessageDialog(formDosen, "Delete Data OK");
    }
}
