
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class ServerConnector extends Thread {

    private Socket connectionSocket;
    private PrintWriter out;
    private BufferedReader in;
    private SimpleDateFormat dateFormat;
    private SimpleDateFormat dateFormat2;
    private SimpleDateFormat fileDateFormat;
    private SimpleDateFormat timeFormat;
    private List<ServerConnector> symbolConnectors;
    private static List<Stock> stockList;
    private static StockFileAccess stockFileAccess;
    private Display viewStock;
    private static ClientFileAccess clientFileAccess;
    private double stockPrice;
    public ServerConnector(Socket connectionSocket, List<Stock> stockList,Display viewStock) {
        this.connectionSocket = connectionSocket;
        this.stockList = stockList;
        this.stockFileAccess=new StockFileAccess();
        this.viewStock=viewStock;
        this.clientFileAccess = new ClientFileAccess();
        dateFormat = new SimpleDateFormat("EEEEEEEE , yyyy/MM/dd");
        dateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
        fileDateFormat = new SimpleDateFormat("yyyyMMdd");
        timeFormat = new SimpleDateFormat("hh:mm a");

    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(this.connectionSocket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(this.connectionSocket.getOutputStream()));
            String name, symbol, line;
            double bid;

            printMessage("Enter name : ");//take the name of the bidder
            name = in.readLine();

            printMessage("You have been successfully logged in \n");
            printMessage("Enter 'quit' to leave\n");

            printMessage("\nEnter symbol : ");//take the symbol of the bidding item
            symbol = in.readLine();

            while (true) {

                //run till the user input a valid symbol
                if (!isValidateSymbol(symbol)) {
                    while (true) {
                        printMessage("Enter valid symbol : ");
                        symbol = in.readLine().trim();
                        if (isValidateSymbol(symbol)) {
                            break;
                        }
                    }
                }

                /*when the connection is setup the serverconenction object is added to a hashmap with the key of input symbol*/
                if (!ServerStart.connections.containsKey(symbol)){
                    ServerStart.connections.put(symbol, new ArrayList<>());
                }
                
                ServerStart.connections.get(symbol).add(this);//add this ServerConnector object to the list of conenctions
                

                
                //start for bidding
                printMessage("Start bidding for " + symbol + "\n");

                //get the current stock price 
                stockPrice = getStockPrice(symbol);

                //print the current stockPrice
                printMessage("Current stock price of " + symbol + " = " + stockPrice + "\n");

                printMessage("\nEnter bid :");//get the new bid price from the user

                for (line = in.readLine(); line != null && !line.equals("quit"); line = in.readLine()) {
                    try {
                        bid = Double.parseDouble(line);//get the use input bid value
                        if (checkBid(bid, symbol)) {//check for the bid price 

                            printMessage("\nBid successful.Now the Current Price : " + bid + "\n");//print this message if the input bid if higher than the current value

                            symbolConnectors = ServerStart.connections.get(symbol);//get the connection list of the given symbol to ServerConnection typed List

                            /*broadcast the newly updated price to all the sockets that connected to the server with relavant symbol*/
                            for (ServerConnector serverConnector : symbolConnectors) {
                                if (!this.equals(serverConnector)) {
                                    serverConnector.printMessage("\nA new bid has made.Now the Current price of " + symbol + " : " + bid + "\n");
                                    serverConnector.printMessage("Enter bid : ");
                                    serverConnector.stockPrice=bid;
                                }
                            }
                            
                            
                            //add the client details into the client log
                            clientFileAccess.addClient(new Client(dateFormat2.format(new Date()),timeFormat.format(new Date()),name,symbol,stockPrice,bid),fileDateFormat.format(new Date())+"_auction.txt");
                            
                            stockPrice=getStockPrice(symbol);
                            
                            //Update the stock table in the GUI 
                            viewStock.updateStockList(stockList);
                            
                            //Update log in GUI
                            viewStock.updateAuctionLog(clientFileAccess);
                            
                        } else {
                            printMessage("\nLow bid for " + symbol + " .Try again!\n");//display the message when the input value is less than the current price
                        }
                    } catch (NumberFormatException ex) {
                        printMessage("Invalid type of input for bid\n"); // print error when the client input invalid type of argument
                    } finally {
                        printMessage("Enter bid : ");
                    }
                }
                break;

            }

            this.connectionSocket.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //print the messages on the client side
    public void printMessage(String message) {
        out.print(message);
        out.flush();
    }

    //compare the bid price with the current stock price
    private synchronized static boolean checkBid(double newPrice, String symbol) throws IOException {
        if (getStockPrice(symbol) >= newPrice) {
            return false;
        } else {
            updatePrice(symbol, newPrice);
            return true;

        }
    }

    //to get the stock price of the relevant symbol
    public static double getStockPrice(String symbol) {
        double stockPrice = 0d;
        for (Stock stock : stockList) {
            if (stock.getSymbol().equals(symbol)) {
                stockPrice = stock.getPrice();
            }
        }
        return stockPrice;
    }

    //update the stock price when the client input price is higher than the current stock price
    public static void updatePrice(String symbol, double newPrice) {
        for (Stock stock : stockList) {
            if (stock.getSymbol().equals(symbol)) {
                stock.setPrice(newPrice);
            }
        }
    }

    //check whether input symbol is valid or not
    private boolean isValidateSymbol(String symbol) {
        for (Stock stock : stockList) {
            if (stock.getSymbol().equals(symbol)) {
                return true;
            }
        }
        return false;
    }

}
