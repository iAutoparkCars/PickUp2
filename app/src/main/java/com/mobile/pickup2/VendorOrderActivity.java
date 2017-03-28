package com.mobile.pickup2;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
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
        populateOrderList();
        createOrderObject();


    }

    //creating the ListView of CustomerOrder objects using array Adapter
    private void createOrderObject()
    {
        ArrayAdapter<CustomerOrder> adapter1 = new MyListAdapter();          //create array adaptor
        ListView orderList = (ListView) findViewById(R.id.order_list_view);  //create the list object
        orderList.setAdapter(adapter1);                                      //use List object to set
    }


    //for now, ther are just arbitrary values to place into Order List
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

    //subclass MyListAdapter
    private class MyListAdapter extends ArrayAdapter<CustomerOrder>
    {
       public MyListAdapter()
       {
           super(VendorOrderActivity.this, R.layout.order_object_view, orders);
       }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View itemView = convertView;
            if (itemView==null)     //if no view, make one using order_object_view
            {
                //if no order View, then "inflate" layout; create layout for us
                //working on the parent view
                //do not attach to root -- false
                itemView = getLayoutInflater().inflate(R.layout.order_object_view, parent, false);
            }
            //get CustomerOrder from ArrayLIst according to position
            CustomerOrder currentOrder = orders.get(position);
            ImageButton doneButton = (ImageButton) itemView.findViewById(R.id.done_button);

            //load current Ordder object's image into ImageButton!
            doneButton.setImageResource(currentOrder.getimgButtonID());


            return itemView;
        }
        //if position=0, first object in list(order1). if pos=1, then 2nd object (order2), etc...
    }

}
