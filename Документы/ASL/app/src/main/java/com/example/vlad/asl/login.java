package com.example.vlad.asl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;

public class login extends AppCompatActivity {
    Button btnlog, btnreg;
    static EditText pass, log;
    TextView textView;
    ImageView imageView2, imageView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final ArrayList<String> userPpassword = loadArrayList("userPpassword"); // загружаем
        final ArrayList<String> userLogin = loadArrayList("userLogin"); // загружаем

        btnlog = (Button) findViewById(R.id.btnlog);
        btnreg = (Button) findViewById(R.id.btnreg);
        pass = (EditText) findViewById(R.id.pass);
        log = (EditText) findViewById(R.id.log);
        textView = (TextView) findViewById(R.id.textView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (log.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Вы не ввели Логин", Toast.LENGTH_LONG).show();
                }
                else {
                    if (pass.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Вы не ввели Пароль", Toast.LENGTH_LONG).show();
                    }
                    else {
                        int index = userLogin.indexOf(log.getText().toString());
                        if (index >= 0) {
                            if (pass.getText().toString().equals(userPpassword.get(index))) {
                                Intent success = new Intent(login.this,
                                        base.class);
                                startActivity(success);
                            }
                        }
                            else {
                                Toast.makeText(getApplicationContext(), "Вы не зарегистрированы", Toast.LENGTH_LONG).show();
                        }

                    }
                }


            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regintent = new Intent(login.this,
                        signup.class);
                startActivity(regintent);
            }
        });

    }
    // сохраняем
    private void saveArrayList(String name, ArrayList<String> list) {
        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s).append("<s>");
        if (list.size() > 0) sb.delete(sb.length() - 3, sb.length());
        editor.putString(name, sb.toString()).apply();
    }
    // загружаем
    private ArrayList<String> loadArrayList(String name) {
        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String[] strings = prefs.getString(name, "").split("<s>");
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(strings));
        return list;
    }
}


////////////////////////////////////////////

