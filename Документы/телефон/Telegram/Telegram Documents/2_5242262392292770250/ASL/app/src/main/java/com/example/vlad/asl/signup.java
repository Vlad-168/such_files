package com.example.vlad.asl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.io.SerializablePermission;
import java.util.ArrayList;
import java.util.Arrays;

public class signup extends AppCompatActivity {

    TextView textView2;
    EditText newlog, newpass2, newpass1;
    Button btnin;
    static EditText gmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final ArrayList<String> userPpassword = loadArrayList("userPpassword"); // загружаем
        final ArrayList<String> userLogin = loadArrayList("userLogin"); // загружаем



        textView2 = (TextView) findViewById(R.id.textView2);
        newlog = (EditText) findViewById(R.id.newlog);
        newpass1 = (EditText) findViewById(R.id.newpass1);
        newpass2 = (EditText) findViewById(R.id.newpass2);
        gmail = (EditText) findViewById(R.id.gmail);
        btnin = (Button) findViewById(R.id.btnin);

        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newlog.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Введите Логин", Toast.LENGTH_LONG).show();
                }
                else if (newpass1.getText().toString().equals("") || newpass2.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Введите Пароль", Toast.LENGTH_LONG).show();
                    }
                else if (!newpass1.getText().toString().equals(newpass2.getText().toString())){
                            Toast.makeText(getApplicationContext(), "Пароли не совпадают", Toast.LENGTH_LONG).show();
                        }
                else
                {
                    int indexsignup = userLogin.indexOf(newlog.getText().toString());
                    if (indexsignup>=0){
                        Toast.makeText(getApplicationContext(), "Такой аккаун существует", Toast.LENGTH_LONG).show();
                    }
                    else{
                        userPpassword.add(0, newpass1.getText().toString());
                        userLogin.add(0, newlog.getText().toString());
                        saveArrayList("userPpassword", userPpassword); // сохраняем
                        saveArrayList("userLogin", userLogin); // сохраняем
                        //Toast.makeText(getApplicationContext(), Integer.toString(userLogin.indexOf(newlog.getText().toString())), Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(), Integer.toString(userPpassword.indexOf(newpass1.getText().toString())), Toast.LENGTH_LONG).show();
                        Intent newregintent = new Intent(signup.this,
                                base.class);
                        startActivity(newregintent);
                    }
                }

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
