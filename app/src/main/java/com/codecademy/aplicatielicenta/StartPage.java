package com.codecademy.aplicatielicenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


public class StartPage extends AppCompatActivity {

    ImageView imageViewStartPage;
    Button buttonLogin, buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        imageViewStartPage = findViewById(R.id.imageView);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignUp = findViewById(R.id.buttonSingup);

        imageViewStartPage.setImageResource(R.mipmap.ic_launcher_foreground);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
                finish();
            }
        });

    }
}