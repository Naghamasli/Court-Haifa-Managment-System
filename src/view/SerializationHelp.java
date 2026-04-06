package view;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import control.Court;


public class SerializationHelp {
	private static final String filePath = "Court.ser";

    public static void saveCourt(Court court) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(court);
            System.out.println("Court object saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Court loadCourt() {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File " + filePath + " does not exist.");
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
        	Court hotel = (Court) ois.readObject();
            System.out.println("Court object loaded successfully!");
            return hotel;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}