import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int numPrizeQueue = 10;
        String nameWinFile = "prizes.txt";

        Scanner scan = new Scanner(System.in);

        Control controller = new Control();

        ArrayList<Toy> toys = new ArrayList<>();
        toys.add(new Toy(1, "конструктор", 60));
        toys.add(new Toy(2, "робот", 20));
        toys.add(new Toy(3, "кукла", 20));

        System.out.println("Укажите, сколько необходимо выигрышей:\n");
        int numPlays = scan.nextInt();

        //Генерируем выигрыши
        ArrayList<Toy> toysWin = new ArrayList<>();
        for (int i = 0; i < numPlays; i++) {
            toysWin.add(controller.getLottery(toys, numPrizeQueue));
        }
        // Запись призов в файл
        controller.writeFile(toysWin,nameWinFile);

        // Читаем призы из файла
        controller.readFile(nameWinFile);
    }
}