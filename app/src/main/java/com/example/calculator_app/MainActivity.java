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
import android.content.res.ColorStateList;
import android.graphics.Color;



public class MainActivity extends AppCompatActivity {
    TextView display;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnAdd, btnSub, btnMul, btnDiv, btnClr, btnEqual;

    double firstNumber = 0;
    double secondNumber = 0;
    double result = 0;
    char operator = ' ';

    DecimalFormat df = new DecimalFormat("#.####");

    boolean lastInputWasOperator = false;

    Button activeOperatorButton = null;


    private double calculate(double a, double b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        if (op == '/') return b != 0 ? a / b : 0;
        return b;
    }


    private void highlightOperator(Button btn) {
        if (activeOperatorButton != null) {
            activeOperatorButton.setBackgroundTintList(null);
        }
        btn.setBackgroundTintList(
                ColorStateList.valueOf(Color.parseColor("#FF9800"))
        );
        activeOperatorButton = btn;
    }


    private void clearOperatorHighlight() {
        if (activeOperatorButton != null) {
            activeOperatorButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D9544D")));
            activeOperatorButton = null;
        }
    }



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

        btn1.setOnClickListener(v -> {
            display.setText(display.getText().toString() + "1");
            lastInputWasOperator = false;
            clearOperatorHighlight();
        });
        btn2.setOnClickListener(v -> {
            display.setText(display.getText().toString() + "2");
            lastInputWasOperator = false;
            clearOperatorHighlight();
        });
        btn3.setOnClickListener(v -> {
            display.setText(display.getText().toString() + "3");
            lastInputWasOperator = false;
            clearOperatorHighlight();
        });
        btn4.setOnClickListener(v -> {
            display.setText(display.getText().toString() + "4");
            lastInputWasOperator = false;
            clearOperatorHighlight();
        });
        btn5.setOnClickListener(v -> {
            display.setText(display.getText().toString() + "5");
            lastInputWasOperator = false;
            clearOperatorHighlight();

        });
        btn6.setOnClickListener(v -> {
            display.setText(display.getText().toString() + "6");
            lastInputWasOperator = false;
            clearOperatorHighlight();
        });
        btn7.setOnClickListener(v -> {
            display.setText(display.getText().toString() + "7");
            lastInputWasOperator = false;
            clearOperatorHighlight();
        });
        btn8.setOnClickListener(v -> {
            display.setText(display.getText().toString() + "8");
            lastInputWasOperator = false;
            clearOperatorHighlight();
        });
        btn9.setOnClickListener(v -> {
            display.setText(display.getText().toString() + "9");
            lastInputWasOperator = false;
            clearOperatorHighlight();
        });
        btn0.setOnClickListener(v -> {
            display.setText(display.getText().toString() + "0");
            lastInputWasOperator = false;
            clearOperatorHighlight();
        });


        btnAdd.setOnClickListener(v -> {
            if (display.getText().toString().isEmpty()) return;
            if (lastInputWasOperator) return;

            double current = Double.parseDouble(display.getText().toString());

            if (operator == ' ') {
                firstNumber = current;
            } else {
                firstNumber = calculate(firstNumber, current, operator);
                display.setText(String.valueOf(firstNumber));
            }

            operator = '+';
            display.setText("");

            lastInputWasOperator = true;

            highlightOperator(btnAdd);
        });


        btnSub.setOnClickListener(v -> {
            if (display.getText().toString().isEmpty()) return;
            if (lastInputWasOperator) return;

            double current = Double.parseDouble(display.getText().toString());

            if (operator == ' ') {
                firstNumber = current;
            } else {
                firstNumber = calculate(firstNumber, current, operator);
                display.setText(String.valueOf(firstNumber));
            }

            operator = '-';
            display.setText("");

            lastInputWasOperator = true;

            highlightOperator(btnSub);
        });


        btnMul.setOnClickListener(v -> {
            if (display.getText().toString().isEmpty()) return;
            if (lastInputWasOperator) return;

            double current = Double.parseDouble(display.getText().toString());

            if (operator == ' ') {
                firstNumber = current;
            } else {
                firstNumber = calculate(firstNumber, current, operator);
                display.setText(String.valueOf(firstNumber));
            }

            operator = '*';
            display.setText("");

            lastInputWasOperator = true;

            highlightOperator(btnMul);
        });


        btnDiv.setOnClickListener(v -> {
            if (display.getText().toString().isEmpty()) return;
            if (lastInputWasOperator) return;

            double current = Double.parseDouble(display.getText().toString());

            if (operator == ' ') {
                firstNumber = current;
            } else {
                firstNumber = calculate(firstNumber, current, operator);
                display.setText(String.valueOf(firstNumber));
            }

            operator = '/';
            display.setText("");

            lastInputWasOperator = true;

            highlightOperator(btnDiv);
        });


        btnEqual.setOnClickListener(v -> {
            if (display.getText().toString().isEmpty()) return;

            double current = Double.parseDouble(display.getText().toString());
            double result = calculate(firstNumber, current, operator);

            display.setText(df.format(result));

            firstNumber = result;
            operator = ' ';
            lastInputWasOperator =  false;

            clearOperatorHighlight();
        });


        btnClr.setOnClickListener(v -> {
            display.setText("");
            firstNumber = 0;
            secondNumber = 0;
            result = 0;
            operator = ' ';
            lastInputWasOperator = false;

            clearOperatorHighlight();
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}