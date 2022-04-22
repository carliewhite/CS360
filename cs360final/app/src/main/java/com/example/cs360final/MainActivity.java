package com.example.cs360final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // references to buttons and controls
    Button btn_add, btn_SMS, btn_change, btn_delete;
    EditText et_date, et_weight;
    ListView lv_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_add = findViewById(R.id.add_data);
        btn_change = findViewById(R.id.change);
        btn_delete = findViewById(R.id.remove);
        btn_SMS = findViewById(R.id.SMS);
        et_date = findViewById(R.id.editTextDate);
        et_weight = findViewById(R.id.weight);
        lv_log = findViewById(R.id.weight_list);

        Database database = new Database(MainActivity.this);
        List<UserModel> everyone = database.getEveryone();

        ArrayAdapter userArrayAdapter = new ArrayAdapter<UserModel>(MainActivity.this, android.R.layout.simple_list_item_1, everyone);
        lv_log.setAdapter(userArrayAdapter);

        // button listeners

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                UserModel userModel;
                try {
                    userModel = new UserModel(-1,
                            et_date.getText().toString(),
                            Integer.parseInt(et_weight.getText().toString()));
                    Toast.makeText(MainActivity.this, userModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    Toast.makeText(MainActivity.this, "error with entry", Toast.LENGTH_SHORT).show();
                    userModel = new UserModel(-1, "error", 0);
                }

                Database database = new Database(MainActivity.this);
                boolean success = database.addOne(userModel);
                Toast.makeText(MainActivity.this, "completed = " + success, Toast.LENGTH_SHORT).show();


            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel userModel;
                try {
                    userModel = new UserModel(-1,
                            et_date.getText().toString(),
                            Integer.parseInt(et_weight.getText().toString()));
                    Toast.makeText(MainActivity.this, userModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    Toast.makeText(MainActivity.this, "error with entry", Toast.LENGTH_SHORT).show();
                    userModel = new UserModel(-1, "error", 0);
                }

                Database database = new Database(MainActivity.this);
                boolean success = database.removeOne(userModel);
                Toast.makeText(MainActivity.this, "completed = " + success, Toast.LENGTH_SHORT).show();


            }
        });
        btn_SMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SMS.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "SMS button", Toast.LENGTH_SHORT).show();
            }
        });




    }
}