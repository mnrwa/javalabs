package ru.bahanov.pracJava.task14;

import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static final int PORT = 12345;
    private static ConcurrentHashMap<String, PrintWriter> clients = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Сервер запущен...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private String clientName;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Введите ваше имя:");
                clientName = in.readLine();
                if (clientName == null || clientName.isEmpty()) {
                    socket.close();
                    return;
                }

                System.out.println(clientName + " подключился.");
                clients.put(clientName, out);
                sendToAll(clientName + " присоединился к чату.");

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("exit")) break;
                    sendToAll(clientName + ": " + message);
                }
            } catch (IOException e) {
                System.out.println("Соединение с " + clientName + " потеряно.");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clients.remove(clientName);
                sendToAll(clientName + " покинул чат.");
                System.out.println(clientName + " отключился.");
            }
        }

        private void sendToAll(String message) {
            for (PrintWriter clientOut : clients.values()) {
                clientOut.println(message);
            }
        }
    }
}
