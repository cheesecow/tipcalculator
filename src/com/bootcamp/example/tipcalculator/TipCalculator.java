package com.bootcamp.example.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TipCalculator extends Activity{
	public EditText etTotal;
	public TextView tvTipAmount;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		etTotal = (EditText) findViewById(R.id.etTotal);
		tvTipAmount = (TextView) findViewById(R.id.tvTipAmount);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}
	
	public void calcTip(View v){
		float calcPercentage = 0.0f;
		switch (v.getId()) {
	      case R.id.btnTen:
	    	calcPercentage = 0.1f;
	        break;
	      case R.id.btnFifteen:
	    	calcPercentage = 0.15f;
	        break;
	      case R.id.btnTwenty:
	    	calcPercentage = 0.2f;
		    break;
	    }
		if (etTotal.getText().toString().matches("")){
		  Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show();
		  return;
		} else {
			float value = Float.parseFloat(etTotal.getText().toString());
			float dispValue = value * calcPercentage;
			tvTipAmount.setText("$" + String.format("%.2f",dispValue));
		}
	}

}
