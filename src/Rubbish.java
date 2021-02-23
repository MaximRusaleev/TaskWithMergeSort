import java.io.*;

public class Rubbish {

    public void watchFile(String fileName) {
        try {
            File file = new File(fileName);

            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader, 200);

            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("NoFile!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void createRandomFile(String fileName) {
        int i = 0;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            while (i < 1000000) {
                bufferedWriter.write(Math.round(Math.random() * 100000) + System.lineSeparator());
                i++;
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
