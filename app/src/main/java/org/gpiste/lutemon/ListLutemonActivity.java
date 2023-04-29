package org.gpiste.lutemon;

import android.os.Bundle;

import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class ListLutemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlutemon_activity);

        ListView lutemonListV = findViewById(R.id.lutemonListView);
        // call lutemon listadapter to make Lutemons appear in activity
        LutemonListAdapter adapter  = new LutemonListAdapter(this, Lutemon.getLutemonList());
        lutemonListV.setAdapter(adapter);



    }
}
