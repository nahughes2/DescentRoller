package com.descent.roller;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	LinearLayout redButton, blueButton, whiteButton, yellowButton, greenButton, blackButton;
	TextView redLabel, blueLabel, whiteLabel, yellowLabel, greenLabel, blackLabel;
	int redDice, blueDice, whiteDice, yellowDice, greenDice, blackDice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
}
