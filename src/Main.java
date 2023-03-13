import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int numPrizeQueue = 10;
        String nameWinFile = "prizes.txt";

        Scanner scan = new Scanner(System.in);

        Control controller = new Control();

        Toy lego = new Toy(1, "конструктор", 60);
        Toy robot = new Toy(2, "робот", 20);
        Toy doll = new Toy(3, "кукла", 60);

        ArrayList<Toy> toys = new ArrayList<>();
        toys.add(lego);
        toys.add(robot);
        toys.add(doll);

        String check = null;
        while (check != "q"){
            String name = null;
            String weight = null;
            int id = 0;
            System.out.println("Нажмите '1' чтобы добавить игрушку, либо 'q' чтобы продолжить:\n");
            check = scan.next().toString();
            if (check.equals("1")) {
                System.out.println("Укажите название игрушки:\n");
                name = scan.next();
                System.out.println("Укажите вес игрушки:\n");
                weight = scan.next();
                id = toys.size() + 1;
                toys.add(new Toy(id, name, Integer.parseInt(weight)));
            } else {
                break;
            }
        }
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