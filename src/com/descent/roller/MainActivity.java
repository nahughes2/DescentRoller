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
			rolledSurge, modifyRange, modifyDamage;
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

		Random randomGenerator = new Random();

		for (int i = 0; i < redDice; i++) {
			int roll = randomGenerator.nextInt(5);
			diceArray[i] = new Dice(roll, 0);
		}
		for (int i = 0; i < blueDice; i++) {
			int roll = randomGenerator.nextInt(5);
			diceArray[redDice + i - 1] = new Dice(roll, 1);
		}
		for (int i = 0; i < whiteDice; i++) {
			int roll = randomGenerator.nextInt(5);
			diceArray[redDice + blueDice + i - 1] = new Dice(roll, 2);
		}
		for (int i = 0; i < yellowDice; i++) {
			int roll = randomGenerator.nextInt(5);
			diceArray[redDice + blueDice + whiteDice + i - 1] = new Dice(roll, 3);
		}
		for (int i = 0; i < greenDice; i++) {
			int roll = randomGenerator.nextInt(5);
			diceArray[redDice + blueDice + whiteDice + yellowDice + i - 1] = new Dice(roll, 4);
		}
		for (int i = 0; i < blackDice; i++) {
			int roll = randomGenerator.nextInt(5);
			diceArray[redDice + blueDice + whiteDice + yellowDice + greenDice + i - 1] = new Dice(
					roll, 5);
			modifyDamage += diceArray[redDice + blueDice + whiteDice + yellowDice + greenDice + i
					- 1].getDamage();
			modifyRange += diceArray[redDice + blueDice + whiteDice + yellowDice + greenDice + i
					- 1].getRange();
			rolledSurge += diceArray[redDice + blueDice + whiteDice + yellowDice + greenDice + i
					- 1].getSurge();
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

	}

	public void updateSolution() {

	}
}
