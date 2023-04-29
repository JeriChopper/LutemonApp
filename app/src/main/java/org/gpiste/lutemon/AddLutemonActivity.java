package org.gpiste.lutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddLutemonActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addlutemon_activity);


        radioGroup = findViewById(R.id.radio_group);
        editText = findViewById(R.id.edittext_selected);

        Button Btnsave = findViewById(R.id.button_save);
        Btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = radioGroup.getCheckedRadioButtonId();
                //find color by radioId
                radioButton = findViewById(radioId);
                String name = editText.getText().toString();
                String color = radioButton.getText().toString();

                if (name.isEmpty()) {
                    // show error message if the name is an empty string
                    Toast.makeText(AddLutemonActivity.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }


                //initialize all of the variables in order to pass them to Lutemon.
                int attack, defense, experience = 0, MaxHealth = 0, health = 0, id = 0;

                // switch-case where the color string defines the stats of each Lutemon
                switch (color){
                    case "White":
                        attack = 5;
                        defense = 4;
                        MaxHealth = 20;
                        health = 20;
                        break;
                    case "Green":
                        attack = 6;
                        defense = 3;
                        MaxHealth = 19;
                        health = 19;
                        break;
                    case "Pink":
                        attack = 7;
                        defense = 2;
                        MaxHealth = 18;
                        health = 18;
                        break;
                    case "Orange":
                        attack = 8;
                        defense = 1;
                        MaxHealth = 17;
                        health = 17;
                        break;
                    case "Black":
                        attack = 9;
                        defense = 0;
                        MaxHealth = 16;
                        health = 16;
                        break;
                    default:
                        attack = 0;
                        defense = 0;
                        break;
                }

                //creating new Lutemon in to Lutemon Object.
                Lutemon newLutemon = new Lutemon(name,color,attack,defense,experience,MaxHealth,health,id);
                /// adding new Lutemon to an ArrayList with .getLutemonList method
                Lutemon.getLutemonList().add(newLutemon);

                /// Creating Toast for user to realise new lutemon has been created and added to the list
                String message = "New Lutemon added: " + newLutemon.getName() + " - " + newLutemon.getColor();
                Toast.makeText(AddLutemonActivity.this, message, Toast.LENGTH_SHORT).show();

                // empty edittext for next use
                editText.setText("");
            }
        });
    }
}
