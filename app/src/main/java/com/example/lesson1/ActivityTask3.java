package com.example.lesson1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityTask3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task3);

        CalendarView myCalendarView = findViewById(R.id.myCalendarView);
        TextView calendarInfo = findViewById(R.id.calendarInfo);

        myCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String dataInfo = "Вы выбрали дату: " + dayOfMonth + "." + (month + 1) + "." + year;
                calendarInfo.setText(dataInfo);
            }
        });

        Button backToMain = findViewById(R.id.backToMain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTask3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
