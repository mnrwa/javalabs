package ru.bahanov.pracJava.task10.B;

import java.io.*;

public class NecklaceConnector {
    public static void saveNecklace(Necklace necklace, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(necklace);
        }
    }

    public static Necklace loadNecklace(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Necklace) ois.readObject();
        }
    }
}
