package model;

import exception.OrderSystemException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DishDaoTest {

    @Test
    public void add() throws OrderSystemException {
        Dish dish = new Dish();
        dish.setName("西红柿炒鸡蛋");
        dish.setPrice(20);
        DishDao dishDao = new DishDao();
        dishDao.add(dish);
    }

    @Test
    public void delete() throws OrderSystemException {
        DishDao dishDao = new DishDao();
        dishDao.delete(2);
    }

    @Test
    public void selectAll() {
        List<Dish> list = new ArrayList<>();
        DishDao dishDao = new DishDao();
        list = dishDao.selectAll();
        System.out.println(list.size());

    }

    @Test
    public void selectById() throws OrderSystemException {
        DishDao dishDao = new DishDao();
        Dish dish = new Dish();
        dish = dishDao.selectById(5);
        System.out.println(dish);
    }
}