package ec.klecet.com.klecetbustrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectBus extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, allbus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_bus);
        b1 = (Button) findViewById(R.id.btn_b1);
        b2 = (Button) findViewById(R.id.btn_b2);
        b3 = (Button) findViewById(R.id.btn_b3);
        b4 = (Button) findViewById(R.id.btn_b4);
        b5 = (Button) findViewById(R.id.btn_b5);
        b6 = (Button) findViewById(R.id.btn_b6);
        allbus = (Button) findViewById(R.id.btn_allbuses);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), B1MapsActivity.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), B2MapsActivity.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), B3MapsActivity.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), B4MapsActivity.class);
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), B5MapsActivity.class);
                startActivity(i);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), B6MapsActivity.class);
                startActivity(i);
            }
        });

        allbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AllBusMapsActivity.class);
                startActivity(i);
            }
        });
    }
}
