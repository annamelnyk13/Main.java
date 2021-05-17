import java.io.*;

//@author pro100user

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1.Завданння 1" +
                "\n2.Завданння 2" +
                "\n3.Завдання 3" +
                "\n4.Вихід" +
                "\nВведіть число : ");
        int num = scanner.nextInt();

        while(num != 4){
            try {
                switch (num) {
                    case 1:
                        System.out.println("\nЗавданння 1 :");
                        Tasks.task1();
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("\nЗавданння 2 :");
                        Tasks.task2("file.txt");
                        break;
                    case 3:
                        System.out.println("\nЗавданння 3 :");
                        Tasks.task3("input.txt", "output.txt");
                        break;
                    default:
                        System.out.println("Не вірно введене число!Введіть ще раз :");
                        break;
                }
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
            System.out.print("\n1.Завданння 1" +
                    "\n2.Завданння 2" +
                    "\n3.Завдання 3" +
                    "\n4.Вихід" +
                    "\nВведіть число : ");
            num = scanner.nextInt();
        }
    }
}
