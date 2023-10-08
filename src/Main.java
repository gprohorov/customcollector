
/*
  @author   george
  @project   Default (Template) Project
  @class  ${NAME}
  @version  1.0.0 
  @since 08.10.23 - 10.39
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<FoodItem> items = List.of(
               new FoodItem("Bread", 22),
               new FoodItem("Salam", 150),
               new FoodItem("Cheese", 220),
               new FoodItem("Milk", 36),
               new FoodItem("Candies", 280),
               new FoodItem("Butter", 70)
        );
       items.stream().collect(new MyCustomCollector())
               .entrySet()
               .forEach(System.out::println);

    }
}
