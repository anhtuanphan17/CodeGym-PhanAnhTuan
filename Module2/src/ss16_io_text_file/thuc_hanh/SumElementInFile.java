package ss16_io_text_file.thuc_hanh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SumElementInFile {

    public void readFileText(String filePath){

        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            int sum = 0;
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
                sum+=Integer.parseInt(line);
            }

            bufferedReader.close();

            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input filepath");
        String path = scanner.nextLine();

        SumElementInFile sumElementInFile = new SumElementInFile();
        sumElementInFile.readFileText(path);

    }

}

