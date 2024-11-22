package com.example.bai3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các thành phần giao diện
        EditText editTextA = findViewById(R.id.editTextA);
        EditText editTextB = findViewById(R.id.editTextB);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        TextView textViewResult = findViewById(R.id.textViewResult);

        // Xử lý sự kiện nút cộng
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(editTextA, editTextB, textViewResult, "+");
            }
        });

        // Xử lý sự kiện nút trừ
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(editTextA, editTextB, textViewResult, "-");
            }
        });

        // Xử lý sự kiện nút nhân
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(editTextA, editTextB, textViewResult, "*");
            }
        });

        // Xử lý sự kiện nút chia
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(editTextA, editTextB, textViewResult, "/");
            }
        });
    }

    private void calculate(EditText editTextA, EditText editTextB, TextView textViewResult, String operator) {
        String inputA = editTextA.getText().toString();
        String inputB = editTextB.getText().toString();

        if (inputA.isEmpty() || inputB.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ số a và b!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double a = Double.parseDouble(inputA);
            double b = Double.parseDouble(inputB);
            double result = 0;

            switch (operator) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = a / b;
                    break;
            }

            textViewResult.setText("Kết quả: " + result);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}