package com.projects.rtk154.justjava2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void displayQuantity(int quantity) {
        TextView tv = (TextView) findViewById(R.id.quantityTv);
        tv.setText("" + quantity);
    }

    String name() {
        EditText ev = (findViewById(R.id.NameEv));
        String msg = ev.getText().toString();
        return msg;
    }

    void orderButton(View view) {
        int price = 10 * quantity;
        String msg = name();
        displayPrice(price);
        displayMsg(msg);
    }

    void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    void decrement(View view) {
        quantity--;
        if (quantity > 0)
            displayQuantity(quantity);
        else {
            displayQuantity(0);
            //add toast
        }
    }

    void displayPrice(int price) {
        TextView tv = (TextView) findViewById(R.id.amtTv);
        tv.setText("Rs. " + price);
    }

    void displayMsg(String msg) {
        TextView tv = (TextView) findViewById(R.id.messageTv);
        tv.setText("Thank You for Ordering "+ msg+"\n..Vaelaar Dohairis...");
    }

    void clear(View view)
    {
        TextView tv = (TextView) findViewById(R.id.messageTv);
        tv.setText("..Vaelar Moghulis..");
        displayPrice(0);
        displayQuantity(0);
    }
}
