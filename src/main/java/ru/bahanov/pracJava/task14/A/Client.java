package ru.bahanov.pracJava.task14.A;

import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            Thread serverListener = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = input.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Соединение с сервером потеряно.");
                }
            });
            serverListener.start();

            String userInput;
            while ((userInput = consoleInput.readLine()) != null) {
                output.println(userInput);
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
