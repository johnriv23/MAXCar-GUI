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
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Main {

    private static HashMap<String, Car> inventory;

    public static void main(String[] args) {
       //initialize the inventory
       inventory = new HashMap<String, Car>();
       
       
       //Present the customer with a choice of vehicles
		String[]  choices = {"Add Car", "Remove Car", "Update Car", "List Cars", "Clear Cars", "Find Car", "Exit"};

                //keep the menu up unless exiting
                while(true){ 
                    int response = JOptionPane.showOptionDialog(
                                    null                       				// center over parent
                                    , "Database Operations"                             // message
                                    , "MaxCar the Best Car Dealership"        		// title in titlebar
                                    , JOptionPane.YES_NO_OPTION                 	// Option type
                                    , JOptionPane.PLAIN_MESSAGE  			// messageType
                                    , null                       			// icon
                                    , choices                    			// Options
                                    , "Select a MaxCar Operation"                       // initial value
                    );
                    switch (response){

                        case 0:
                            addCar();
                            break;
                        case 1:
                            removeCar();
                            break;                      
                        case 2:
                            updateCar();
                            break;
                        case 3:
                            listCars();
                            break;
                        case 4:
                            clearCars();
                            break;
                        case 5:
                            findCar();
                            break;                            
                        default:
                               exitApplication();
                    }
                }
                
    }
    
    
    private static void addCar(){
        //add code to ask user for entry
        String input = JOptionPane.showInputDialog("Enter the car information seperated by spaces\n" + "VIN CAR_MAKE CAR_MODEL CAR_YEAR");
        //add code to read the data entered and use split to break it into variables
        String[] values = input.split(" ");
        //add code to save the data entered by the user to the hashmap as a VIN and a CAR object
        if (values.length != 4) {
             JOptionPane.showMessageDialog(null, "Invalid Entry\n\n" + "Please Enter the car information seperated by spaces\n" + "VIN CAR_MAKE CAR_MODEL CAR_YEAR");
             
        }
        else{
            Car car = new Car(Validator.getValidVIN(values[0]), Validator.getValidMake(values[1]),
                                                Validator.getValidModel(values[2]),
                                                Validator.getValidYear(values[3]));
            inventory.put(car.getVin(), car);
        
            JOptionPane.showMessageDialog(null, "Car added!");
        }
    }
        
    
    
    private static void removeCar(){
        //add code to ask user for data entry and remove a car from the hashmap
        //Example using the validator class to check data for issues
        String vin = JOptionPane.showInputDialog("Please enter VIN number of car to remove\n" + "VIN");
        
        if (inventory.containsKey(vin)) {
            inventory.remove(vin);
            JOptionPane.showMessageDialog(null, "Vehicle with vin" + vin + " was succesfuly removed!");
        } else {
            JOptionPane.showMessageDialog(null, "Vehicle with VIN: " + vin + " was not found!");
        }
        
    }
    
   private static void updateCar(){
        //add code to ask user for data entry and update the car in the hashmap
       String vin = JOptionPane.showInputDialog("Please enter VIN of the Vehicle to update");

        if(inventory.containsKey(vin)){
            Car car = inventory.get(vin);

            String make = JOptionPane.showInputDialog("Enter new make (previous make: " + car.getMake() + "):");
            String model = JOptionPane.showInputDialog("Enter new model (previous model: " + car.getModel() + "):");
            int year = Integer.parseInt(JOptionPane.showInputDialog("Enter new year (previous year: " + car.getYear() + "):"));

            car.setMake(make);
            car.setModel(model);
            car.setYear(year);

            JOptionPane.showMessageDialog(null, "Car with VIN: " + vin + " updated successfully!");
        }else{
            JOptionPane.showMessageDialog(null, "Car with VIN: " + vin + " was not found in inventory!");
        }
    }
       
    
  private static void listCars(){
        //add code to display summary data of all the cars in the hashmap
        String summary = "Vehicle List\n";
        for (Map.Entry<String,Car> anEntry: inventory.entrySet()){
        summary += anEntry.getKey() + "\t" + anEntry.getValue().getVin() + "\t" + anEntry.getValue().getMake()+ "\t" + anEntry.getValue().getModel()+ "\t" + anEntry.getValue().getYear() + "\n";
    }
    JOptionPane.showMessageDialog(null,new JTextArea(summary));
    }
    

   private static void clearCars(){
        //add code to clear the hashmap
       int numItems = inventory.size();
       
       inventory.clear();
    
        JOptionPane.showMessageDialog(null, "Vehicle list was cleared\n" + numItems + " were cleared");
   }
    
    private static void findCar(){
        //add code to find the car in the hashmap
        String input = JOptionPane.showInputDialog("Please enter vehicle VIN" + "\n");
        if (inventory.containsKey(input)){
            Car car = inventory.get(input);
            
            JOptionPane.showMessageDialog(null,new JTextArea(car.getVin() + "\t" + car.getMake() + "\t" + car.getModel() + "\t" + car.getYear()));
          }
        else {
            JOptionPane.showMessageDialog(null, "The vehicle VIN: " + input + " was not found!");
        }
    
    }
    private static void exitApplication(){
        JOptionPane.showMessageDialog(null, "Thank you for using the MaxCar Application. " + inventory.size() + " cars saved!...EXITING...");
        System.exit(0);
   }
    
}
