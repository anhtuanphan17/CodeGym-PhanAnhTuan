package ss16_io_text_file.thuc_hanh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMax {


    public static void main(String[] args) {
        FindMax findMax = new FindMax();

        Scanner scanner = new Scanner(System.in);
        System.out.println("input pathfile");
        String path = scanner.nextLine();


        List<Integer> list = findMax.readFileText(path);
        int max = findMax.findMax(list);
        findMax.writeFileText("src/ss16_io_text_file/thuc_hanh/result.txt",max);

    }
    public List<Integer> readFileText(String pathfile){
        File file = new File(pathfile);
        List<Integer> numbers =  new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line=bufferedReader.readLine())!=null){
                numbers.add(Integer.parseInt(line));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    public void writeFileText(String pathfile, int max){

        try {
            FileWriter fileWriter = new FileWriter(pathfile,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("max is "+ max);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Integer findMax(List<Integer> list){
        int max  = list.get(0);
        for (int i=0;i<list.size();i++){
            if(list.get(i)>max){
                max=list.get(i);
            }
        }
        return max;
    }
}
