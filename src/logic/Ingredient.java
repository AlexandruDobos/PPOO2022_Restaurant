package logic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Ingredient implements Serializable {

    private String ingredientName;
    private LocalDate ingredientExpirationDate;

    public Ingredient(String ingredientName, LocalDate ingredientExpirationDate) {
        this.ingredientName = ingredientName;
        this.ingredientExpirationDate = ingredientExpirationDate;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientName='" + ingredientName + '\'' +
                ", ingredientExpirationDate=" + ingredientExpirationDate +
                '}';
    }
}
