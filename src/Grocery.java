import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Grocery {
    private ArrayList<String> groceryList;
    private final Scanner scanner = new Scanner(System.in);

    public Grocery() {
        groceryList = new ArrayList<>();
    }

    public void addItems() {

        String[] items = formatUserInput();
        for (String element : items) {
            if (!groceryList.contains(element)) {
                groceryList.add(element.strip());
            } else {
                System.out.printf("Item %s was not added because it is already on the list", element);
            }
        }
        printSortedList();
    }

    public void removeItems() {
        String[] items = formatUserInput();
        for (String element : items) {
            if (groceryList.contains(element)) {
                groceryList.remove(element);
            } else {
                System.out.println("Item was not found in the list");
            }
        }
        printSortedList();
    }

    public void printSortedList() {
        groceryList.sort(Comparator.naturalOrder());
        System.out.println("This is the sorted list: " + this.groceryList);
    }

    public String[] formatUserInput() {
        String userInputData;
        boolean invalidInput = false;
        do {
            System.out.println("Enter items to be added/removed separated by comma");
            userInputData = scanner.nextLine();
            invalidInput = userInputData.contains(".") ? true : false;
        } while (invalidInput);

        return userInputData.split(",");
    }

    public int getListSize() {
        return groceryList.size();
    }

}
