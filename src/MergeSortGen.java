import java.util.*;

public class MergeSortGen {

    public <E extends Comparable<E>> ArrayList<E> sortArray(ArrayList<E> arrayList, Boolean order) {
        if (arrayList.isEmpty()) {
            return null;
        }

        if (arrayList.size() < 2) {
            return arrayList; // возврат в рекурсию в строки ниже см комменты.
        }
        ArrayList<E> arrayListLeft = new ArrayList<E>();
        ArrayList<E> arrayListRight = new ArrayList<E>();
        // копируем левую часть от начала до середины


        for (int i = 0; i < arrayList.size() / 2; i++) {
            arrayListLeft.add(arrayList.get(i));
        }

        for (int i = arrayList.size() / 2; i < arrayList.size(); i++) {
            arrayListRight.add(arrayList.get(i));
        }

        arrayListLeft = sortArray(arrayListLeft, order); // левая часть возврат из рекурсии строкой return arrayA;
        arrayListRight = sortArray(arrayListRight, order); // правая часть возврат из рекурсии строкой return arrayA;

        return mergeArray(arrayListLeft, arrayListRight, order);
    }

    public <E extends Comparable<E>> ArrayList<E> mergeArray(ArrayList<E> arrayLeft, ArrayList<E> arrayRight
            , Boolean order) {

        ArrayList<E> arrayC = new ArrayList<E>();
        int positionLeftArray = 0, positionRightArray = 0;

        for (int i = 0; i < arrayLeft.size() + arrayRight.size(); i++) {
            if (positionLeftArray == arrayLeft.size()) {
                arrayC.add(arrayRight.get(positionRightArray));
                positionRightArray++;
            } else if (positionRightArray == arrayRight.size()) {
                arrayC.add(arrayLeft.get(positionLeftArray));
                positionLeftArray++;
            } else if ((arrayRight.get(positionRightArray).compareTo(arrayLeft.get(positionLeftArray)) < 0 && !order) ||
                    (arrayRight.get(positionRightArray).compareTo(arrayLeft.get(positionLeftArray)) > 0 && order)) {
                arrayC.add(arrayLeft.get(positionLeftArray));
                positionLeftArray++;
            } else {
                arrayC.add(arrayRight.get(positionRightArray));
                positionRightArray++;
            }
        }
        return arrayC;
    }


}