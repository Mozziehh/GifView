package com.example.wubagifview.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wubagifview.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gifDrawable = (Button) findViewById(R.id.gif_drawable);
        gifDrawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转至gif-drawable
                GifDrawableActivity.startActivity(getApplicationContext());
            }
        });

        Button gifFresco = (Button) findViewById(R.id.gif_fresco);
        gifFresco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转至gif-fresco
                GifFrescoActivity.startActivity(getApplicationContext());
            }
        });
    }

}
