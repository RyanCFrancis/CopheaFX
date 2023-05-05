package com.cophea;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner; 
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class DataManager {


    public static Boolean loadPatientLogin(String loginString,String pwString) throws FileNotFoundException{
        File people = new File("Cophea/src/main/resources/com/cophea/test.csv");
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
                return true;
            }
        }
        scan.close();
        return false;

    }

    public static Patient loadPatient(String id) throws FileNotFoundException{
        File people = new File("Cophea/src/main/resources/com/cophea/test.csv");
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


    public static Employee loadEmployee(String id) throws FileNotFoundException{
        File people = new File("Cophea/src/main/resources/com/cophea/test.csv");
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
                return new Employee(lineValues[0],
                lineValues[1],
                lineValues[2],
                lineValues[3],
                lineValues[4],
                lineValues[5]
                );
            }
        }
        scan.close();
        return null;
    }

    public static void loadAppts(Person person) throws FileNotFoundException{
        System.out.println("running");
        System.out.println(person);

        File currAppts = new File("Cophea/src/main/resources/com/cophea/appt/"+person.getId()+"_appts.csv");
        Scanner scan = new Scanner(currAppts);
        String[] lineValues = new String[9];
		String line = scan.nextLine();
        lineValues = line.split(",");

        //skip line with headers
        scan.nextLine();
        while(scan.hasNext()){
            lineValues = scan.nextLine().split(",");
            Patient pat = DataManager.loadPatient(lineValues[1]);
            Employee e = DataManager.loadEmployee(lineValues[0]);
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

    public static void loadWorkSlots(Employee emp) throws FileNotFoundException{
        
        File currWS = new File("Cophea/src/main/resources/com/cophea/ws/"+emp.getId()+"_workinghours.csv");
        Scanner scan = new Scanner(currWS);

        String[] lineValues = new String[9];
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

    public static void writeAppointment(Person person,Appointment appo) throws IOException{
        String id = person.getId();
		String partialPath = "Cophea/src/main/resources/com/cophea/appt/";
		String wsPath = partialPath+id;
		File currFile = new File(wsPath+"_appts.csv");

			
        //if file doesnt exist, intialize it
			if (!currFile.isFile()){
				System.out.println("NEW FILE BEING MADE");

				currFile.createNewFile();
				FileWriter fw = new FileWriter(currFile,false);
				fw.write("emp_id,p_id,year,month,day,hour");
				//close the writer to "save" the file
				fw.close();
			}
			System.out.println(person);
			FileWriter fw = new FileWriter(currFile,true);
			fw.write(appo.write());
			fw.close();
		

    }

    public static void writeWorkSlot(Employee emp,TimeSlot TS) throws IOException{
        //TODO MAKE WRITE FUNCTION IN TIMESLOT
            String id = emp.getId();
			String partialPath = "Cophea/src/main/resources/com/cophea/ws/";
			String wsPath = partialPath+id;
			File currFile = new File(wsPath+"_workinghours.csv");
			
			
			//if file doesnt exist, intialize it
			if (!currFile.isFile()){
				System.out.println("NEW FILE BEING MADE");

				currFile.createNewFile();
				FileWriter fw = new FileWriter(currFile,false);
				fw.write("year,month,day,hour");
				//close the writer to "save" the file
				fw.close();
			}
			FileWriter fw = new FileWriter(currFile,true);
			fw.write(TS.write());
			fw.close();
    }
}
