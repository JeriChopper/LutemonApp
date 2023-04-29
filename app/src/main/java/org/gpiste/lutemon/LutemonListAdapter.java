package org.gpiste.lutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class LutemonListAdapter extends ArrayAdapter<Lutemon> {
    private Context context;
    private ArrayList<Lutemon> LutemonArrayList;

    //adapter for LutemonListActivity
    public LutemonListAdapter(Context context, ArrayList<Lutemon> LutemonArrayList) {
        super(context, 0, LutemonArrayList);
        this.context = context;
        this.LutemonArrayList = LutemonArrayList;

    }

    // get view for Lutemon ListView
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lutemon_list_item, parent, false);
        }

        Lutemon lutemon = LutemonArrayList.get(position);

        // set all stats to string and display them in convertview
        TextView LutemonNameText = convertView.findViewById(R.id.LutemonNameTextView);
        LutemonNameText.setText("Name: " + lutemon.getName());


        TextView LutemonColorText = convertView.findViewById(R.id.LutemonColorTextView);
        LutemonColorText.setText("Color: " + lutemon.getColor());

        TextView LutemonAttackText = convertView.findViewById(R.id.LutemonAttackTextView);
        LutemonAttackText.setText("Attack: " + lutemon.getAttack());

        TextView LutemonDefenseText = convertView.findViewById(R.id.LutemonDefenseTextView);
        LutemonDefenseText.setText("Defense: " + lutemon.getDefense());

        TextView LutemonExperienceText = convertView.findViewById(R.id.LutemonExperienceTextView);
        LutemonExperienceText.setText("Experience: " + lutemon.getExperience());

        TextView LutemonMaxHealthText = convertView.findViewById(R.id.LutemonMaxHealthTextView);
        LutemonMaxHealthText.setText("Max Health: " + lutemon.getMaxHealth());


        return convertView;
    }
}

