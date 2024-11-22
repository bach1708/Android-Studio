package com.example.bai6;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextStudentID, editTextAge;
    private RadioGroup radioGroupGender, radioGroupHobby;
    private TextView textViewResult;
    private RadioButton radioMale, radioFemale, radioFootball, radioGaming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liên kết các view
        editTextName = findViewById(R.id.editTextName);
        editTextStudentID = findViewById(R.id.editTextStudentID);
        editTextAge = findViewById(R.id.editTextAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioGroupHobby = findViewById(R.id.radioGroupHobby);
        textViewResult = findViewById(R.id.textViewResult);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        radioFootball = findViewById(R.id.radioFootball);
        radioGaming = findViewById(R.id.radioGaming);

        Button buttonSave = findViewById(R.id.buttonSave);

        // Xử lý sự kiện khi nhấn nút lưu thông tin
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String studentID = editTextStudentID.getText().toString();
                String age = editTextAge.getText().toString();
                String gender = "";
                String hobby = "";

                // Xử lý giới tính
                if (radioMale.isChecked()) {
                    gender = "Nam";
                } else if (radioFemale.isChecked()) {
                    gender = "Nữ";
                }

                // Xử lý sở thích
                if (radioFootball.isChecked()) {
                    hobby = "Đá bóng";
                } else if (radioGaming.isChecked()) {
                    hobby = "Chơi game";
                }

                // Hiển thị kết quả
                String result = "Tên: " + name + "\nMã sinh viên: " + studentID + "\nTuổi: " + age + "\nGiới tính: " + gender + "\nSở thích: " + hobby;
                textViewResult.setText(result);
            }
        });
    }
}