import java.util.ArrayList;

public class InputParameter {
    private Boolean sortAscending = true;
    private Boolean typeString;
    private String nameOutFile;
    private ArrayList<String> arrayInFile;

    public InputParameter(String[] argument) {
        arrayInFile = new ArrayList<>();
        for (String parameter : argument) {
            if (parameter.equalsIgnoreCase("-a")) {
                this.sortAscending = true;
            } else if (parameter.equalsIgnoreCase("-d")) {
                this.sortAscending = false;
            } else if (parameter.equalsIgnoreCase("-i")) {
                this.typeString = false;
            } else if (parameter.equalsIgnoreCase("-s")) {
                this.typeString = true;
            } else if (parameter.toLowerCase().contains(".txt") && nameOutFile == null) {
                this.nameOutFile = parameter;
            } else if (parameter.toLowerCase().contains(".txt")) {
                this.arrayInFile.add(parameter);
            } else {
                System.out.println("Ошибка");
            }
        }
    }

    public Boolean getSortAscending() {
        return sortAscending;
    }

    public Boolean getTypeString() {
        return typeString;
    }

    public String getNameOutFile() {
        return nameOutFile;
    }

    public ArrayList<String> getArrayInFile() {
        return arrayInFile;
    }

    @Override
    public String toString() {
        return "InputParameter{" +
                "sortAscending=" + sortAscending +
                ", typeString=" + typeString +
                ", nameOutFile='" + nameOutFile + '\'' +
                ", arrayInFile=" + arrayInFile +
                '}';
    }
}
