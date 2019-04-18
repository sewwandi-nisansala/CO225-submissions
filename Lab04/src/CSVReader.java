import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;

public class CSVReader{

    private static LinkedBlockingDeque<String> set;

    public static void main(String[] args) {

       // String csvFile = "C:/Users/bhagya/Documents/Semester 4/CO225- Software Construction/labs 2018/lab4/src/contacts.csv";

        public static ArrayList <String> readAllLinesFromFile(String path) throws IOException {

            // System.out.println("Cannot locate input file");

            ArrayList<String> contactList = new ArrayList<String>();
            FileReader fileReader = new FileReader("contacts.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine())!=null) {
                contactList.add(line);
            }
            bufferedReader.close();
            return contactList;
        }


/*
        String csvFile = "./contacts.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";


      String[] contacts = new String[0];
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                contacts = line.split(cvsSplitBy);


                 if (args[0]. equals (contacts[0]) || args[0]. equals (contacts[1])) {
                    System.out.println(contacts[2]);
                }
                else if(args[0]. equals ("F:"+contacts[0]) || args[0]. equals ("L:"+contacts[1])) {
                    System.out.println(contacts[0]+" "+contacts[1]+" "+contacts[2]);
                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
*/
    }
}



