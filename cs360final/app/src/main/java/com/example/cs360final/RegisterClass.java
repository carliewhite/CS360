package com.example.cs360final;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cs360final.LoginDB;

public class RegisterClass extends AppCompatActivity {

    EditText username, password;
    Button register, login;
    LoginDB DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        DB = new LoginDB(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                Boolean checkuser = DB.checkusername(user);
                if(checkuser==false){
                    Boolean insert = DB.insertData(user, pass);
                    if(insert==true){
                        Toast.makeText(RegisterClass.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(RegisterClass.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(RegisterClass.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                }
                }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}