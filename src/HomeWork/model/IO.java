package HomeWork.model;

import HomeWork.ui.Comm.Save;

import java.io.*;

public class IO implements Load, Save {


    @Override
    public Serializable load(String path) {
        Serializable personRestored = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path))) {
            personRestored = (Serializable) objectInputStream.readObject();
            System.out.println("\nСемейное древо загружено !\n");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + path);
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

        return personRestored;
    }


    @Override
    public void save(String path, Serializable obj) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path))) {
            objectOutputStream.writeObject(obj);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + path);
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}