/**
 * project 2 AUCTION SERVER done by E15243 & E15271
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;


public class ServerStart {

    public static final int BASE_PORT = 2000;
    private static ServerSocket serverSocket;
    private static int socketNumber;
    private StockFileAccess stockFileAccess;
    private List<Stock> stockList;
    private Display viewStock;

    public static final HashMap<String, List<ServerConnector>> connections = new HashMap<>();

    public ServerStart(int socket) throws IOException {
        serverSocket = new ServerSocket(socket);
        socketNumber = socket;
        stockFileAccess = new StockFileAccess();
        stockList = stockFileAccess.getStockDetails();
        viewStock = new Display(stockList);
        System.out.println("Server is started  ");
        viewStock.setVisible(true);
    }

    public void server_loop() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            ServerConnector serverConnector = new ServerConnector(socket, stockList, viewStock);
            serverConnector.start();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerStart serverStart = new ServerStart(BASE_PORT);
        serverStart.server_loop();
    }
}
