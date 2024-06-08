/*
Nama: HUMAIRA ELFI PUTRI
NIM: 2301093015
Kelas: MI 1C
Matkul: PBO Praktek
 */
package Matkul.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HumairaElfiPutri
 */
public class MatkulDao {
    private List<Matkul> data = new ArrayList<Matkul>();
    
    public MatkulDao(){
        data.add(new Matkul("A001", "Sistem Basis Data", "3", "Senin", "103"));
         data.add(new Matkul("A002", "Sistem Operasi", "2", "Selasa", "209"));
          data.add(new Matkul("A003", "PBO", "3", "Rabu", "301"));
    }
    
    public void insert(Matkul k){
        data.add(k);
    }
    
    public void update (int index, Matkul k){
        data.set(index,k);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public Matkul getMatkul(int index){
        return data.get(index);
    }
    
    public List<Matkul> getAllMatkul(){
        return data;
    }

    
}
