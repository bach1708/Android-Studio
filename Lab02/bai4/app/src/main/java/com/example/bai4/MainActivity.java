package com.example.bai4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin người dùng
                EditText editTextName = findViewById(R.id.editTextName);
                RadioGroup radioGroupLevel = findViewById(R.id.radioGroupLevel);
                RadioGroup radioGroupLanguage = findViewById(R.id.radioGroupLanguage);

                String name = editTextName.getText().toString();
                String level = getSelectedRadioButtonText(radioGroupLevel);
                String language = getSelectedRadioButtonText(radioGroupLanguage);

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập họ và tên", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (level.isEmpty() || language.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn trường và ngôn ngữ học", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Hiển thị thông tin đã lưu
                Toast.makeText(MainActivity.this, "Thông tin đã được lưu:\n" +
                        "Tên: " + name + "\nTrình độ: " + level + "\nNgôn ngữ: " + language, Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getSelectedRadioButtonText(RadioGroup radioGroup) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            return selectedRadioButton.getText().toString();
        }
        return "";
    }
}