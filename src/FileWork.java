import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

public class FileWork {

    private int numberOfFile = 0;

    public void fileSplit(String fileName, int numberOfLines) {
        int currentNumberOfLines = 0;
        String line;
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader, 200);
            while ((line = bufferedReader.readLine()) != null) {
                linkedList.add(line);
                System.out.println(line);
                currentNumberOfLines++;
                if (numberOfLines == currentNumberOfLines) {
                    fileWrite("intermediate_file" + numberOfFile + ".txt", linkedList);
                    currentNumberOfLines = 0;
                    numberOfFile++;
                    linkedList.clear();
                }
            }
            if (!linkedList.isEmpty()) {
                fileWrite("file" + numberOfFile + ".txt", linkedList);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public <E> void fileWrite(String fileName, LinkedList<E> linkedList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            Iterator<E> iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                bufferedWriter.write(iterator.next().toString() + (iterator.hasNext() ? System.lineSeparator() : null));
            }
            /*for (var s : linkedList) {
                bufferedWriter.write(s.toString() + System.lineSeparator());
            }*/
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
