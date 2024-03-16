package com.mayank.news_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

         //Thread is used to provide dealy
        Thread td=new Thread()
        {
            @Override
            public void run() {
                try {
                    // duration of dealy
                    sleep(5000);
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                finally
                {
                    Intent i=new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        td.start();
    }
}