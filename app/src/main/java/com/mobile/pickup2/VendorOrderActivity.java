package com.mobile.pickup2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendorOrderActivity extends AppCompatActivity
{

    private List<CustomerOrder> orders = new ArrayList<CustomerOrder>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_order);
        //referencing activity_vendor_order.xml; write code here



    }

    //creating the ListView of CustomerOrder objects using array Adapter
    private void createOrderObject()
    {
        ArrayAdapter<CustomerOrder> adapter1 = new MyListAdapter();
        ListView list1 = (ListView) findViewById(R.id.order_list_view);
        list1.setAdapter(adapter1);
        
    }


    //arbitrary values to place into Order List
    private void populateOrderList()
    {
        HashMap<String, Integer> sotired = new HashMap<String,Integer>();
        sotired.put("ham", 3);
        sotired.put("dirt", 4);
        sotired.put("lol", 1);
        CustomerOrder order1 = new CustomerOrder("bob1",R.drawable.mouse,false,sotired);
        orders.add(order1);

        HashMap<String, Integer> imsick = new HashMap<String,Integer>();
        imsick.put("ham", 3);
        imsick.put("dirt", 2);
        imsick.put("elephant", 9);
        CustomerOrder order2 = new CustomerOrder("bob2",R.drawable.mouse,false,imsick);
        orders.add(order2);
    }


}
