package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Insert a city into the list
     * Check if the city exits
     *
     */
    @Test
    public void hasCityTestHappy(){
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     *
     * Check if a city exists in an empty list
     *
     */
    @Test
    public void hasCityTestEmpty(){
        list = MockCityList();
        City city = new City("Missing", "AB");
        assertFalse(list.hasCity(city));
    }


    /**
     * Add a city to the list
     * Delete the city from the list
     * Verfiy the city has been deleted from the list
     */
    @Test
    public void deleteCityTestHappyPath(){
        list = MockCityList();
        City city1 = new City("Calgary", "AB");
        list.addCity(city1);
        assertTrue(list.hasCity(city1));

        list.deleteCity(city1);
        assertFalse(list.hasCity(city1));
    }

    /**
     * Try to delete city that does not exist
     * Delete the city from the list
     * Verfiy the city has been deleted from the list
     */
    @Test
    public void deleteCityTestException(){
        list = MockCityList();
        City city1 = new City("Calgary", "AB");
        assertThrows( IllegalArgumentException.class, () -> {
            list.deleteCity(city1); });
    }

    /**
     * Count the values in empty list
     * Add a city to list
     * Verify the count is equal to 1
     */
    @Test
    public void countListTest(){
        list = MockCityList();
        City city1 = new City("Montreal", "QC");
        assertEquals(0, list.countCities());

        list.addCity(city1);
        assertEquals(1, list.countCities());
    }

}
