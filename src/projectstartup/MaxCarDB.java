/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstartup;

/**
 *
 * @author hmouissa
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class MaxCarDB {
    
    public static HashMap<String, Car>loadCars(){
        //add code to load data from the file into the hashmap
        HashMap<String,Car> inventory = new HashMap<String, Car>();
        String fileName = "C:\\Users\\johnr\\Documents\\Project_3\\inventory.txt";
        
        try {
            FileInputStream fis = new FileInputStream(fileName);
            
            Scanner sc = new Scanner(fis);
            
            while(sc.hasNext()) {
                String line = sc.nextLine();
                
                String[] values = line.split(" ");
                
                Car car = new Car(values[0], values[1], values[2], Integer.parseInt(values[3]));
                
                inventory.put(car.getVin(), car);
            }
            
            fis.close();
            
            JOptionPane.showMessageDialog(null, "File Loaded Successfully!\n\n" + fileName + "\n\n " + inventory.size() + " Vehicles loaded!");
            
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading file");
        }
                
        
        return inventory;    
    }
    
    public static void saveCars(HashMap<String,Car> inventory){
        //add code to save data from the hashmap into a file
        String fileName = "C:\\Users\\johnr\\Documents\\Project_3\\carList.txt";
        
        try{
            
            FileOutputStream fos = new FileOutputStream(fileName);
            
            PrintWriter pw = new PrintWriter(fos);
            
            for(Map.Entry<String, Car> anEntry: inventory.entrySet()) {
                pw.println(anEntry.getKey() + " " + anEntry.getValue().getVin() + " " + anEntry.getValue().getMake()+ " " + anEntry.getValue().getModel()+ " " + anEntry.getValue().getYear());
                
            }
            pw.close();
            fos.flush();
            fos.close();
            
            JOptionPane.showMessageDialog(null, "Data saved to \n\n" + fileName);
                    
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "There was an issue saving data \n\n");
        }
    
    }
    
}
