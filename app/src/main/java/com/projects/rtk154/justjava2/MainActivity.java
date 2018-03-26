package com.projects.rtk154.justjava2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int quantity = 0,unitPrice=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void displayQuantity(int quantity) {
        TextView tv = (TextView) findViewById(R.id.quantityTv);
        tv.setText("" + quantity);
    }
        private boolean CheckView()
        {
            CheckBox chr=(CheckBox)findViewById(R.id.checkView);
            boolean checked= chr.isChecked();
            return checked;

    }
    String name() {
        EditText ev = (findViewById(R.id.NameEv));
        String msg = ev.getText().toString();
        return msg;
    }

    void orderButton(View view) {
        boolean checked=CheckView();
        if(checked)
            unitPrice=13;
        else
            unitPrice=10;
        int TotalPrice = unitPrice * quantity;
        String msg = name();
        displayPrice(TotalPrice);
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
            quantity=0;
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
        CheckBox chr=(CheckBox)findViewById(R.id.checkView);
        chr.setChecked(false);
        unitPrice=10;
        TextView tv = (TextView) findViewById(R.id.messageTv);
        tv.setText("..Vaelar Moghulis..");
        EditText ev = (findViewById(R.id.NameEv));
        ev.setText("");
        displayPrice(0);
        quantity=0;
        displayQuantity(0);
    }
}
