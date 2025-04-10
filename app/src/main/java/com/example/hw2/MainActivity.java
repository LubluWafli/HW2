package com.example.hw2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    byte choosenOperation = 0;
    double firstNum = 0;
    double temp = 0;
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        final TextView textTablo = (TextView) findViewById(R.id.tablo);
        savedInstanceState.putString("textTabloOld",(String) textTablo.getText());
        savedInstanceState.putByte("choosenOperationOld",choosenOperation);
        savedInstanceState.putDouble("firstNumOld", firstNum);
        savedInstanceState.putDouble("tempOld",temp);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        final TextView textTabloNew = (TextView) findViewById(R.id.tablo);
        String textTabloOld = savedInstanceState.getString("textTabloOld");
        choosenOperation = savedInstanceState.getByte("choosenOperationOld");
        firstNum = savedInstanceState.getDouble("firstNumOld");
        temp = savedInstanceState.getDouble("tempOld");
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

        final TextView textTablo = (TextView) findViewById(R.id.tablo);
        textTablo.setText("");

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
        final Button buttonMult = findViewById(R.id.buttonMult);
        final Button buttonDot = findViewById(R.id.buttonDot);
        final Button buttonClear = findViewById(R.id.buttonClear);
        final Button buttonPlus = findViewById(R.id.buttonPlus);
        final Button buttonMinus = findViewById(R.id.buttonMinus);
        final Button buttonPlusMinus = findViewById(R.id.buttonPlusMinus);

        buttonPlusMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                Log.w("myApp", String.valueOf(textTablo.getText().charAt(0)));
                if (textTablo.getText() != "")
                {

                    if (String.valueOf(textTablo.getText().charAt(0)).equals("-"))
                    {
                        String textTemp = (String) textTablo.getText();
                        textTemp = textTemp.substring(1);
                        textTablo.setText(textTemp);
                    }
                    else
                    {
                        textTablo.setText("-" + textTablo.getText());
                    }
                }


            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText("");
                firstNum = 0;
                choosenOperation = 0;
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

        buttonEq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                if (choosenOperation != 0 & textTablo.getText() != "" ) {
                    Log.w("myApp", "ВЫБРАННАЯ ОПЕРАЦИЯ");
                    Log.w("myApp", String.valueOf(choosenOperation));
                    double temp = 0;
                    temp += Double.parseDouble((String) textTablo.getText());
                    switch (choosenOperation)
                    {
                        case (1):
                        {
                            firstNum += temp;
                            Log.w("myApp", "Зашел в case 1");
                            break;
                        }
                        case (2):
                        {
                            firstNum -= temp;
                            Log.w("myApp", "Зашел в case 2");
                            break;
                        }
                        case (3):
                        {
                            firstNum *= temp;
                            Log.w("myApp", "Зашел в case 3");
                            break;
                        }
                        case (4):
                        {
                            firstNum /= temp;
                            Log.w("myApp", "Зашел в case 4");
                            break;
                        }
                    }
                    textTablo.setText(String.valueOf(firstNum));
                    choosenOperation = 0;
                    firstNum = 0;
                    temp = 0;
                }
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (textTablo.getText() != "")
                {
                    choosenOperation = 1;
                    final TextView textTablo = (TextView) findViewById(R.id.tablo);
                    firstNum = Double.parseDouble((String) textTablo.getText());
                    textTablo.setText("");
                }
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textTablo.getText() != "")
                {
                    choosenOperation = 2;
                    final TextView textTablo = (TextView) findViewById(R.id.tablo);
                    firstNum = Double.parseDouble((String) textTablo.getText());
                    textTablo.setText("");
                }
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textTablo.getText() != "")
                {
                    choosenOperation = 3;
                    final TextView textTablo = (TextView) findViewById(R.id.tablo);
                    firstNum = Double.parseDouble((String) textTablo.getText());
                    textTablo.setText("");
                }
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textTablo.getText() != "")
                {
                    choosenOperation = 4;
                    final TextView textTablo = (TextView) findViewById(R.id.tablo);
                    firstNum = Double.parseDouble((String) textTablo.getText());
                    textTablo.setText("");
                }
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView textTablo = (TextView) findViewById(R.id.tablo);
                textTablo.setText((String) textTablo.getText() + ".");
            }
        });
    }
    boolean checkTablo()
    {
        final TextView textTablo = (TextView) findViewById(R.id.tablo);
        if (textTablo.getText() == "")
        {
            return false;
        }
        return true;
    }
}