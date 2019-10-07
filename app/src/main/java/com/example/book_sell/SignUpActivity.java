package com.example.book_sell;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    AppDB appDB = new AppDB(this);
    EditText username, pass, repass, email, quequan, sothich;
    Button signUp, male, female;
    TextView dateofbirth;
    String gioitinh;
    private DatePickerDialog.OnDateSetListener mdata;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);


        anhxa();
        signUp.setOnClickListener(this);
        dateofbirth.setOnClickListener(this);
        mdata = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String d = dayOfMonth + "/" + month + "/" + year;
                dateofbirth.setText(d);
            }
        };
        male.setOnClickListener(this);
        female.setOnClickListener(this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_thongtin:
                Intent intent = new Intent(SignUpActivity.this, Thong_Tin.class );
                startActivity(intent);
                break;
            case R.id.menu_caidat: break;
            case R.id.menu_dangxuat: break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void checkSignUp() {
        int tname = appDB.getTableUser_uername(username.getText().toString()).size();
        int temail = appDB.getTableUser_email(email.getText().toString()).size();
        if (tname == 1){
            username.setError("Tên đăng nhập này đã tồn tại");
        }
        if (temail == 1){
            username.setError("Email này đã được sử dụng");
        }
    }
    private void anhxa() {
        username = findViewById(R.id.signupactivity_username);
        pass = findViewById(R.id.signupactivity_pass);
        repass = findViewById(R.id.signupactivity_passAgain);
        email = findViewById(R.id.signupactivity_email);
        quequan = findViewById(R.id.signupactivity_quequan);
        sothich = findViewById(R.id.signupactivity_soThich);
        signUp = findViewById(R.id.signupactivity_btnSignUp);
        male = findViewById(R.id.signupactivity_male);
        female = findViewById(R.id.signupactivity_female);
        dateofbirth = findViewById(R.id.signupactivity_date);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signupactivity_btnSignUp:
                if (pass.getText().toString().length()<5) pass.setError("Mật khẩu chưa đủ ký tự");
                else if (repass.getText().toString().equals(pass.getText().toString())!=true) repass.setError("Mật khẩu chưa đúng");
                break;
            case R.id.signupactivity_date:
                Calendar cl = Calendar.getInstance();
                int year = cl.get(Calendar.YEAR);
                int month = cl.get(Calendar.MONTH);
                int day = cl.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(this, android.R.style.Theme_DeviceDefault_Dialog_Alert,
                        mdata, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                break;
            case R.id.signupactivity_male: gioitinh = "Nam"; break;
            case R.id.signupactivity_female: gioitinh = "Nữ"; break;
        }
    }

}
