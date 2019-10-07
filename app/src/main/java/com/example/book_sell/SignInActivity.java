package com.example.book_sell;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    AppDB appDB;
    EditText nUserName, nPass;
    Button nSignUp, nSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        appDB = new AppDB(this);
        innitData();
        nSignIn.setOnClickListener(this);
        nSignUp.setOnClickListener(this);
    }
    public void innitData(){
        nUserName = findViewById(R.id.sign_in_edtUserName);
        nPass = findViewById(R.id.sign_in_edtpassWord);
        nSignIn = findViewById(R.id.sign_in_btnSignIn);
        nSignUp = findViewById(R.id.sign_in_btnSignUp);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.sign_in_btnSignIn:
                checkLognIn();
                break;
            case R.id.sign_in_btnSignUp:
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }
    public void checkLognIn(){
        String tname = nUserName.getText().toString();
        String tpass = nPass.getText().toString();
        Toast.makeText(this, appDB.getTableUser_uername(tname).size() + "", Toast.LENGTH_SHORT ).show();
//        Toast.makeText(this, "kich thuoc: "+ appDB.getUserCount(), Toast.LENGTH_SHORT).show();
        ArrayList<db_User> dangnhap = appDB.getTableUser_uername(tname);
        if (dangnhap.size()!= 1)
            nUserName.setError("User name không đúng!");
        else  if (dangnhap.size()==1){
                if (dangnhap.get(0).getPassword().equals(tpass))
                    Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                else nPass.setError("hêy sai pass cưng!");
        }
    }
}
