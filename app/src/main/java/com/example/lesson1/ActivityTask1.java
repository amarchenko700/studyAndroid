package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class ActivityTask1 extends AppCompatActivity {

    private Integer clickСounter = 1;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private ToggleButton bothFeatures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task1);

        bothFeatures = findViewById(R.id.bothFeatures);
        checkBox1 = findViewById(R.id.feature1);
        checkBox2 = findViewById(R.id.feature2);

        TextView clickCounterTextView = findViewById(R.id.clickСounter);

        Button myFirstButton = findViewById(R.id.myFirstButton);
        myFirstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCounterTextView.setText("Вы нажали на кнопку " + clickСounter + " раз!");
                clickСounter++;
            }
        });

        Button backToMain = findViewById(R.id.backToMain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTask1.this, MainActivity.class);
                startActivity(intent);
            }
        });

        View.OnClickListener ClickListenerChekBox = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextFeature();
            }
        };

        checkBox1.setOnClickListener(ClickListenerChekBox);
        checkBox2.setOnClickListener(ClickListenerChekBox);

        bothFeatures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(bothFeatures.isChecked());
                checkBox2.setChecked(bothFeatures.isChecked());
                setTextFeature();
            }
        });

        TextView textViewSwitch = findViewById(R.id.textViewSwitch);
        Switch testSwitch = findViewById(R.id.testSwitch);
        testSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(testSwitch.isChecked()){
                    textViewSwitch.setText("Включено");
                }else{
                    textViewSwitch.setText("Выключено");
                }

            }
        });
    }

    private void setTextFeature(){
        TextView textFeaturesTextView = findViewById(R.id.textFeatures);
        String textFeatures = "";
        if (checkBox1.isChecked()){
            textFeatures = "Опция 1: вкл; ";
        }else {
            textFeatures = "Опция 1: выкл; ";
        }
        if (checkBox2.isChecked()){
            textFeatures = textFeatures + "Опция 2: вкл;";
        }else {
            textFeatures = textFeatures + "Опция 2: выкл;";
        }
        textFeaturesTextView.setText(textFeatures);
        if(checkBox1.isChecked() & checkBox2.isChecked()){
            bothFeatures.setChecked(true);
        }else {
            bothFeatures.setChecked(false);
        }
    }
}