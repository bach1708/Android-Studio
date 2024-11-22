package com.example.bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các thành phần
        EditText editTextCelsius = findViewById(R.id.editTextCelsius);
        EditText editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        Button buttonToCelsius = findViewById(R.id.buttonToCelsius);
        Button buttonToFahrenheit = findViewById(R.id.buttonToFahrenheit);
        Button buttonClear = findViewById(R.id.buttonClear);

        // Chuyển sang Celsius
        buttonToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nhietDoFInput = editTextFahrenheit.getText().toString();
                if (!nhietDoFInput.isEmpty()) {
                    double nhietDoF = Double.parseDouble(nhietDoFInput);
                    double nhietDoC = (nhietDoF - 32) * 5 / 9;
                    editTextCelsius.setText(String.format("%.2f", nhietDoC));
                }
            }
        });

        // Chuyển sang Fahrenheit
        buttonToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nhietDoCInput = editTextCelsius.getText().toString();
                if (!nhietDoCInput.isEmpty()) {
                    double nhietDoC = Double.parseDouble(nhietDoCInput);
                    double nhietDoF = nhietDoC * 9 / 5 + 32;
                    editTextFahrenheit.setText(String.format("%.2f", nhietDoF));
                }
            }
        });

        // Xóa dữ liệu
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextCelsius.setText("");
                editTextFahrenheit.setText("");
            }
        });
    }
}