/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstartup;

/**
 *
 * @author Administrator
 */
import javax.swing.JOptionPane;
public class Validator {
    public static String getValidVIN(String input){
       
        //loop to make sure input is valid
        while(isValidVIN(input) == false){
        
            input = JOptionPane.showInputDialog(null, "VIN: " + input + " is invalid\n\nPlease reenter a valid VIN");
        }
      
        return input;
    
    }
    
    private static boolean isValidVIN(String input){
        
        //create a variable to hold result
        boolean result = true;
       
        //Add code to validate the VIN number here
        try{
            if(input.length() > 6){
                result = false;
            }
            
            if (input.charAt(0) != 'V') {
                result = false;
            }
        }catch(Exception ex) {
                    result = false;
            }
            return result;
        }
    public static String getValidMake(String input) {
        
        while (isValidMake(input)== false){
            input = JOptionPane.showInputDialog(null, "Make: " + input + " is invalid\n\nPlease reenter a valid Car Make");
        }
        
            return input;
    }
    private static boolean isValidMake(String input) {
        boolean result = true;
        
        try{
            
            if(input.length() == 0){
                result = false;
            }
            
            if(input.length() > 15){
                result = false;
            }   
            
         }catch(Exception ex){
             result = false;
         }
        
        return result;
    
   }
   public static String getValidModel(String input){
       
        
        while(isValidModel(input) == false){
        
            input = JOptionPane.showInputDialog(null, "Model: " + input + " is invalid\n\nPlease reenter a valid Car Model");
        }
      
        return input;
    
    }
    
    private static boolean isValidModel(String input){
        boolean result = true;
      
            try{
            
            if(input.length() == 0){
                result = false;
            }
            
            if(input.length() > 15){
                result = false;
            }   
            
         }catch(Exception ex){
             result = false;
         }
        
        return result;
        }
    public static int getValidYear(String input){
        
        while (isValidYear(input) == false){
           input = JOptionPane.showInputDialog(null, "Year: " + input + " is invalid\n\nPlease reenter a valid year");
       }
        
        return Integer.parseInt(input);
    }
    
    private static boolean isValidYear(String input) {
       boolean result = true;
        
        try{
            
           int value = Integer.parseInt(input);
            
           if(value < 1900 && value > 2900){
                result = false;
            }
           if(input.length() != 4){
               result = false;
           }
       }catch(Exception ex){
            result = false;
        }
        
     return result;
     }
                          
 }
