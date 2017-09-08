package cn.zsza.java8.carDemo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zs on 2017/6/5.
 * 16:50
 */
public class IteratingCar {

    public static List<Car> carList(){
        return Arrays.asList(
                new Car("Benz","C200",2011),
                new Car("Benz","C180",1999),
                new Car("BMW","X3",2013),
                new Car("Audi","A6L",2015)
        );
    }

    /**
     * 找出2000年出厂的汽车,对车的出厂年份进行升序排序
     * @param carList
     * @return
     */
    public static List<String> getModelsAfter2000UsingFor(List<Car> carList){
        List<Car> carsSortedByYear = new ArrayList<>();

        for (Car car : carList){
            if (car.getYear() > 2000)
                carsSortedByYear.add(car);
        }

        Collections.sort(carsSortedByYear, (o1, o2) -> new Integer(o1.getYear()).compareTo(o2.getYear()));

        List<String> models = new ArrayList<>();

        for (Car car : carsSortedByYear){
            models.add(car.getModel());
        }
        return models;
    }

    public static List<String> getModelsAfter2000UsingPipeline(List<Car> carList){
        /**
         * reversed(): 降序
         */
        return carList.stream()
                .filter(car -> car.getYear() > 2000)
                .sorted(Comparator.comparing(Car::getYear).reversed())
                .map(Car::getModel)
                .collect(Collectors.toList());
    }



    public static void main(String[] args) {
        List<Car> carList = carList();

        List<String> result = getModelsAfter2000UsingFor(carList);
        List<String> result2 = getModelsAfter2000UsingPipeline(carList);



        System.out.println(result);
        System.out.println(result2);


        List<String> list = carList.stream()
                .map(Car::getMake)
                .collect(Collectors.toList());

        System.out.println("list:" + list);
    }
}
