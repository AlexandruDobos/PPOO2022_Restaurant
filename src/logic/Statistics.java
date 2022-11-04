package logic;

import java.io.Serializable;
import java.util.*;

public class Statistics implements Serializable {

    public void ShowAllCommands(Place place) {
        System.out.println("------------------------------------------");
        System.out.println("The list with all commands for this place:");

        for (int i = 0; i < place.getCommands().size(); i++) {
            System.out.println("------------- Command with number " + (i + 1) + " -------------");
            System.out.println("The date for this command is: " + place.getCommands().get(i).getTheDateOfCommand());
            for (int j = 0; j < place.getCommands().get(i).getProductList().size(); j++) {
                System.out.println("Product: " + place.getCommands().get(i).getProductList().get(j).getProductName() + " | Price: " + place.getCommands().get(i).getProductList().get(j).getProductPrice());
            }
        }
        System.out.println("------------------------------------------");
    }

    public void ShowCommandsInSizeOrder(Place place) {
        System.out.println();
        System.out.println();
        System.out.println("The list with all commands for this place in SIZE ORDER:");
        Command[] commands = new Command[place.getCommands().size()];
        for (int i = 0; i < place.getCommands().size(); i++) {
            commands[i] = place.getCommands().get(i);
        }

        Arrays.sort(commands, Command.SizeCommandComparator);
        for (int i = 0; i < commands.length; i++) {
            System.out.println("--------- Command with number (" + (i + 1) + ") ---------");
            for (int j = 0; j < commands[i].getProductList().size(); j++)
                System.out.println("Product:" + commands[i].productList.get(j).getProductName() + " | Price: " + commands[i].productList.get(j).getProductPrice());
        }

        System.out.println("------------------------------------------");

    }

    public void ShowBestSellingProduct(Restaurant restaurant, Place place) {
        System.out.println();
        System.out.println();
        int size = restaurant.GetMenuList().size();
        int[] vector = new int[size];
        Product[] products = new Product[size];
        int max = -1;
        for (int i = 0; i < size; i++) {
            vector[i] = 0;
            products[i] = restaurant.GetMenuList().get(i);
        }
        for (int i = 0; i < place.getCommands().size(); i++) {
            for (int j = 0; j < place.getCommands().get(i).getProductList().size(); j++) {
                for (int k = 0; k < size; k++) {
                    if (products[k].getProductName().equals(place.getCommands().get(i).getProductList().get(j).getProductName())) {
                        vector[k]++;
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (vector[i] > max) {
                max = vector[i];
            }
        }
        System.out.println("Best Selling Product(s):");
        for (int i = 0; i < size; i++) {
            if (vector[i] == max) {
                System.out.println(products[i].getProductName());
            }
        }

        System.out.println("------------------------------------------");

    }

    public void ShowPricesAchieved(Place place) {
        HashSet<Double> hashSet = new HashSet<>();
        for (int i = 0; i < place.getCommands().size(); i++) {
            double total = 0;
            for (int j = 0; j < place.getCommands().get(i).getProductList().size(); j++) {
                total += place.getCommands().get(i).getProductList().get(j).getProductPrice();
            }
            hashSet.add(total);
        }
        System.out.println("The list with achieved prices for this place: ");
        TreeSet<Double> treeSet = new TreeSet<>(hashSet); //for sorting
        int i = 0;
        for (Double d : treeSet) {
            System.out.println((++i) + ". " + d);
        }

        System.out.println("------------------------------------------");

    }

}
