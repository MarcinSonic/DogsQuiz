package com.example.android.dogsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    RadioButton radio13, radio22, radio33;


    public void countPoints(View view) {
        // Get user's name
        EditText nameField = findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        // Figure out which CheckBoxes are checked
        CheckBox frisbeeCheckBox = findViewById(R.id.frisbee_checkbox);
        boolean isFrisbee = frisbeeCheckBox.isChecked();

        CheckBox footballCheckBox = findViewById(R.id.football_checkbox);
        boolean isFootball = footballCheckBox.isChecked();

        CheckBox agilityCheckBox = findViewById(R.id.agility_checkbox);
        boolean isAgility = agilityCheckBox.isChecked();

        CheckBox tenisCheckBox = findViewById(R.id.tenis_checkbox);
        boolean isTenis = tenisCheckBox.isChecked();

        //Calculate score after first question

        int score = firstQuestionScore(isFrisbee, isFootball, isAgility,isTenis);

        //Lets start with radio buttons, only correct answers coz else do nothing

        radio13 = findViewById(R.id.radio_13);
        boolean isRadio13 = radio13.isChecked();
        radio22 = findViewById(R.id.radio_22);
        boolean isRadio22 = radio22.isChecked();
        radio33 = findViewById(R.id.radio_33);
        boolean isRadio33 = radio33.isChecked();

        if (isRadio13) {
            score = score +1;
        }
        if (isRadio22) {
            score = score +1;
        }
        if (isRadio33) {
            score = score +1;
        }

        //Display score on the screen

        Toast.makeText(this, getString(R.string.well_done)+" " + name +getString(R.string.your_score)+" " + score, Toast.LENGTH_LONG).show();
    }

    //Calculete score from First Question
    private int firstQuestionScore(boolean addFrisbee, boolean addFootball, boolean addAgility, boolean addTenis) {
        int score = 0;
        // If the user checked correct answear add 1 point
        if (addFrisbee) {
            score = score + 1;
        }
        if (addAgility) {
            score = score + 1;
        }
        // If the user checked wrong answear subtract 1 point
        if (addFootball) {
            score = score - 1;
        }
        if (addTenis) {
            score = score - 1;
        }
        return score;
    }

    //Reset Quiz to start it again
    public void reset(View view) {

        //Clear all radio buttons
        RadioGroup radioGroup = findViewById(R.id.question_2_radio_group);
        radioGroup.clearCheck();
        RadioGroup radioGroup2 = findViewById(R.id.question_3_radio_group);
        radioGroup2.clearCheck();
        RadioGroup radioGroup3 = findViewById(R.id.question_4_radio_group);
        radioGroup3.clearCheck();

        //Clear check boxes state
        CheckBox frisbeeCheckBox = findViewById(R.id.frisbee_checkbox);
        frisbeeCheckBox.setChecked(false);
        CheckBox footballCheckBox = findViewById(R.id.football_checkbox);
        footballCheckBox.setChecked(false);
        CheckBox agilityCheckBox = findViewById(R.id.agility_checkbox);
        agilityCheckBox.setChecked(false);
        CheckBox tenisCheckBox = findViewById(R.id.tenis_checkbox);
        tenisCheckBox.setChecked(false);

        //Clear name
        EditText nameField = findViewById(R.id.name_field);
        nameField .setText("");

    }

}