package ss16_io_text_file.bai_tap.copy_file_text;

import java.io.*;

public class CopyFileCode {
    public static void main(String[] args) {
        CopyFileCode copyFileCode = new CopyFileCode();
        String line1 = copyFileCode.readFile("src/ss16_io_text_file/bai_tap/copy_file_text/SourceCode.csv");
        copyFileCode.writeFile("src/ss16_io_text_file/bai_tap/copy_file_text/TargetCode.csv",line1);

    }


    public String readFile(String path) {
        String line = "";
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                line += line ;
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

    public void writeFile(String path,String line){
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
