package logic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Command implements Serializable, Comparable<Command> {

    LocalDate theDateOfCommand;
    List<Product> productList;

    public Command (){
        theDateOfCommand = LocalDate.now();
        productList = new ArrayList<>();
    }

    public Command(LocalDate theDateOfCommand, List<Product> productList) {
        this.theDateOfCommand = theDateOfCommand;
        this.productList = productList;
    }

    public void addProductToProductList(Product product){
        productList.add(product);
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public LocalDate getTheDateOfCommand() {
        return theDateOfCommand;
    }

    public void setTheDateOfCommand(LocalDate theDateOfCommand) {
        this.theDateOfCommand = theDateOfCommand;
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "Command{" +
                "theDateOfCommand=" + theDateOfCommand +
                ", productList=" + productList +
                '}';
    }

    @Override
    public int compareTo(Command o) {
        return 0;
    }

    public static Comparator<Command> SizeCommandComparator = new Comparator<Command>() {
        @Override
        public int compare(Command o1, Command o2) {
            return (int) (o1.getProductList().size() - o2.getProductList().size());
        }
    };
}
