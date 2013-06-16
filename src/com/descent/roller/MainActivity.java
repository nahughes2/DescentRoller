package com.descent.roller;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    LinearLayout redButton, blueButton, whiteButton, yellowButton, greenButton, blackButton;
    Button clearButton, rollButton;
    TextView redLabel, blueLabel, whiteLabel, yellowLabel, greenLabel, blackLabel, damageLabel,
            rangeLabel, surgeLabel, modifierLabel;
    int redDice, blueDice, whiteDice, yellowDice, greenDice, blackDice, rolledRange, rolledDamage,
            rolledSurge,modNumber;
    boolean missed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        redButton = (LinearLayout) findViewById(R.id.redButton);
        blueButton = (LinearLayout) findViewById(R.id.blueButton);
        whiteButton = (LinearLayout) findViewById(R.id.whiteButton);
        yellowButton = (LinearLayout) findViewById(R.id.yellowButton);
        greenButton = (LinearLayout) findViewById(R.id.greenButton);
        blackButton = (LinearLayout) findViewById(R.id.blackButton);

        redLabel = (TextView) findViewById(R.id.redDice);
        blueLabel = (TextView) findViewById(R.id.blueDice);
        whiteLabel = (TextView) findViewById(R.id.whiteDice);
        yellowLabel = (TextView) findViewById(R.id.yellowDice);
        greenLabel = (TextView) findViewById(R.id.greenDice);
        blackLabel = (TextView) findViewById(R.id.blackDice);

        damageLabel = (TextView) findViewById(R.id.damageAnswer);
        rangeLabel = (TextView) findViewById(R.id.rangeAnswer);
        surgeLabel = (TextView) findViewById(R.id.surgesAnswer);

        redButton.setOnTouchListener(new ButtonTouchListener());
        blueButton.setOnTouchListener(new ButtonTouchListener());
        whiteButton.setOnTouchListener(new ButtonTouchListener());
        yellowButton.setOnTouchListener(new ButtonTouchListener());
        greenButton.setOnTouchListener(new ButtonTouchListener());
        blackButton.setOnTouchListener(new ButtonTouchListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private class ButtonTouchListener implements OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            if (view == redButton) {
                redDice++;
            } else if (view == blueButton) {
                blueDice++;
            } else if (view == whiteButton) {
                whiteDice++;
            } else if (view == yellowButton) {
                yellowDice++;
            } else if (view == greenButton) {
                greenDice++;
            } else if (view == blackButton) {
                blackDice++;
            }

            updateFields();
            return false;
        }
    }

    public void updateFields() {
        redLabel.setText(Integer.toString(redDice));
        blueLabel.setText(Integer.toString(blueDice));
        whiteLabel.setText(Integer.toString(whiteDice));
        yellowLabel.setText(Integer.toString(yellowDice));
        greenLabel.setText(Integer.toString(greenDice));
        blackLabel.setText(Integer.toString(blackDice));
    }

    public void clearFields(View view) {
        redDice = 0;
        blueDice = 0;
        whiteDice = 0;
        yellowDice = 0;
        greenDice = 0;
        blackDice = 0;

        rolledDamage = 0;
        rolledRange = 0;
        rolledSurge = 0;

        redLabel.setText(Integer.toString(redDice));
        blueLabel.setText(Integer.toString(blueDice));
        whiteLabel.setText(Integer.toString(whiteDice));
        yellowLabel.setText(Integer.toString(yellowDice));
        greenLabel.setText(Integer.toString(greenDice));
        blackLabel.setText(Integer.toString(blackDice));
    }

    public void rollDice(View view) {
        int totalDice = redDice + whiteDice + blueDice + yellowDice + greenDice + blackDice;
        Dice[] diceArray;
        diceArray = new Dice[totalDice];
        int currentLocation = 0;

        Random randomGenerator = new Random();

        if(redDice > 0) {
            for (int i = 0; i < redDice; i++) {
                int roll = randomGenerator.nextInt(5);
                diceArray[i] = new Dice(roll, 0);
                currentLocation++;
            }
        }
        if(blueDice > 0) {
            for (int i = 0; i < blueDice; i++) {
                int roll = randomGenerator.nextInt(5);
                currentLocation++;
                diceArray[currentLocation - 1] = new Dice(roll, 1);
            }
        }
        if(whiteDice > 0) {
            for (int i = 0; i < whiteDice; i++) {
                int roll = randomGenerator.nextInt(5);
                currentLocation++;
                diceArray[currentLocation - 1] = new Dice(roll, 2);
            }
        }
        if(yellowDice > 0) {
            for (int i = 0; i < yellowDice; i++) {
                int roll = randomGenerator.nextInt(5);
                currentLocation++;
                diceArray[currentLocation - 1] = new Dice(roll, 3);
            }
        }
        if(greenDice > 0) {
            for (int i = 0; i < greenDice; i++) {
                int roll = randomGenerator.nextInt(5);
                currentLocation++;
                diceArray[currentLocation - 1] = new Dice(roll, 4);
            }
        }
        if(blackDice > 0) {
            for (int i = 0; i < blackDice; i++) {
                int roll = randomGenerator.nextInt(5);
                currentLocation++;
                diceArray[currentLocation - 1] = new Dice(
                        roll, 5);
                rolledDamage += diceArray[currentLocation
                        - 1].getDamage();
                rolledRange += diceArray[currentLocation
                        - 1].getRange();
                rolledSurge += diceArray[currentLocation
                        - 1].getSurge();
            }
        }
        for (int i = 0; i < totalDice - blackDice; i++) {
            if (diceArray[i].getMiss()) {
                missed = diceArray[i].getMiss();
                updateSolution();
                break;
            } else {
                rolledRange += diceArray[i].getRange();
                rolledDamage += diceArray[i].getDamage();
                rolledSurge += diceArray[i].getSurge();
            }
        }

        updateSolution();
    }

    public void updateSolution() {
        damageLabel.setText(Integer.toString(rolledDamage));
        rangeLabel.setText(Integer.toString(rolledRange));
        surgeLabel.setText(Integer.toString(rolledSurge));
    }

    public void increaseValue(View view) {
        if(view.getId() == R.id.plusDamage) {

        } else {

        }

    }

    public void decreaseValue(View view) {
        if(view.getId() == R.id.plusDamage) {

        } else {

        }
    }
}
