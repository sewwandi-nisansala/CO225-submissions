import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    //List of contacts
    static List<ContactData> contactDataList;


     // This function will start the program
    public void start(String argument) {

         //Initialize the contact list
        contactDataList = new ArrayList<ContactData>();

        //Update the contact data list from the csv
        updateContactList(contactDataList);

        //Check if the argument's 1st letter is "F" or "L"
        // If it is F -> check for first names
        if(argument.charAt(0)=='F'){
            //Remove 1st character of the argument ("F")
            argument = argument.substring(1);
            //Remove 2nd character of the argument (":")
            argument = argument.substring(1);
            //Foreach loop Contact data objects, check the first name is same?
            for (ContactData data : contactDataList) {
                //Check 1st name is the same or not
                if(data.getFirstName().equals(argument)){
                    //If 1st name is the same, then print it
                    System.out.println(data.getFirstName()+" "+data.getLastName()+" : "+data.getPhoneNumber());
                }
            }
            //Repeat above method for the Last name too
        }else if(argument.charAt(0)=='L'){
            argument = argument.substring(1);
            argument = argument.substring(1);
            // This is if the last letter
            for (ContactData data : contactDataList) {
                if(data.getLastName().equals(argument)){
                    System.out.println(data.getFirstName()+" "+data.getLastName()+" : "+data.getPhoneNumber());
                }
            }
        }
    }

    //Update the contact list from a CSV

    private void updateContactList(List<ContactData> contactDataList) {
        // contacts file name (All the contacts.csv file to the project root folder)
        String fileNameDefined = "./contacts.csv";

        //Try reading the contacts.csv file
        try {
            //Read the file
            BufferedReader wr = new BufferedReader(new FileReader(new File(fileNameDefined)));
            String line;
            //Read the contact file line by line
            while ((line = wr.readLine()) != null) {
                //Since the csv file has data as comma separated,
                //we can Split the string data in the line with commas
                //Split data will store as String array
                String[] contactLine = line.split(",");
                //Create a contact object
                ContactData data = new ContactData(contactLine[0],contactLine[1],contactLine[2]);
                //Add contact object to the contact array list
                contactDataList.add(data);
            }
            //Close the file reader
            wr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // -File class needed to turn stringName to actual file
        File file = new File(fileNameDefined);

        try{
            // -read from filePooped with Scanner class
            Scanner inputStream = new Scanner(file);
            // hashNext() loops line-by-line
            while(inputStream.hasNext()){
                //read single line, put in string
                String data = inputStream.next();

            }
            // after loop, close scanner
            inputStream.close();


        }catch (FileNotFoundException e){

            e.printStackTrace();
        }
    }
}
