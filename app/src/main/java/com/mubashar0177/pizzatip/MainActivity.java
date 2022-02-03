package com.mubashar0177.pizzatip;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView show;
    EditText amount;
    TextView tip;
    TextView total;
    SeekBar sr;
    int percent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = findViewById(R.id.seekper);

        sr = findViewById(R.id.sr);
        amount = findViewById(R.id.amount);
        tip = findViewById(R.id.tip);
        total = findViewById(R.id.total);
        sr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {   percent=progress;
                show.setText(String.valueOf(percent));
                calculate(percent);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculate(percent);
            }
        });

    }
    private void calculate(int percent)
    {
        if(amount.length()==0)
        {
            amount.requestFocus();
            amount.setError("Enter Amount");
        }
        else
        {
            double a=Double.parseDouble(amount.getText().toString());
            double ti=(a*percent)/100.0;
            double tot=ti+a;
            tip.setText(String.valueOf(ti));
            total.setText(String.valueOf(tot));



        }

    }



}