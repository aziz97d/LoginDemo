package com.example.abdulaziz.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userNameTxt, passwordTxt;
    private Button btnLogin;
    private TextView txtAttamp;
    private int value=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameTxt = findViewById(R.id.userNameId);
        passwordTxt = findViewById(R.id.passwordId);

        btnLogin = findViewById(R.id.btnLogin);

        txtAttamp = findViewById(R.id.attempId);
        txtAttamp.setText("Number of remaining attemps: "+value);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = passwordTxt.getText().toString();
                String userName = userNameTxt.getText().toString();

                if (password.equals("1234") && userName.equals("admin")){
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                }
                else {
                    value--;
                    txtAttamp.setText("Remaining attemps "+value);

                    if (value==0){
                        btnLogin.setEnabled(false);
                    }
                }

            }
        });
    }
}
