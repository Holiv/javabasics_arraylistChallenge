import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int userSelection = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(System.in);
        Grocery groceryList = new Grocery();
        do{
            System.out.println("""
                    0 - to shutdown
                    
                    1 - to add item(s) to list (comma delimited list)
                    
                    2 - to remove any items (comma delimited list)
                    
                    Enter a number for which acton you want to do:""");
            try {
                userSelection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Option");
                System.out.println(e);
                continue;
            }

            switch (userSelection) {
                case 1 -> groceryList.addItems();
                case 2 -> {
                    if (groceryList.getListSize() == 0) {
                        System.out.println("The List is empty. Nothing to be removed");
                        break;
                    }
                    groceryList.removeItems();
                }
                default -> System.out.println("Select option 1 or 2");
            }

        } while (userSelection != 0);
    }
}
