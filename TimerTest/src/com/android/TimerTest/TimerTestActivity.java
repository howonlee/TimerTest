package com.android.TimerTest;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TimerTestActivity extends Activity {
	TextView txt;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        double then = (double) System.currentTimeMillis();
        double now = then;
        ArrayList<Double> deltas = new ArrayList<Double>();
        for (int i = 0; i < 1000; i++){
        	while ((now = System.currentTimeMillis()) == then);
        	deltas.add((now - then));
        }
        double total = 0;
        for (int i = 0; i < deltas.size(); i++){
        	total = total + deltas.get(i);
        }
        double avg = (total / deltas.size());
        txt = (TextView)findViewById(R.id.textView1);
        txt.setText(avg + " ms");
    }
}