package com.example.calculator_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    TextView display;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnAdd, btnSub, btnMul, btnDiv, btnClr, btnEqual;

    double firstNumber = 0;
    double secondNumber = 0;
    double result = 0;
    char operator = ' ';

    DecimalFormat df = new DecimalFormat("#.####");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.edtdisplay);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnClr = findViewById(R.id.btnClr);
        btnEqual = findViewById(R.id.btnEqual);

        btn1.setOnClickListener(v -> display.setText(display.getText().toString() + "1"));
        btn2.setOnClickListener(v -> display.setText(display.getText().toString() + "2"));
        btn3.setOnClickListener(v -> display.setText(display.getText().toString() + "3"));
        btn4.setOnClickListener(v -> display.setText(display.getText().toString() + "4"));
        btn5.setOnClickListener(v -> display.setText(display.getText().toString() + "5"));
        btn6.setOnClickListener(v -> display.setText(display.getText().toString() + "6"));
        btn7.setOnClickListener(v -> display.setText(display.getText().toString() + "7"));
        btn8.setOnClickListener(v -> display.setText(display.getText().toString() + "8"));
        btn9.setOnClickListener(v -> display.setText(display.getText().toString() + "9"));
        btn0.setOnClickListener(v -> display.setText(display.getText().toString() + "0"));

        btnAdd.setOnClickListener(v -> {
            if (display.getText().toString().equals("")) {
                return;
            }
            firstNumber = Double.parseDouble(display.getText().toString());
            operator = '+';
            display.setText("");
        });

        btnSub.setOnClickListener(v -> {
            if (display.getText().toString().equals("")) {
                return;
            }
            firstNumber = Double.parseDouble(display.getText().toString());
            operator = '-';
            display.setText("");
        });

        btnMul.setOnClickListener(v -> {
            if (display.getText().toString().equals("")) {
                return;
            }
            firstNumber = Double.parseDouble(display.getText().toString());
            operator = '*';
            display.setText("");
        });

        btnDiv.setOnClickListener(v -> {
            if (display.getText().toString().equals("")) {
                return;
            }
            firstNumber = Double.parseDouble(display.getText().toString());
            operator = '/';
            display.setText("");
        });

        btnEqual.setOnClickListener(v -> {
            secondNumber = Double.parseDouble(display.getText().toString());
            switch (operator) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    result = firstNumber / secondNumber;
                    break;
            }
            display.setText(df.format(result));
        });

        btnClr.setOnClickListener(v -> {
            display.setText("");
            firstNumber = 0;
            secondNumber = 0;
            result = 0;
            operator = ' ';
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}