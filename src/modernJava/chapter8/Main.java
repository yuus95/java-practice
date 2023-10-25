package modernJava.chapter8;

import modernJava.domain.dish.CaloricLevel;
import modernJava.domain.dish.Dish;
import modernJava.domain.dish.DishFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static modernJava.domain.dish.CaloricLevel.*;

public class Main {
    public static void main(String[] args) {
        List<Dish> dishList = DishFactory.createDishList();

        // 람다를 이용해서 그룹핑
        Map<CaloricLevel, List<Dish>> collect = dishList.stream()
                .collect(Collectors.groupingBy(item -> {
                    if (item.getCalories() > 400) {
                        return DIET;
                    } else if (item.getCalories() < 700) {
                        return NORMAL;
                    }
                    return FAT;
                }));

        // 메소드 참조를 이용해서 그룹핑
        Map<CaloricLevel, List<Dish>> methodReference = dishList.stream()
                .collect(Collectors.groupingBy(item -> item.getCaloricLevel()));

        //



    }
}
