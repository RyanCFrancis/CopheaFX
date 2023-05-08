package com.cophea;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


//DONT NEED NEW LINE

public class DataManager {
    

    public static void updatePerson(Person pers) throws FileNotFoundException{
        if (!pers.isPatient()){
            DataManager.loadWorkSlots((Employee) pers);
        }
        DataManager.loadAppts(pers);
        
    }

    


    //returns the persons id number if they successfully login, 
    //otherwise returns the string "fail"
    public static String loadPersonLogin(String loginString,String pwString) throws FileNotFoundException{
        File people = new File("Cophea/src/main/resources/com/cophea/people.csv");
        Scanner scan = new Scanner(people);
        String tempLogin,tempPW,line;
        String[] lineValues = new String[9];
        //skip headers
        scan.nextLine();
        while(scan.hasNext()){
            line = scan.nextLine();
            lineValues = line.split(",");
            tempLogin = lineValues[3];
            tempPW = lineValues[4];

            if (loginString.equals(tempLogin)&& pwString.equals(tempPW)){
                scan.close();
                System.out.println("hey there u logged in");
                return lineValues[0];
            }
        }
        scan.close();
        return "fail";

    }


    public static Patient getPatient(String id) throws FileNotFoundException{
        File people = new File("Cophea/src/main/resources/com/cophea/people.csv");
        Scanner scan = new Scanner(people);
        String line;
        String[] lineValues = new String[9];
        //skip headers
        scan.nextLine();
        while(scan.hasNext()){
            line = scan.nextLine();
            lineValues = line.split(",");
            if (lineValues[0].equals(id)){
                scan.close();
                return new Patient(lineValues[0],
                lineValues[1],
                lineValues[2],
                lineValues[3],
                lineValues[5]);
            }
        }
        scan.close();
        return null;
    }
    public static ArrayList<Employee> getAllEmployees() throws FileNotFoundException{
        ArrayList<Employee> emps = new ArrayList<Employee>();
        File people = new File("Cophea/src/main/resources/com/cophea/people.csv");
        Scanner scan = new Scanner(people);
        String line;
        String[] lineValues = new String[9];
        String[] conds = new String[20];
        //skip headers
        scan.nextLine();
        while (scan.hasNext()){
            line = scan.nextLine();
            lineValues = line.split(",");
            conds = lineValues[6].split("/");
            if (lineValues[5].equals("false")){
                emps.add(new Employee(lineValues[0],
                lineValues[1],
                lineValues[2],
                lineValues[3],
                lineValues[4],
                lineValues[5],
                conds
                ));
            }
        }
        scan.close();
        return emps;
    }

    public static Employee getEmployee(String id) throws FileNotFoundException{
        File people = new File("Cophea/src/main/resources/com/cophea/people.csv");
        Scanner scan = new Scanner(people);
        String line;
        String[] lineValues = new String[9];
        String[] conds = new String[20];
        //skip headers
        scan.nextLine();
        while(scan.hasNext()){
            line = scan.nextLine();
            lineValues = line.split(",");
            conds = lineValues[6].split("/");
            if (lineValues[0].equals(id)){
                scan.close();
                return new Employee(lineValues[0],
                lineValues[1],
                lineValues[2],
                lineValues[3],
                lineValues[4],
                lineValues[5],
                conds
                );
            }
        }
        scan.close();
        return null;
    }

