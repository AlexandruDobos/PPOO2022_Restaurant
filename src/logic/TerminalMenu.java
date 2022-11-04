package logic;

import java.io.Serializable;

public class TerminalMenu implements Serializable {

    public void ShowHomeMenu(Restaurant restaurant) {
        System.out.println("----- Please select the place! For close application, write exit. For statistics, write stats -----");

        for (int i = 0; i < restaurant.getPlaceList().size(); i++)
            System.out.print(i + 1 + ". ");
        System.out.println();
        System.out.print("Your response: ");
    }

    public void ShowOptionsForAPlace() {
        System.out.println("----- Please select the option you want!-----");
        System.out.println("1. See products | 2. Add products | 3. Remove product | 4. Generate payment note | 5. Back");
        System.out.print("Your response: ");
    }

    public void ShowBackButton() {
        System.out.println("For back, please write 1.");
        System.out.print("Your response: ");
    }

    public void ShowProductsList(Restaurant restaurant) {
        int i;
        for (i = 0; i < restaurant.GetMenuList().size(); i++) {
            System.out.println(i + 1 + ". " + restaurant.GetMenuList().get(i).getProductName());
        }
        System.out.println(i + 1 + ". Back");
    }

    public void ShowProductsListForRemove(Restaurant restaurant, int placeNumber) {
        int i;
        for (i = 0; i < restaurant.getPlaceList().get(placeNumber).getProductList().size(); i++) {
            System.out.println(i + 1 + ". " + restaurant.getPlaceList().get(placeNumber).getProductList().get(i).getProductName());
        }
        System.out.println(i + 1 + ". Back");
    }

    public void ShowPaymentNote(Restaurant restaurant, int placeNumber) {
        System.out.println("- - - - - PAYMENT NOTE - - - - -");
        System.out.println("You have the following products in place (" + (placeNumber + 1) + "):");
        int i;
        for (i = 0; i < restaurant.getPlaceList().get(placeNumber).getProductList().size(); i++) {
            System.out.println(restaurant.getPlaceList().get(placeNumber).getProductList().get(i).getProductName());
        }
        System.out.println("- - - - - - - - - - - - - - - - -");
    }

    public void ShowListOfPlacesForStats(Restaurant restaurant) {
        int i = 0;
        for (i = 0; i < restaurant.getPlaceList().size(); i++)
            System.out.print(i + 1 + ". ");
        System.out.println();
        System.out.println("For back write " + (i + 1));
        System.out.println();
    }


}
