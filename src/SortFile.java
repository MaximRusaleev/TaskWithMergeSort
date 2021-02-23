import java.io.*;
import java.util.*;

public class SortFile {

    public static MergeSortGen mergeSortGen = new MergeSortGen();

    public static void main(String[] args) throws IOException {

        InputParameter inputParameter = new InputParameter(args);

        System.out.println(inputParameter.toString());



        /*ArrayList<Integer> list9 = new ArrayList<>();
        int i = 0;
        while (i < 1000) {
            list9.add((int)Math.round(Math.random() * 100));
            i++;
        }
        ArrayList<Integer> list7 = new ArrayList<>(Arrays.asList(10, 5, 2, 3));
        ArrayList<String> list8 = new ArrayList<>();
        ArrayList<Integer> result5 = mergeSortGen.sortArray(list7, true);
        Iterator<Integer> iterator = result5.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
    }
}
