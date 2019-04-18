
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class StockFileAccess {

    private File file = null;
    private List<Stock> stockList = new ArrayList<>();
    private String[] symbols = {"FB", "VRTU", "MSFT", "GOOGL", "YHOO", "XLNX", "TSLA", "TXN"};

    public StockFileAccess() {
        file = new File("stocks.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    //read contact list from the csv file
    public List<Stock> getStockDetails() throws FileNotFoundException, IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        String[] stockArray;
        try {
            if (file.exists()) {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                String line = bufferedReader.readLine();

                while ((line = bufferedReader.readLine()) != null) {
                    stockArray = line.split(",");
                    stockList.add(new Stock(stockArray[0], stockArray[1],  Double.parseDouble(stockArray[stockArray.length - 1])));

                }
            }
        } finally {
            fileReader.close();
            bufferedReader.close();
        }

        return stockList;
    }

    public synchronized boolean updateStockPrice(String symbol, double price) throws FileNotFoundException, IOException {
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        List<Stock> list = new ArrayList<>();
        try {
            if (file.exists()) {
                bufferedReader = new BufferedReader(new FileReader(file));
                String line = bufferedReader.readLine();
                String[] stockArray = new String[4];
                while ((line = bufferedReader.readLine()) != null) {
                    StringTokenizer tokenizer = new StringTokenizer(line, ",");
                    for (int i = 0; i < 3; i++) {
                        stockArray[i] = tokenizer.nextToken();
                    }
                    if (stockArray[0].equals(symbol)) {
                        stockArray[2] = Double.toString(price);
                        break;
                    }
                }

                fileWriter = new FileWriter(file, false);

                for (int i = 0; i < stockArray.length; i++) {
                    fileWriter.append(stockArray[i].toString() + ",");

                }
                fileWriter.flush();
                return true;

            } else {
                return false;
            }
        } finally {

            fileWriter.close();
            bufferedReader.close();

        }

    }
}
