package com.mobile.pickup2;

/**
 * Created by Steven on 3/27/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerOrder
{
    private String customerName;
    private Boolean isPaid = false;
    private Integer imgButtonID = 0;    //this value can be hardcoded

    //each order will have a hash map with order name, and quantity
    private String foodName = null;
    private Integer quantity = 0;
    HashMap<String,Integer> foodList;

    //create each CustomerOrder object in the main List with customer's name, status, and list of items
    public CustomerOrder(String custName, Integer imgButtonID, Boolean paid, HashMap<String,Integer> itemList)
    {
        foodList = itemList;
        customerName = custName;
        this.imgButtonID = imgButtonID;
        isPaid = paid;
    }
}
