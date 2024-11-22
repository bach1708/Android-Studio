package com.example.bai2;

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
        EditText editTextWeight = findViewById(R.id.editTextWeight);
        EditText editTextHeight = findViewById(R.id.editTextHeight);
        Button buttonCalculateBMI = findViewById(R.id.buttonCalculateBMI);
        TextView textViewBMI = findViewById(R.id.textViewBMI);
        TextView textViewDiagnosis = findViewById(R.id.textViewDiagnosis);

        // Xử lý khi nhấn nút tính BMI
        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightInput = editTextWeight.getText().toString();
                String heightInput = editTextHeight.getText().toString();

                // Kiểm tra nếu người dùng chưa nhập dữ liệu
                if (weightInput.isEmpty() || heightInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ khối lượng và chiều cao!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Chuyển đổi dữ liệu
                double weight = Double.parseDouble(weightInput);
                double height = Double.parseDouble(heightInput);

                // Kiểm tra dữ liệu hợp lệ
                if (weight <= 0 || height <= 0) {
                    Toast.makeText(MainActivity.this, "Khối lượng và chiều cao phải lớn hơn 0!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tính chỉ số BMI
                double bmi = weight / (height * height);
                textViewBMI.setText(String.format("Chỉ số BMI: %.2f", bmi));

                // Chẩn đoán tình trạng cơ thể
                String diagnosis;
                if (bmi < 18) {
                    diagnosis = "Người gầy";
                } else if (bmi < 25) {
                    diagnosis = "Người bình thường";
                } else if (bmi < 30) {
                    diagnosis = "Người béo phì độ I";
                } else if (bmi < 35) {
                    diagnosis = "Người béo phì độ II";
                } else {
                    diagnosis = "Người béo phì độ III";
                }

                textViewDiagnosis.setText("Tình trạng cơ thể: " + diagnosis);
            }
        });
    }
}