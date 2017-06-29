package com.lmntrx.android.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText inputET;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputET = (EditText) findViewById(R.id.inputET);

        sharedPreferences = getSharedPreferences("prefs",MODE_PRIVATE);

        String previousInput = sharedPreferences.getString("INPUT","");
        inputET.setText(previousInput);

    }

    @Override
    protected void onPause() {
        super.onPause();
        String input = inputET.getText().toString();

        sharedPreferences.edit().putString("INPUT",input).apply();
    }
}
