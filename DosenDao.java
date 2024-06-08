/*
Nama: HUMAIRA ELFI PUTRI
NIM: 2301093015
Kelas: MI 1C
Matkul: PBO Praktek
 */
package Dosen.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HumairaElfiPutri
 */
public class DosenDao {
    private List<Dosen> data = new ArrayList<Dosen>();
    
    public DosenDao(){
        data.add(new Dosen("1970123", "Ervan", "Padang", "L", "01-09-1970"));
         data.add(new Dosen("1971123", "Yance", "Jakarta", "P", "10-07-1971"));
          data.add(new Dosen("1972123", "Fazrol", "Padang Panjang", "L", "20-01-1972"));
    }
    
    public void insert(Dosen d){
        data.add(d);
    }
    
    public void update (int index, Dosen d){
        data.set(index,d);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public Dosen getDosen(int index){
        return data.get(index);
    }
    
    public List<Dosen> getAllDosen(){
        return data;
    }

}
