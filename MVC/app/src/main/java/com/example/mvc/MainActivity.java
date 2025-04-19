package com.example.mvc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvc.allproducts.controller.AllProductActivity;
import com.example.mvc.favproducts.view.FavActivity;

public class MainActivity extends AppCompatActivity {

    Button Allbtn;
    Button Favbtn;
    Button Exit;
    TextView Apptitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        Apptitle=findViewById(R.id.titletxt);
        Allbtn=findViewById(R.id.allbtn);
        Favbtn=findViewById(R.id.addfavbtn);
        Exit=findViewById(R.id.Exitbtn);

        Allbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AllProductActivity.class);
                startActivity(intent);


        }});


        Favbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavActivity.class);
                startActivity(intent);

            }
        });


        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
