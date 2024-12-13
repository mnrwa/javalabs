package task14.A;

import org.junit.jupiter.api.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServerClientTest {

    private static final int PORT = 12345;
    private static ExecutorService serverExecutor;
    private static ServerSocket serverSocket;
    private static volatile boolean isRunning = true;

    @BeforeAll
    static void setUpServer() throws IOException {
        serverExecutor = Executors.newSingleThreadExecutor();
        serverExecutor.submit(() -> {
            try {
                serverSocket = new ServerSocket(PORT);
                while (isRunning) {
                    try {
                        Socket client = serverSocket.accept();
                        new PrintWriter(client.getOutputStream(), true).println("Добро пожаловать!");
                        client.close();
                    } catch (SocketException e) {
                        if (!isRunning) break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @AfterAll
    static void tearDownServer() throws IOException {
        isRunning = false;
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
        }
        serverExecutor.shutdownNow();
    }

    @Test
    void testClientReceivesWelcomeMessage() throws IOException {
        try (Socket socket = new Socket("127.0.0.1", PORT);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String response = input.readLine();
            assertEquals("Добро пожаловать!", response, "Сообщение сервера не совпадает!");
        }
    }

    @Test
    void testServerHandlesMultipleClients() throws IOException {
        int clientCount = 3;
        String[] responses = new String[clientCount];

        for (int i = 0; i < clientCount; i++) {
            try (Socket socket = new Socket("127.0.0.1", PORT);
                 BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                responses[i] = input.readLine();
            }
        }

        for (String response : responses) {
            assertEquals("Добро пожаловать!", response, "Сообщение для клиента неверно!");
        }
    }
}

