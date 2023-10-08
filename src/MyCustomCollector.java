/*
  @author   george
  @project   customcollector
  @class  MyCustomCollector
  @version  1.0.0 
  @since 08.10.23 - 11.02
*/

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class MyCustomCollector
        implements Collector<FoodItem, Map<Diapazone, List<FoodItem>>, Map<Diapazone, List<FoodItem>>> {

    Diapazone light = new Diapazone("Light", 0, 100);
    Diapazone medium = new Diapazone("Medium", 100, 200);
    Diapazone hard = new Diapazone("Hard", 200, 500);



    @Override
    public Supplier<Map<Diapazone, List<FoodItem>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<Diapazone, List<FoodItem>>, FoodItem> accumulator() {

        return (map, item) -> {
            Diapazone diapazone = this.getDiapazone(item.getPrice());
            if (map.containsKey(diapazone)) {
                List<FoodItem> value = map.get(diapazone);
                value.add(item);
                map.put(diapazone, value);
            } else {
                List<FoodItem> list = new ArrayList<>();
                list.add(item);
                map.put(diapazone, list);
            }
        };
    }

    @Override
    public BinaryOperator<Map<Diapazone, List<FoodItem>>> combiner() {
        return (map1, map2) -> {
            map2.forEach( (k, v) -> map1.merge(k, v, (v1, v2)
                    -> Stream.of(v1,v2).flatMap(l ->l.stream()).toList()));
            return map1;
        };
    }

    @Override
    public Function<Map<Diapazone, List<FoodItem>>, Map<Diapazone, List<FoodItem>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH);
    }

    private Diapazone getDiapazone(int price) {
        if (price >200) {
            return hard;
        }
        if (price < 100) {
            return light;
        } else {
            return medium;
        }
    }
}
