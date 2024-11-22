package com.example.bai5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextStudentID, editTextAge;
    private RadioGroup radioGroupGender, radioGroupHobby;
    private RadioButton radioMale, radioFemale, radioFootball, radioGaming;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các thành phần giao diện
        editTextName = findViewById(R.id.editTextName);
        editTextStudentID = findViewById(R.id.editTextStudentID);
        editTextAge = findViewById(R.id.editTextAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioGroupHobby = findViewById(R.id.radioGroupHobby);
        buttonSave = findViewById(R.id.buttonSave);

        // Xử lý sự kiện khi nhấn nút "Lưu thông tin"
        buttonSave.setOnClickListener(v -> {
            // Lấy thông tin từ các trường nhập liệu
            String name = editTextName.getText().toString();
            String studentID = editTextStudentID.getText().toString();
            String age = editTextAge.getText().toString();

            // Lấy thông tin giới tính
            int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
            String gender = "";
            if (selectedGenderId != -1) {
                RadioButton selectedGender = findViewById(selectedGenderId);
                gender = selectedGender.getText().toString();
            }

            // Lấy thông tin sở thích
            int selectedHobbyId = radioGroupHobby.getCheckedRadioButtonId();
            String hobby = "";
            if (selectedHobbyId != -1) {
                RadioButton selectedHobby = findViewById(selectedHobbyId);
                hobby = selectedHobby.getText().toString();
            }

            // Kiểm tra xem tất cả thông tin đã được nhập chưa
            if (name.isEmpty() || studentID.isEmpty() || age.isEmpty() || gender.isEmpty() || hobby.isEmpty()) {
                // Hiển thị thông báo nếu có trường chưa được điền
                Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            } else {
                // Hiển thị thông báo với thông tin đã nhập
                String message = "Tên: " + name + "\nMã sinh viên: " + studentID + "\nTuổi: " + age +
                        "\nGiới tính: " + gender + "\nSở thích: " + hobby;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}