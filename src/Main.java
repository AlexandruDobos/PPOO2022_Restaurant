import exceptions.CustomException;
import logic.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        TerminalMenu terminalMenu = new TerminalMenu();
        Restaurant restaurant = new Restaurant();
        //restaurant.WriteMenu();
        restaurant.ReadMenu();
        //restaurant.WritePlaces();
        restaurant.ReadPlaces();

        Scanner scan = new Scanner(System.in);
        boolean condition = true;
        String response = "";
        int placeNumber = -1;
        int productResponse = -1;
        String whereAmI = "principalPage";

        while (condition) {
            switch (whereAmI) {
                case "principalPage":
                    terminalMenu.ShowHomeMenu(restaurant);
                    response = scan.nextLine();
                    if (response.toLowerCase().equals("exit")) {
                        restaurant.WriteNewPlaces(restaurant.getPlaceList());
                        System.exit(0);
                    } else if (response.toLowerCase().equals("stats")) {
                        whereAmI = "stats";
                    } else {
                        try {
                            if (Double.parseDouble(response) >= 1 && Double.parseDouble(response) <= restaurant.getPlaceList().size()) {
                                whereAmI = "placesPage";
                                placeNumber = (int) Double.parseDouble(response);
                            } else {
                                throw new CustomException("Wrong answer! Please try again!");
                            }
                        } catch (CustomException exception) {

                            System.out.println(exception.getMessage());
                        }
                    }
                    break;
                case "placesPage":
                    terminalMenu.ShowOptionsForAPlace();
                    response = scan.nextLine();

                    try {
                        if (Double.parseDouble(response) >= 1 && Double.parseDouble(response) <= 5) {
                            //System.out.println("e ok");
                            if (Double.parseDouble(response) >= 1 && Double.parseDouble(response) <= 3) {
                                whereAmI = "listOfProducts" + (int) Double.parseDouble(response);
                            } else if (Double.parseDouble(response) == 4) {
                                whereAmI = "generatePaymentNote";
                            } else {
                                whereAmI = "principalPage";
                            }
                        } else {
                            throw new CustomException("Wrong answer! Please try again!");
                        }
                    } catch (CustomException exception) {

                        System.out.println(exception.getMessage());
                        System.out.print("Your answer: ");
                    }
                    break;
                case "listOfProducts1":
                    System.out.println("For place with number " + placeNumber + " you have the following products:");
                    Place place = restaurant.getPlaceList().get(placeNumber - 1);
                    for (int i = 0; i < place.getProductList().size(); i++) {
                        System.out.println("Name: " + place.getProductList().get(i).getProductName() + " | Price: " + place.getProductList().get(i).getProductPrice());
                    }
                    terminalMenu.ShowBackButton();
                    response = scan.nextLine();
                    try {
                        if ((int) Double.parseDouble(response) == 1) {
                            whereAmI = "placesPage";
                        } else {
                            throw new CustomException("Wrong answer! Please try again!");
                        }
                    } catch (CustomException exception) {

                        System.out.println(exception.getMessage());
                    }
                    break;
                case "listOfProducts2":
                    System.out.println("You want to add a new product. Select which one you want!");
                    terminalMenu.ShowProductsList(restaurant);
                    System.out.print("Your answer: ");
                    response = scan.nextLine();
                    try {
                        if ((int) Double.parseDouble(response) >= 1 && (int) Double.parseDouble(response) <= restaurant.GetMenuList().size() + 1) {
                            if ((int) Double.parseDouble(response) != restaurant.GetMenuList().size() + 1) {
                                productResponse = (int) Double.parseDouble(response);

                                Product userProduct = restaurant.GetMenuList().get(productResponse - 1);
                                restaurant.getPlaceList().get(placeNumber - 1).AddProduct(userProduct);
                            }
                            whereAmI = "placesPage";


                        } else {
                            throw new CustomException("Wrong answer! Please try again!");
                        }
                    } catch (CustomException exception) {

                        System.out.println(exception.getMessage());
                    }
                    break;
                case "listOfProducts3":
                    System.out.println("You want to remove a product. Select which one you want!");
                    terminalMenu.ShowProductsListForRemove(restaurant, placeNumber - 1);
                    System.out.print("Your answer: ");
                    response = scan.nextLine();
                    try {
                        if ((int) Double.parseDouble(response) >= 1 && (int) Double.parseDouble(response) <= restaurant.GetMenuList().size() + 1) {
                            if ((int) Double.parseDouble(response) != restaurant.getPlaceList().get(placeNumber-1).getProductList().size() + 1) {
                                productResponse = (int) Double.parseDouble(response);

                                Product userProduct = restaurant.getPlaceList().get(placeNumber - 1).getProductList().get(productResponse - 1);
                                restaurant.getPlaceList().get(placeNumber - 1).RemoveProduct(userProduct);
                            }
                            whereAmI = "placesPage";
                        } else {
                            throw new CustomException("Wrong answer! Please try again!");
                        }
                    } catch (CustomException exception) {

                        System.out.println(exception.getMessage());
                    }
                    break;
                case "generatePaymentNote":
                    System.out.println("You want to generate payment note. Type 1 to confirm or 2 to go back!");
                    System.out.print("Your answer: ");
                    response = scan.nextLine();
                    try {
                        if ((int) Double.parseDouble(response) >= 1 && (int) Double.parseDouble(response) <= 2) {
                            if ((int) Double.parseDouble(response) == 1) {
                                Command command = new Command();
                                command.setTheDateOfCommand(LocalDate.now());
                                command.setProductList(restaurant.getPlaceList().get(placeNumber - 1).getProductList());

                                System.out.println("- - - - - Payment note generated! - - - - -");
                                System.out.println("Command had contained the following products:");
                                double total = 0;
                                for (int i = 0; i < restaurant.getPlaceList().get(placeNumber - 1).getProductList().size(); i++) {
                                    System.out.println(i + 1 + ". " + restaurant.getPlaceList().get(placeNumber - 1).getProductList().get(i).getProductName() + " | Price: " + restaurant.getPlaceList().get(placeNumber - 1).getProductList().get(i).getProductPrice());
                                    total += restaurant.getPlaceList().get(placeNumber - 1).getProductList().get(i).getProductPrice();
                                }
                                System.out.println("Total price: " + total);
                                System.out.println("- - - - - - - - - - - - - - - - - - - - - -");

                                restaurant.getPlaceList().get(placeNumber - 1).addCommand(command);
                                restaurant.getPlaceList().get(placeNumber - 1).setProductList(new ArrayList<>());
                                whereAmI = "placesPage";
                            } else {
                                whereAmI = "placesPage";
                            }
                        } else {
                            throw new CustomException("Wrong answer! Please try again!");
                        }
                    } catch (CustomException exception) {

                        System.out.println(exception.getMessage());
                    }
                    break;
                case "stats":
                    System.out.println("You want to see the stats for a place. Select which place you want.");
                    terminalMenu.ShowListOfPlacesForStats(restaurant);
                    System.out.print("Your answer: ");
                    response = scan.nextLine();
                    try {
                        if ((int) Double.parseDouble(response) >= 1 && (int) Double.parseDouble(response) <= restaurant.getPlaceList().size() + 1) {
                            if ((int) Double.parseDouble(response) >= 1 && (int) Double.parseDouble(response) <= restaurant.getPlaceList().size()) {
                                placeNumber = (int) Double.parseDouble(response);

                                Statistics statistics = new Statistics();
                                statistics.ShowAllCommands(restaurant.getPlaceList().get(placeNumber - 1));
                                statistics.ShowCommandsInSizeOrder(restaurant.getPlaceList().get(placeNumber - 1));
                                statistics.ShowBestSellingProduct(restaurant, restaurant.getPlaceList().get(placeNumber - 1));
                                statistics.ShowPricesAchieved(restaurant.getPlaceList().get(placeNumber - 1));
                                whereAmI = "principalPage";
                            } else {
                                whereAmI = "stats";
                            }
                        } else {
                            throw new CustomException("Wrong answer! Please try again!");
                        }
                    } catch (CustomException exception) {

                        System.out.println(exception.getMessage());
                    }

                    break;
            }
        }
    }


}
