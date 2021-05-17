import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Tasks {
    /*
     * 11. а) підраховує кількість слів у кожному реченні;
     * б) виводить на екран найдовше речення.
     * */
    public static void task1() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рядок : ");
        String str = scanner.nextLine();

        if (str.length() == 0) {
            throw new IOException("Не був введений рядок!");
        }

        System.out.println("\nРезультат :");
        task1_1(str);
    }

    //а) підраховує кількість слів у кожному реченні; б) виводить на екран найдовше речення.
    private static void task1_1(String str){
        String[] sentence = str.split("[.]");

        System.out.println("a)Кількість слів у реченнях : ");
        int max = 0, index = 0;
        for(int i =0;i<sentence.length;i++) {
            String p = sentence[i];
            p = p.replaceAll("[.,?!'\"]", "");
            String[] words = p.split("[\\s]+");
            if(words.length > max){
                max = words.length;
                index = i;
            }
            System.out.print(words.length + " ");
        }
        System.out.println();

        System.out.println("б)Найдовше речення = " + sentence[index]);
    }


    /*
    * 11. Розробити консольний застосунок, що дозволяє писати і читати дані в текстовий файл.
    * Дані є записами результатів  іспиту – прізвище студента і його оцінка.
    * Ім'я текстового файлу включає назву предмету.
    * */
    public static void task2(String filepath) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String text = inputFile("History.txt");
        for(;;){
            System.out.print("1.Додати інформацію" + "\n" +
                    "2.Вивести інформацію" + "\n" +
                    "3.Вихід" + "\n" +
                    "Введіть число : ");
            int nomer = scanner.nextInt();

            switch (nomer) {
                case 1 -> {
                    System.out.print("Введіть інформацію : ");
                    scanner.nextLine();
                    String line = scanner.nextLine();
                    text += line + '\n';
                    outputFile("History.txt", text);
                }
                case 2 -> {
                    if(text.length() == 0) {
                        System.err.println("Додайте спочатку інформацію!");
                        continue;
                    }

                    System.out.println("Інформація :");
                    System.out.println(text);
                }
                case 3 -> {
                    return;
                }
            }
        }
    }



    /*
    * б) виводить на екран частоту входження кожної літери.
     * */
    public static void task3(String inputPath, String outputPath) throws IOException {
        String text = inputFile(inputPath);

        if(text.length() <= 0) throw new IOException("Файл пустий.");

        System.out.println("Текст :" + "\n" + text);

        ArrayList<Character> chars = new ArrayList<Character>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        text = text.replaceAll("[.!,?;:'\" <>]", "");
        char[] chars1 = text.toCharArray();

        for (char ch : chars1) {
            if(!chars.contains(ch)){
                chars.add(ch);
                count.add(1);
            }
            else{
                count.set(chars.indexOf(ch), count.get(chars.indexOf(ch)) + 1);
            }
        }

        String result = "Кіклькість літер :" + "\n";
        for(int i=0;i<chars.size();i++)
            result += chars.get(i) + " - " + count.get(i) + "\n";
        outputFile(outputPath, result);
        System.out.println(result);
    }



    private static void isFile(String filepath) throws IOException{
        //перевірка чи файл існує
        File file = new File(filepath);
        if(!file.isFile()) throw new IOException("Файл не знайдено!");
    }

    private static void createFile(String filepath) throws IOException{
        //перевірка чи файл існує
        File file = new File(filepath);
        if(!file.isFile())
            file.createNewFile();
    }

    private static void outputFile(String filepath, String text) throws IOException{
        isFile(filepath);

        //записуємо в файл
        BufferedWriter output = new BufferedWriter(new FileWriter(filepath));
        output.write(text);
        output.flush();
        output.close();
        output.close();
    }


    private static String inputFile(String filepath) throws IOException {
        isFile(filepath);

        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String text;
        StringBuilder lines = new StringBuilder();
        //зчитуємо текст з файлу
        while ((text = reader.readLine()) != null) {
            lines.append(text);
        }
        reader.close();
        return lines.toString();
    }
}
