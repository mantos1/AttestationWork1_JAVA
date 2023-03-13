import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Control {
    public PriorityQueue<Toy> getQueue(ArrayList<Toy> toys, int number) {

        Comparator<Toy> comparator = (o1, o2) -> o1.getWeight() - o2.getWeight();
        PriorityQueue<Toy> prizes = new PriorityQueue<>(comparator);
        for (int i = 0; i < toys.size(); i++) {
            for (int j = 0; j < (toys.get(i).getWeight() * number / 100); j++) {
                prizes.add(toys.get(i));
            }
        }
        return prizes;
    }

    public Toy getLottery(ArrayList<Toy> toys, Integer number) {
        Toy prizeToy = null;
        PriorityQueue<Toy> sortyQueue = getQueue(toys, number);

        Random random = new Random();
        int element = random.nextInt(0, sortyQueue.size());
        for (int i = 0; i <= element; i++) {
            prizeToy = sortyQueue.poll();
        }
        return prizeToy;
    }

    public void writeFile(ArrayList<Toy> toys, String nameFile) {
        try {
            FileWriter file = new FileWriter(nameFile);
            BufferedWriter writer = new BufferedWriter(file);
            for (int i = 0; i < toys.size(); i++) {
                writer.write(toys.get(i).toString() + "\n");
            }
            writer.close();
        } catch (Exception ex) {
            System.out.println("Ошибка записи в файл");
        }
    }

    public void readFile(String nameFile) {
        try {
            FileReader fr = new FileReader(nameFile);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения файла");
        }
    }
}
