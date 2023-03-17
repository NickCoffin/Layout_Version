package com.example.layout_version;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Policy extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.policy);

        ImageView exit;
        exit = (ImageView) findViewById(R.id.gotit);
        exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Policy.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
