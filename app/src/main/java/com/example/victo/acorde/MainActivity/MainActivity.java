package com.example.victo.acorde.MainActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


import com.example.victo.acorde.R;

import java.util.Calendar;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.editText1) EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
