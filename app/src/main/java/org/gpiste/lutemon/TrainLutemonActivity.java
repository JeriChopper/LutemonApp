package org.gpiste.lutemon;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TrainLutemonActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner lutemonSpinner;
    private TextView lutemonLevelTextView;
    private Button attackLvlUpButton;
    private Button defenseLvlUpButton;
    private Button maxHealthLvlUpButton;
    private Button trainButton;
    private int id;
    private int trainCount = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainlutemon_activity);

        lutemonSpinner = findViewById(R.id.lutemonSpinner);
        lutemonLevelTextView = findViewById(R.id.lutemonLevelTextView);
        attackLvlUpButton = findViewById(R.id.attackLvlUpButton);
        defenseLvlUpButton = findViewById(R.id.defenseLvlUpButton);
        maxHealthLvlUpButton = findViewById(R.id.maxHealthLvlUpButton);
        trainButton = findViewById(R.id.trainButton);

        lutemonSpinner.setOnItemSelectedListener(this);

        //call .getLutemonList to get Lutemons
        ArrayList<Lutemon> lutemonList = Lutemon.getLutemonList();

        // put them in a new list to have just names in the spinner
        ArrayList<String> lutemonNames = new ArrayList<>();

        // get each name of created lutemon
        for (Lutemon lutemon : lutemonList) {
            lutemonNames.add(lutemon.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lutemonNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        lutemonSpinner.setAdapter(adapter);

        if (lutemonSpinner.getSelectedItem() != null) {
            Lutemon lutemon = lutemonList.get(lutemonSpinner.getSelectedItemPosition());
            updateLutemonInfo(lutemon);
        } else{
            trainButton.setEnabled(false); // disable train button when spinner is null
        }

        //click listener for Trainbutton
        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //counter
                trainCount++;

                //when pressed 5 times LevelUpping unlocks and Training disables.
                if (trainCount == 5) {
                    trainButton.setEnabled(false);
                    attackLvlUpButton.setEnabled(true);
                    defenseLvlUpButton.setEnabled(true);
                    maxHealthLvlUpButton.setEnabled(true);
                }
            }
        });

        //Click listener for Attack Level up button
        attackLvlUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lutemon lutemon = lutemonList.get(id);
                lutemon.levelUp("attack"); // find stat "attack" from .LevelUp method
                updateLutemonInfo(lutemon); //update the info on created Lutemon
                disableLevelUpButtons(); //  disable Level Up buttons after one click
                enableTrainButton(); // enable Train button
            }
        });

        defenseLvlUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lutemon lutemon = lutemonList.get(id);
                lutemon.levelUp("defense");
                updateLutemonInfo(lutemon);
                disableLevelUpButtons();
                enableTrainButton();
            }
        });

        maxHealthLvlUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lutemon lutemon = lutemonList.get(id);
                lutemon.levelUp("max health");
                updateLutemonInfo(lutemon);
                disableLevelUpButtons();
                enableTrainButton();
            }
        });

    }
    // Called in order for the app to recognize the Lutemon Level instantly after selection
    private void updateLutemonInfo(Lutemon lutemon) {
        lutemonLevelTextView.setText("Level: " + lutemon.getExperience());
    }
    // method to disable button use during training
    private void disableLevelUpButtons() {
        attackLvlUpButton.setEnabled(false);
        defenseLvlUpButton.setEnabled(false);
        maxHealthLvlUpButton.setEnabled(false);
    }
    // after level up set trainCount to 0 in order to Level up multiple times!
    private void enableTrainButton() {
        trainCount = 0;
        trainButton.setEnabled(true);
    }

    //methods included inorder to make OnSelectedItemListener work properly
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}

