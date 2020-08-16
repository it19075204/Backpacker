package com.dilmikaweerasinghe.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;
    private TextView Register;
    private Button Camp1;
    private Button Camp2;
    private Button Camp3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);
        Register = (TextView)findViewById(R.id.tvRegister);
        Camp1 = (Button)findViewById(R.id.cg1);
        Camp2 = (Button)findViewById(R.id.cg2);
        Camp3 = (Button)findViewById(R.id.cg3);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
            }
        });

        Camp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CampingGear.class));
            }
        });

        Camp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CampingGear2.class));
            }
        });

        Camp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CampingGear3.class));
            }
        });





    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("1234")) ){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("No of attempts remaining: "+ String.valueOf(counter));

            if(counter == 0)
            {
                Login.setEnabled(false);
            }
        }
    }

}