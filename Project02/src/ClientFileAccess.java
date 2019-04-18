
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ClientFileAccess {

    private File file = null;

    public ClientFileAccess() {

    }

    public synchronized boolean addClient(Client client, String fileName) throws IOException {
        file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            String data = "";
            data = client.getName() + "$";
            data += client.getDate() + "$";
            data += client.getTime() + "$";
            data += client.getSymbol() + "$";
            data += client.getPre_price()+ "$";
            data += client.getNew_price()+ "$";

            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.flush();
            return true;
        } finally {
            bufferedWriter.close();
            fileWriter.close();

        }

    }

    public List<Client> getAllClients(String fileName) throws FileNotFoundException, IOException {
        List<Client> clientList = new ArrayList<>();
        file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            if (file.exists()) {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);

                String line = bufferedReader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line, "$");

                String[] ar = new String[tokenizer.countTokens()];
                for (int i = 0; i < ar.length; i++) {
                    ar[i] = tokenizer.nextToken();
                }
                for (int i = 0; i < ar.length; i += 6) {
                    clientList.add(new Client(ar[i], ar[i + 1], ar[i + 2], ar[i + 3], Double.parseDouble(ar[i + 4]),Double.parseDouble(ar[i + 5])));
                }
            }

        } finally {
            fileReader.close();
            bufferedReader.close();
        }
        return clientList;

    }

    public synchronized void addLog(String log, String fileName) throws IOException {
        file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(log + "$");
            bufferedWriter.flush();
        } finally {
            bufferedWriter.close();
            fileWriter.close();

        }
    }

    public List<String> getAllLogs(String fileName) throws FileNotFoundException, IOException {
        List<String> logs = new ArrayList<>();
        file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            if (file.exists()) {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);

                String line = bufferedReader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line, "$");

                String[] ar = new String[tokenizer.countTokens()];
                for (int i = 0; i < ar.length; i++) {
                    ar[i] = tokenizer.nextToken();
                    logs.add(new String(ar[i]));
                }
            }

        } finally {
            fileReader.close();
            bufferedReader.close();
        }
        return logs;

    }

}
