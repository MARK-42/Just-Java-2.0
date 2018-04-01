package com.projects.rtk154.justjava2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.begin);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                setContentView(R.layout.begin);
                setContentView(R.layout.activity_main);
                int a=5;
            }
        }, 3000);


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
    private int calculatePrice(){
        int unitPrice=10;
        boolean checked=CheckView();
        if(checked)
            unitPrice+=2;
        else
            unitPrice=10;
        int TotalPrice = unitPrice * quantity;
        return TotalPrice;
    }

    void orderButton(View view) {
        int TotalPrice = calculatePrice();
        String msg = name();
        displayPrice(TotalPrice);
        displayMsg(msg);
    }
        void SendMail(View view) {
            int TotalPrice = calculatePrice();
            String msg = name();
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            String a = "ritikgupta15@ymail.com";
            intent.putExtra(Intent.EXTRA_EMAIL, a);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Custome Bill");
            String msg1 = "Thank You for Ordering " + msg + "\n..Vaelaar Dohairis..." + "Cost= " + TotalPrice;
            intent.putExtra(Intent.EXTRA_TEXT, msg1);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
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
            createtoast("Coffee cannot be less than 0");
        }
    }
    private void createtoast(String text)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
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
        TextView tv = (TextView) findViewById(R.id.messageTv);
        tv.setText("..Vaelar Moghulis..");
        EditText ev = (findViewById(R.id.NameEv));
        ev.setText("");
        displayPrice(0);
        quantity=0;
        displayQuantity(0);
    }
}
