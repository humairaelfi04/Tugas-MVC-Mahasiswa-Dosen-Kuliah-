/*
Nama: HUMAIRA ELFI PUTRI
NIM: 2301093015
Kelas: MI 1C
Matkul: PBO Praktek
 */
package Matkul.controller;

import Matkul.model.Matkul;
import Matkul.model.MatkulDao;
import Matkul.view.FormMatkul;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author HumairaElfiPutri
 */
public class MatkulController {
    FormMatkul formMatkul;
    Matkul Matkul;
    MatkulDao MatkulDao;
    int index;
    
    
    public MatkulController(FormMatkul formMatkul){
        this.formMatkul = formMatkul;
        MatkulDao = new MatkulDao();
    }
    
    public void cancel(){
        formMatkul.getTxtKode().setText("");
        formMatkul.getTxtNama().setText("");
        formMatkul.getTxtSks().setText("");
        formMatkul.getTxtKelas().setText("");
        isiJadwal();
    }
    
    public void isiJadwal(){
        formMatkul.getCboJadwal().removeAllItems();
        formMatkul.getCboJadwal().addItem("Senin");
        formMatkul.getCboJadwal().addItem("Selasa");
        formMatkul.getCboJadwal().addItem("Rabu");
        formMatkul.getCboJadwal().addItem("Kamis");
        formMatkul.getCboJadwal().addItem("Jumat");
        formMatkul.getCboJadwal().addItem("Sabtu");
    }
    
    public void insert(){
        
        Matkul = new Matkul();
        Matkul.setKode(formMatkul.getTxtKode().getText());
        Matkul.setNama(formMatkul.getTxtNama().getText());
        Matkul.setSks(formMatkul.getTxtSks().getText());
        Matkul.setJadwal(formMatkul.getCboJadwal()
                .getSelectedItem().toString());
        Matkul.setkelas(formMatkul.getTxtKelas().getText());
        MatkulDao.insert(Matkul);
        JOptionPane.showMessageDialog(formMatkul,"Entri Data OK");
    }
    
    public void getMatkul(){
        int index = formMatkul.getTableMatkul().getSelectedRow();
        Matkul = MatkulDao.getMatkul(index);
        if(Matkul !=null){
            formMatkul.getTxtKode().setText(Matkul.getKode());
            formMatkul.getTxtNama().setText(Matkul.getNama());
            formMatkul.getTxtSks().setText(Matkul.getSks());
            formMatkul.getCboJadwal()
                    .setSelectedItem(Matkul.getJadwal());
            formMatkul.getTxtKelas().setText(Matkul.getKelas());
        }else{
            JOptionPane.showMessageDialog(formMatkul, "Matkul Tidak ada");
        }
    }
    
    public void viewData(){
        DefaultTableModel tableModel = (DefaultTableModel)formMatkul.getTableMatkul().getModel();
        tableModel.setRowCount(0);
        List<Matkul> data = MatkulDao.getAllMatkul();
        for (Matkul Matkul : data){
            Object[] row = {
                Matkul.getKode(),
                Matkul.getNama(),
                Matkul.getSks(),
                Matkul.getJadwal(),
                Matkul.getKelas()
            };
            tableModel.addRow(row);
        }
    }
    
    public void update(){
        Matkul.setKode(formMatkul.getTxtKode().getText());
        Matkul.setNama(formMatkul.getTxtNama().getText());
        Matkul.setSks(formMatkul.getTxtSks().getText());
        Matkul.setJadwal(formMatkul.getCboJadwal().getSelectedItem().toString());
        Matkul.setkelas(formMatkul.getTxtKelas().getText());
        MatkulDao.update(index, Matkul);
        JOptionPane.showMessageDialog(formMatkul, "Update Data Ok");
    }
    
    public void delete(){
        MatkulDao.delete(index);
        JOptionPane.showMessageDialog(formMatkul, "Delete Data OK");
    }
}
