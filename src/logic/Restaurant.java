package logic;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Restaurant implements Serializable {

    String name;

    private List<Product> menuList = new ArrayList<>();
    private List<Place> placeList = new ArrayList<>();

    public Restaurant() {
    }

    public List<Product> GetMenuList() {
        return menuList;
    }

    public void WriteMenu() throws Exception {
        Product product1 = new Product("Omelette", 22.5d, new ArrayList<>() {{
            add(new Ingredient("Eggs", LocalDate.of(2023, 10, 10)));
            add(new Ingredient("Salt", LocalDate.of(2024, 10, 22)));
            add(new Ingredient("Cheese", LocalDate.of(2024, 10, 22)));
        }}, 150d);
        Product product2 = new Product("Pizza", 38.5d, new ArrayList<>() {{
            add(new Ingredient("Mozzarella", LocalDate.of(2023, 10, 10)));
            add(new Ingredient("Tomatoes sauce", LocalDate.of(2024, 10, 22)));
        }}, 480d);
        Product product3 = new Product("Soup", 30d, new ArrayList<>() {{
            add(new Ingredient("Vegetables", LocalDate.of(2022, 10, 10)));
            add(new Ingredient("Chicken", LocalDate.of(2021, 10, 22)));
            add(new Ingredient("Vermicelli", LocalDate.of(2021, 12, 25)));
        }}, 480d);
        Product product4 = new Product("Pancakes", 22d, new ArrayList<>() {{
            add(new Ingredient("Flour", LocalDate.of(2022, 10, 10)));
            add(new Ingredient("Milk", LocalDate.of(2021, 10, 22)));
            add(new Ingredient("Eggs", LocalDate.of(2021, 12, 25)));
            add(new Ingredient("Sugar", LocalDate.of(2021, 12, 25)));
        }}, 480d);
        Product product5 = new Product("Lemonade", 30d, new ArrayList<>() {{
            add(new Ingredient("Water", LocalDate.of(2022, 10, 10)));
            add(new Ingredient("Lemon", LocalDate.of(2021, 10, 22)));
            add(new Ingredient("Sugar", LocalDate.of(2021, 12, 25)));
        }}, 480d);


        List<Product> menuList = new ArrayList<>();
        menuList.add(product1);
        menuList.add(product2);
        menuList.add(product3);
        menuList.add(product4);
        menuList.add(product5);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("productsData", false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(menuList);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteNewMenu(List<Product> menuList) throws Exception {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("productsData", false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(menuList);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadMenu() throws Exception {

        List<Product> productList = new ArrayList<>();

        //System.out.println("productList2 here is: " + productList2);

        try {
            FileInputStream fileInputStream = new FileInputStream("productsData");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            productList = (ArrayList) objectInputStream.readObject();
            menuList = productList;
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

/*        for (Product product : productList2) {
            System.out.println(product.getProductName());
        }

        System.out.println("----- What do you want to eat? -----");*/

    }

    public void AddPlaceToRestaurant(Place place) {
        placeList.add(place);
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void WritePlaces() {

        Place place1 = new Place(1);
        Place place2 = new Place(2);
        Place place3 = new Place(3);
        Place place4 = new Place(4);
        Place place5 = new Place(5);

        place1.setProductList(new ArrayList<>() {{
            add(new Product("Omelette", 22.5d, new ArrayList<>() {{
                add(new Ingredient("Eggs", LocalDate.of(2023, 10, 10)));
                add(new Ingredient("Salt", LocalDate.of(2024, 10, 22)));
                add(new Ingredient("Cheese", LocalDate.of(2024, 10, 22)));
            }}, 150d));
            add(new Product("Pizza", 38.5d, new ArrayList<>() {{
                add(new Ingredient("Mozzarella", LocalDate.of(2023, 10, 10)));
                add(new Ingredient("Tomatoes sauce", LocalDate.of(2024, 10, 22)));
            }}, 480d));
        }});
        place2.setProductList(new ArrayList<>() {{
            add(new Product("Soup", 30d, new ArrayList<>() {{
                add(new Ingredient("Vegetables", LocalDate.of(2022, 10, 10)));
                add(new Ingredient("Chicken", LocalDate.of(2021, 10, 22)));
                add(new Ingredient("Vermicelli", LocalDate.of(2021, 12, 25)));
            }}, 480d));
            add(new Product("Pancakes", 22d, new ArrayList<>() {{
                add(new Ingredient("Flour", LocalDate.of(2022, 10, 10)));
                add(new Ingredient("Milk", LocalDate.of(2021, 10, 22)));
                add(new Ingredient("Eggs", LocalDate.of(2021, 12, 25)));
                add(new Ingredient("Sugar", LocalDate.of(2021, 12, 25)));
            }}, 480d));
        }});
        place1.setCommands(new ArrayList<>() {{
            add(new Command(LocalDate.now(), new ArrayList<>() {{
                add(new Product("Soup", 30d, new ArrayList<>() {{
                    add(new Ingredient("Vegetables", LocalDate.of(2022, 10, 10)));
                    add(new Ingredient("Chicken", LocalDate.of(2021, 10, 22)));
                    add(new Ingredient("Vermicelli", LocalDate.of(2021, 12, 25)));
                }}, 480d));
                add(new Product("Pancakes", 22d, new ArrayList<>() {{
                    add(new Ingredient("Flour", LocalDate.of(2022, 10, 10)));
                    add(new Ingredient("Milk", LocalDate.of(2021, 10, 22)));
                    add(new Ingredient("Eggs", LocalDate.of(2021, 12, 25)));
                    add(new Ingredient("Sugar", LocalDate.of(2021, 12, 25)));
                }}, 480d));
            }}));
        }});
        place2.setCommands(new ArrayList<>() {{
            add(new Command(LocalDate.now(), new ArrayList<>() {{
                add(new Product("Omelette", 22.5d, new ArrayList<>() {{
                    add(new Ingredient("Eggs", LocalDate.of(2023, 10, 10)));
                    add(new Ingredient("Salt", LocalDate.of(2024, 10, 22)));
                    add(new Ingredient("Cheese", LocalDate.of(2024, 10, 22)));
                }}, 150d));
                add(new Product("Pizza", 38.5d, new ArrayList<>() {{
                    add(new Ingredient("Mozzarella", LocalDate.of(2023, 10, 10)));
                    add(new Ingredient("Tomatoes sauce", LocalDate.of(2024, 10, 22)));
                }}, 480d));
            }}));
        }});

        List<Place> places = new ArrayList<>();
        places.add(place1);
        places.add(place2);
        places.add(place3);
        places.add(place4);
        places.add(place5);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("restaurantData", false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(places);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteNewPlaces(List<Place> placeList) throws Exception {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("restaurantData", false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(placeList);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadPlaces(){
        List<Place> places = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream("restaurantData");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            places = (ArrayList) objectInputStream.readObject();
            placeList = places;

            objectInputStream.close();
            fileInputStream.close();
        }catch (IOException e){
            e.printStackTrace();
            return;
        }catch (ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", placeList=" + placeList +
                '}';
    }
}
