package com.codecademy.aplicatielicenta;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    LoginButton facebookLinkButton;
    TextView welcomeText, facebookUsername;
    ImageView facebookImage;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeText = findViewById(R.id.welcome_text);
        facebookUsername = findViewById(R.id.facebook_user_name);
        facebookImage = findViewById(R.id.facebook_image);
        facebookLinkButton = findViewById(R.id.facebook_link_button);

        callbackManager = CallbackManager.Factory.create();

        facebookLinkButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                facebookUsername.setText("User ID: " + loginResult.getAccessToken().getUserId());
                String imageURL = "https://graph.facebook.com/" + loginResult.getAccessToken().getUserId() + "/picture?return_ssl_resources=1";
                Picasso.get().load(imageURL).into(facebookImage);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}