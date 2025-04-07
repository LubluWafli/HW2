package com.example.hw2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        final TextView textTablo = (TextView) findViewById(R.id.tablo);
        savedInstanceState.putString("textTabloOld",(String) textTablo.getText());

        super.onSaveInstanceState(savedInstanceState);
    }

//onRestoreInstanceState

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        final TextView textTabloNew = (TextView) findViewById(R.id.tablo);
        String textTabloOld = savedInstanceState.getString("textTabloOld");
        textTabloNew.setText(textTabloOld);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setContentView(R.layout.activity_main);

        final Button button0 = findViewById(R.id.button0);
        final Button button1 = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.button2);
        final Button button3 = findViewById(R.id.button3);
        final Button button4 = findViewById(R.id.button4);
        final Button button5 = findViewById(R.id.button5);
        final Button button6 = findViewById(R.id.button6);
        final Button button7 = findViewById(R.id.button7);
        final Button button8 = findViewById(R.id.button8);
        final Button button9 = findViewById(R.id.button9);
        final Button buttonEq = findViewById(R.id.buttonEq);
        final Button buttonDiv = findViewById(R.id.buttonDiv);
        final Button buttonDot = findViewById(R.id.buttonDot);
        final Button buttonClear = findViewById(R.id.buttonClear);
        final Button buttonPlus = findViewById(R.id.buttonPlus);
        final Button buttonMinus = findViewById(R.id.buttonMinus);

        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText("");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText((String) textTablo.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText((String) textTablo.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText((String) textTablo.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText((String) textTablo.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText((String) textTablo.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText((String) textTablo.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText((String) textTablo.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText((String) textTablo.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText((String) textTablo.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText((String) textTablo.getText() + "9");
            }
        });
    }
    
}