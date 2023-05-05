package com.cophea;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner; 
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataManager {


    public static void loadAppts(Employee emp) throws FileNotFoundException{
        

        File currAppts = new File("Cophea/src/main/resources/com/cophea/appt/"+emp.getId()+"_appts.csv");
        Scanner scan = new Scanner(currAppts);
        String[] lineValues = new String[8];
		String line = scan.nextLine();
        lineValues = line.split(",");

        //skip line with headers
        scan.nextLine();
        while(scan.hasNext()){
            lineValues = scan.nextLine().split(",");
            emp.addAppointment(
                new Appointment(emp, new Patient(line, line, line, line, line), new TimeSlot(
                    Integer.parseInt(lineValues[2]),
                    Integer.parseInt(lineValues[3]),
                    Integer.parseInt(lineValues[4]),
                    Integer.parseInt(lineValues[5]))
            ));
        }
        scan.close();
        

    }

    public static void loadWorkSlots(Employee emp) throws FileNotFoundException{
        
        File currWS = new File("Cophea/src/main/resources/com/cophea/ws/"+emp.getId()+"_workinghours.csv");
        Scanner scan = new Scanner(currWS);

        String[] lineValues = new String[8];
		String line = scan.nextLine();
        lineValues = line.split(",");

        //skip line with headers
        scan.nextLine();
        while(scan.hasNext()){
            lineValues = scan.nextLine().split(",");
            emp.addSlot(new TimeSlot(
                Integer.parseInt(lineValues[0]),
                Integer.parseInt(lineValues[1]),
                Integer.parseInt(lineValues[2]),
                Integer.parseInt(lineValues[3])));
        }
        emp.getSlots().sort(null);
        scan.close();



      
    }
}
