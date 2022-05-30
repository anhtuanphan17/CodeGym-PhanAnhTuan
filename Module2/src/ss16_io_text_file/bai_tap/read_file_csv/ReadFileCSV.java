package ss16_io_text_file.bai_tap.read_file_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {


    public static void main(String[] args) {
        ReadFileCSV readFileCSV = new ReadFileCSV();

        List<Nation> nationList = readFileCSV.readFile("src/ss16_io_text_file/bai_tap/read_file_csv/NationList.csv");
        for (int i = 0; i < nationList.size(); i++) {
            System.out.println(nationList.get(i).getName());
        }
    }


    public List<Nation> readFile(String path) {
        List<Nation> list = new ArrayList<>();
        try {
            File file = new File(path);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            String[] array = null;

            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                list.add(new Nation(array[0], array[1], array[2]));
            }
            bufferedReader.close();
            fileReader.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
