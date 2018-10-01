package com.example.vlad.asl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

public class info extends AppCompatActivity {
    RatingBar ratingBar;
    Button submit;
    ImageView qr_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(info.this,
                      base.class);
                String rating = String.valueOf(ratingBar.getRating());
                Double rate = Double.valueOf(rating);
                Bundle bundle = new Bundle();
                bundle.putDouble("rating", rate);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        //

    }




}
