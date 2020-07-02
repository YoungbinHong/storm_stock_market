package com.example.stormstockmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Help4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help4);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        if (action == MotionEvent.ACTION_DOWN) {
            Intent intent = new Intent(getApplicationContext(), Help5Activity.class);

            startActivity(intent);  // 다음 화면으로 넘어간다.
        }

        return super.onTouchEvent(event);
    }
}
