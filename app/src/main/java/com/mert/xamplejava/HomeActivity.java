package com.mert.xamplejava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class HomeActivity extends AppCompatActivity {
    Button btnModeChanger;
    boolean themeLight = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnModeChanger = findViewById(R.id.btnModeChanger);
        btnModeChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(themeLight){
                    themeLight = false;
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    themeLight = true;
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }
}
