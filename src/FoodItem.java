/*
  @author   george
  @project   customcollector
  @class  FoodItem
  @version  1.0.0 
  @since 08.10.23 - 10.41
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class FoodItem {
    private String name;
    private int price;

    public FoodItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