    //resets the person's appointments and loads from scratch
    public static void loadAppts(Person person) throws FileNotFoundException{
        person.getAppointments().clear();
        //System.out.println("running");
        //System.out.println(person);

        File currAppts = new File("Cophea/src/main/resources/com/cophea/appt/"+person.getId()+"_appts.csv");
        Scanner scan = new Scanner(currAppts);
        String[] lineValues = new String[9];
		String line = scan.nextLine();
        lineValues = line.split(",");

        //skip line with headers
        while(scan.hasNext()){
            line = scan.nextLine();
            lineValues = line.split(",");
            //System.out.println(lineValues);
            Employee e = DataManager.getEmployee(lineValues[0]);
            Patient pat = DataManager.getPatient(lineValues[1]);
            person.addAppointment(
                new Appointment(
                    e, 
                    pat, 
                    new TimeSlot(
                    Integer.parseInt(lineValues[2]),
                    Integer.parseInt(lineValues[3]),
                    Integer.parseInt(lineValues[4]),
                    Integer.parseInt(lineValues[5]))
            ));
        }
        scan.close();
        

    }
    //resets the person's working hours and loads from scratch
    public static void loadWorkSlots(Employee emp) throws FileNotFoundException{
        emp.getSlots().clear();
        
        File currWS = new File("Cophea/src/main/resources/com/cophea/ws/"+emp.getId()+"_workinghours.csv");
        Scanner scan = new Scanner(currWS);

        String[] lineValues = new String[9];
		String line = scan.nextLine();
        lineValues = line.split(",");


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

    
    //writes to the doctor first, then the patients file
    public static void writeAppointment(Employee emp,Appointment appo) throws IOException{

        // for (int idk=0;idk<emp.getAppointments().size();idk++){
        //     System.out.println(emp.getAppointments().get(idk));
        //     if (emp.getAppointments().get(idk).equals(appo)){
        //         // System.out.println("appo exists, will not write 1");
        //     }
        // }
        // System.out.println("find this one:"+appo);

        if (emp.getAppointments().contains(appo)){
            System.out.println("appo exists, will not write to file");
            return;
        }
        String id = emp.getId();
		final String partialPath = "Cophea/src/main/resources/com/cophea/appt/";


		String wsPath = partialPath+id;
		File currFile = new File(wsPath+"_appts.csv");

       
			
        FileWriter fw = new FileWriter(currFile,true);
        //System.out.println(appo.write());
        fw.write(System.lineSeparator());
        fw.write(appo.write());
        //fw.write(System.lineSeparator());
        fw.close();
        DataManager.updatePerson(emp);
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //write data to patient file
        id = appo.getPatient().getId();
        wsPath = partialPath+id;
        currFile = new File(wsPath+"_appts.csv");


        fw = new FileWriter(currFile,true);
        //System.out.println(appo.write());
        fw.write(System.lineSeparator());
        fw.write(appo.write());
        //fw.write(System.lineSeparator());
        fw.close();

        
        DataManager.updatePerson(appo.getPatient());
    }

    //

    public static void writeWorkSlot(Employee emp,TimeSlot TS) throws IOException{
        //System.out.println("am i working?");
        String id = emp.getId();
        
        if (emp.getSlots().contains(TS)){
            System.out.println("TS exists, will not write");
            return;
        }

        
        final String partialPath = "Cophea/src/main/resources/com/cophea/ws/";
        String wsPath = partialPath+id;
        File currFile = new File(wsPath+"_workinghours.csv");
 
        FileWriter fw = new FileWriter(currFile,true);
        fw.write(System.lineSeparator());
        fw.write(TS.write());
        //fw.write(System.lineSeparator());
        fw.close();
        DataManager.updatePerson(emp);
        
    }



    //there is no situation where an appointment is cancelled only for the doctor or patient, but not the other
    //in order to avvoid a infinite recursive loop, the function will delete from the doctors file first, then the patient
    public static void deleteAppointment(Appointment appo) throws IOException{
        Employee emp = appo.getProvider();
        String id = emp.getId();
		String partialPath = "Cophea/src/main/resources/com/cophea/appt/";
		String wsPath = partialPath+id;
		File currFile = new File(wsPath+"_appts.csv");
        Scanner scan = new Scanner(currFile);
        String[] lineValues = new String[9];
		
        Appointment tempAppo;
        String header = scan.nextLine();

        ArrayList<Appointment> fileAppointments = new ArrayList<Appointment>();
        


        //loop to load the tempfile array with everything EXCEPT what we dont want to keep
        while (scan.hasNext()){
            //lineValues = scan.nextLine().split(",");
            String line = scan.nextLine();
            lineValues = line.split(",");
            Employee e = DataManager.getEmployee(lineValues[0]);
            Patient pat = DataManager.getPatient(lineValues[1]);
            tempAppo =
                new Appointment(
                    e, 
                    pat, 
                    new TimeSlot(
                    Integer.parseInt(lineValues[2]),
                    Integer.parseInt(lineValues[3]),
                    Integer.parseInt(lineValues[4]),
                    Integer.parseInt(lineValues[5]))
            );
            //if the appointment exists, skip that line so it is not included int the file
            if (appo.equals(tempAppo)){
                if (scan.hasNext()){
                    scan.nextLine();
                }
            }
            else {
                fileAppointments.add(tempAppo);
            }
        }

        //empty out the files contents
        new FileWriter(currFile,false).close();

        //loop and re-add data
        FileWriter fw = new FileWriter(currFile,true);
        fw.write(header);
        //fw.write(System.lineSeparator());
        for (int i=0;i<fileAppointments.size();i++){
            //fw.write("test");
            fw.write(System.lineSeparator());
            fw.write(fileAppointments.get(i).write());
            
        }
        fw.close();
        scan.close();

        DataManager.updatePerson(emp);
        
        /////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////
        // System.out.println("TOUCHING THE PATIENT");
        // System.out.println("TOUCHING THE PATIENT");
        // System.out.println("TOUCHING THE PATIENT");
        // System.out.println("TOUCHING THE PATIENT");
        // System.out.println("TOUCHING THE PATIENT");
        // System.out.println("TOUCHING THE PATIENT");
        //NOW perform the algo on the patient in the appointment
        id = appo.getPatient().getId();
		partialPath = "Cophea/src/main/resources/com/cophea/appt/";
		wsPath = partialPath+id;
		currFile = new File(wsPath+"_appts.csv");
        scan = new Scanner(currFile);
        lineValues = new String[9];
        header = scan.nextLine();
		
        
        fileAppointments = new ArrayList<Appointment>();

        while (scan.hasNext()){
            //lineValues = scan.nextLine().split(",");
            lineValues = scan.nextLine().split(",");
            Employee e = DataManager.getEmployee(lineValues[0]);
            Patient pat = DataManager.getPatient(lineValues[1]);
            tempAppo =
                new Appointment(
                    e, 
                    pat, 
                    new TimeSlot(
                    Integer.parseInt(lineValues[2]),
                    Integer.parseInt(lineValues[3]),
                    Integer.parseInt(lineValues[4]),
                    Integer.parseInt(lineValues[5]))
            );
           
             
            //if the appointment exists, skip that line so it is not included int the file
            if (appo.equals(tempAppo)){
                if (scan.hasNext()){
                    scan.nextLine();
                }
            }
            else {
                fileAppointments.add(tempAppo);
            }
        }

        //empty out the files contents
        new FileWriter(currFile,false).close();

        //loop and re-add data
        fw = new FileWriter(currFile,true);
        fw.write(header);
        //fw.write(System.lineSeparator());
        for (int i=0;i<fileAppointments.size();i++){
            fw.write(System.lineSeparator());
            //fw.write("test");
            fw.write(fileAppointments.get(i).write());
        }
        fw.close();
        scan.close();
        DataManager.updatePerson(appo.getProvider());
    }

    public static void deleteWorkSlot(Employee emp,TimeSlot TS) throws IOException{



        String id = emp.getId();
        String partialPath = "Cophea/src/main/resources/com/cophea/ws/";
        String wsPath = partialPath+id;
        File currFile = new File(wsPath+"_workinghours.csv");

        Scanner scan = new Scanner(currFile);
        String[] lineValues = new String[9];

        ArrayList<TimeSlot> fileWS = new ArrayList<TimeSlot>();
		
        TimeSlot tempTS;
        String header = scan.nextLine();

        while (scan.hasNext()){
            //lineValues = scan.nextLine().split(",");
            String line = scan.nextLine();
            lineValues = line.split(",");
            tempTS = new TimeSlot(
                Integer.parseInt(lineValues[0]),
                Integer.parseInt(lineValues[1]),
                Integer.parseInt(lineValues[2]),
                Integer.parseInt(lineValues[3]));

            if (tempTS.equals(TS)){
                if (scan.hasNext()){
                    scan.nextLine();
                }
            }
            else {
                
                fileWS.add(tempTS);
            }
        }

        //empty
        new FileWriter(currFile,false).close();

        //loop and re-add data
        FileWriter fw = new FileWriter(currFile,true);
        fw.write(header);
        //fw.write(System.lineSeparator());
        for (int i=0;i<fileWS.size();i++){
            fw.write(System.lineSeparator());
            fw.write(fileWS.get(i).write());
            //fw.write(System.lineSeparator());
        }
        
        fw.close();
        scan.close();
        DataManager.updatePerson(emp);
    }
    
    
}
