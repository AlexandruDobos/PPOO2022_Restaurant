package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Place implements Serializable {

    int numberPlace;
    List<Product> productList = new ArrayList<>();
    List<Command> commands;


    public Place(int numberPlace) {
        this.numberPlace = numberPlace;
        this.productList = new ArrayList<>();
        this.commands = new ArrayList<>();
    }

    public int getNumberPlace() {
        return numberPlace;
    }

    public void AddProduct(Product product) {
        productList.add(product);
    }

    public void RemoveProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).equals(product)) {
                productList.remove(product);
                break;
            }
        }
    }

    public void setNumberPlace(int numberPlace) {
        this.numberPlace = numberPlace;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public void addCommand(Command command){
        this.commands.add(command);
    }



    @Override
    public String toString() {
        return "Place{" +
                "numberPlace=" + numberPlace +
                ", productList=" + productList +
                ", commands=" + commands +
                '}';
    }
}
