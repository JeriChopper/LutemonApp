package org.gpiste.lutemon;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BattleLutemonActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner lutemonSpinnerA;
    private Spinner lutemonSpinnerB;
    private Button battleButton;
    private ArrayList<Lutemon> lutemonlist;
    private Lutemon lutemonA;
    private Lutemon lutemonB;
    private TextView battleText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battlelutemon_activity);
        lutemonSpinnerA = findViewById(R.id.lutemonASpinner);
        lutemonSpinnerB = findViewById(R.id.lutemonBSpinner);
        battleButton = findViewById(R.id.battleButton);
        battleText = findViewById(R.id.BattleTextView);


        lutemonSpinnerA.setOnItemSelectedListener(this);
        lutemonSpinnerB.setOnItemSelectedListener(this);

        // Disable the button initially
        battleButton.setEnabled(false);

        //call method .getLutemonList to get Lutemon objects
        lutemonlist = Lutemon.getLutemonList();
        //create new list to put all of the Lutemon names
        ArrayList<String> lutemonBattleNames = new ArrayList<>();

        for (Lutemon lutemon : lutemonlist){
            //Add lutemons from Lutemon class to LutemonBattleNamesList in order to acquire just by their name
            lutemonBattleNames.add(lutemon.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lutemonBattleNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        lutemonSpinnerA.setAdapter(adapter);
        lutemonSpinnerB.setAdapter(adapter);

        battleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //find lutemonA from LutemonSpinnerA
                lutemonA = lutemonlist.get(lutemonSpinnerA.getSelectedItemPosition());
                //find lutemonB from LutemonSpinnerB
                lutemonB = lutemonlist.get(lutemonSpinnerB.getSelectedItemPosition());

                //Null-check if nothing has been selected
                if (lutemonA == null || lutemonB == null) {
                    return;
                }
                // Same lutemons check
                if (lutemonA == lutemonB){
                    return;
                }
                //  run method fight()
                fight(lutemonA, lutemonB);
            }
        });
    }

    private void fight(Lutemon lutemonA, Lutemon lutemonB) {

        // Display lutemonA stats.
        battleText.append(lutemonA.getColor() + "(" + lutemonA.getName() + ") att:" + lutemonA.getAttack() + "; def: " + lutemonA.getDefense() + "; exp: " + lutemonA.getExperience() + "; health: " + lutemonA.getHealth() + "/" + lutemonA.getMaxHealth() + "\n");

        // Display lutemonB stats
        battleText.append(lutemonB.getColor() + "(" + lutemonB.getName() + ") att:" + lutemonB.getAttack() + "; def: " + lutemonB.getDefense() + "; exp: " + lutemonB.getExperience() + "; health: " + lutemonB.getHealth() + "/" + lutemonB.getMaxHealth() + "\n");

        //while condition for the fight to go on
        while (lutemonA.getHealth() > 0 && lutemonB.getHealth() > 0) {
            battleText.append(":\n");

            //LutemonA does damage to LutemonB
            int damageA = lutemonA.getAttack() - lutemonB.getDefense();
            if (damageA <= 0) {
                damageA = 1;
            }



            lutemonB.takeDamage(damageA);
            battleText.append(lutemonA.getColor()+"(" + lutemonA.getName() + ") attacks "+lutemonB.getColor()+"(" + lutemonB.getName() + ") \n");
            if (lutemonB.getHealth() <= 0) {
                battleText.append(lutemonB.getName() + " gets killed.\n");
                lutemonA.addExperience();
                break;
            }
            else {
                // escapes death and fight goes on
                battleText.append(lutemonB.getColor()+"(" + lutemonB.getName() + ") manages to escape death.\n");

                // Display lutemonB stats after the previous fight
                battleText.append(lutemonB.getColor() + "(" + lutemonB.getName() + ") att:" + lutemonB.getAttack() + "; def: " + lutemonB.getDefense() + "; exp: " + lutemonB.getExperience() + "; health: " + lutemonB.getHealth() + "/" + lutemonB.getMaxHealth() + "\n");

                // Display lutemonA stats after the previous fight
                battleText.append(lutemonA.getColor() + "(" + lutemonA.getName() + ") att:" + lutemonA.getAttack() + "; def: " + lutemonA.getDefense() + "; exp: " + lutemonA.getExperience() + "; health: " + lutemonA.getHealth() + "/" + lutemonA.getMaxHealth() + "\n");
            }



            //LutemonB does damage to LutemonA
            int damageB = lutemonB.getAttack() - lutemonA.getDefense();
            if (damageB <= 0) {
                damageB = 1;
            }


            lutemonA.takeDamage(damageB);
            battleText.append(lutemonB.getColor()+"(" + lutemonB.getName() + ") attacks "+lutemonA.getColor()+"(" + lutemonA.getName() + ")\n");
            if (lutemonA.getHealth() <= 0) {
                battleText.append(lutemonA.getName() + " gets killed.\n");
                lutemonB.addExperience();
                break;
            }
            else {
                //escapes death and fight continues
                battleText.append(lutemonA.getColor()+"(" + lutemonA.getName() + ") manages to escape death.\n");

                // Display lutemonA stats after the previous fight
                battleText.append(lutemonA.getColor() + "(" + lutemonA.getName() + ") att:" + lutemonA.getAttack() + "; def: " + lutemonA.getDefense() + "; exp: " + lutemonA.getExperience() + "; health: " + lutemonA.getHealth() + "/" + lutemonA.getMaxHealth() + "\n");

                // Display lutemonB stats after the previous fight
                battleText.append(lutemonB.getColor() + "(" + lutemonB.getName() + ") att:" + lutemonB.getAttack() + "; def: " + lutemonB.getDefense() + "; exp: " + lutemonB.getExperience() + "; health: " + lutemonB.getHealth() + "/" + lutemonB.getMaxHealth() + "\n");

            }
        }
        // battle ends
        battleText.append("The battle is over.");
    }

    //methods included inorder to make OnSelectedItemListener work properly
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //find lutemonA from LutemonSpinnerA
        lutemonA = lutemonlist.get(lutemonSpinnerA.getSelectedItemPosition());
        //find lutemonB from LutemonSpinnerB
        lutemonB = lutemonlist.get(lutemonSpinnerB.getSelectedItemPosition());

        //Null-check if nothing has been selected
        if (lutemonA == null || lutemonB == null) {
            return;
        }
        //enable  button once two different Lutemons are selected
        if (lutemonA != lutemonB) {
            battleButton.setEnabled(true);
        } else {
            battleButton.setEnabled(false);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


