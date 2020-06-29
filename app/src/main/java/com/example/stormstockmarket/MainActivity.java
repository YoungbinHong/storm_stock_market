package com.example.stormstockmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Random Thread
        class NewRunnable implements Runnable {
            @Override
            public void run() {
                while (true) {

                    double randomDouble1 = Math.random();
                    int randomInt1 = (int)(randomDouble1*100)+1;

                    final TextView 단절 = (TextView) findViewById(R.id.단절통신현재가);
                    단절.setText(randomInt1+"");

                    try {
                        Thread.sleep(5000) ;
                    } catch (Exception e) {
                        e.printStackTrace() ;
                    }
                }
            }
        }

        NewRunnable nr = new NewRunnable() ;
        Thread t = new Thread(nr) ;
        t.start() ;


    }

}