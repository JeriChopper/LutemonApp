// Jericho Koskinen 607024
// Olen tehnyt tämän harjoitustyön täysin itse.
// Lähteitä käytetty:
// https://abhiandroid.com/ui/listview
// https://www.youtube.com/watch?v=fwSJ1OkK304
//https://stackoverflow.com/questions/66898154/how-exactly-do-adapters-for-arraylists-in-android-studio-work
//https://www.geeksforgeeks.org/how-to-center-a-button-in-a-linear-layout-in-android/


package org.gpiste.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    // Main menu buttons and their ClickListeners to open new activities..
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Lutemon-app");
        Button addLutemon = findViewById(R.id.AddLutemonBtn);
        addLutemon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddLutemonActivity.class);
                startActivity(intent);
            }
        });
        Button listLutemon = findViewById(R.id.ListLutemonBtn);
        listLutemon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListLutemonActivity.class);
                startActivity(intent);
            }
        });
        Button trainLutemon = findViewById(R.id.TrainLutemonBtn);
        trainLutemon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TrainLutemonActivity.class);
                startActivity(intent);
            }
        });
        Button battleLutemon = findViewById(R.id.BattleLutemonBtn);
        battleLutemon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BattleLutemonActivity.class);
                startActivity(intent);
            }
        });

    }
}