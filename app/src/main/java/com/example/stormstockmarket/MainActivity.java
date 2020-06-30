package com.example.stormstockmarket;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Thread
        class Runnable1 implements Runnable {
            @Override
            public void run() {

                ArrayList<Integer> 단절 = new ArrayList<Integer>();
                ArrayList<Integer> 사망 = new ArrayList<Integer>();
                ArrayList<Integer> 석기 = new ArrayList<Integer>();
                ArrayList<Integer> 지진 = new ArrayList<Integer>();
                ArrayList<Integer> 파산 = new ArrayList<Integer>();

                while (true) {

                    // 단절통신 random 값 생성
                    double randomDouble1 = Math.random();
                    int randomInt1 = (int)(randomDouble1*100)+1;

                    final TextView 단절통신현재가 = (TextView) findViewById(R.id.단절통신현재가);
                    단절통신현재가.setText(randomInt1+"");

                    // 사망생명 random 값 생성
                    double randomDouble2 = Math.random();
                    int randomInt2 = (int)(randomDouble2*100)+1;

                    final TextView 사망생명현재가 = (TextView) findViewById(R.id.사망생명현재가);
                    사망생명현재가.setText(randomInt2+"");

                    // 석기전자 random 값 생성
                    double randomDouble3 = Math.random();
                    int randomInt3 = (int)(randomDouble3*100)+1;

                    final TextView 석기전자현재가 = (TextView) findViewById(R.id.석기전자현재가);
                    석기전자현재가.setText(randomInt3+"");

                    // 지진건설 random 값 생성
                    double randomDouble4 = Math.random();
                    int randomInt4 = (int)(randomDouble4*100)+1;

                    final TextView 지진건설현재가 = (TextView) findViewById(R.id.지진건설현재가);
                    지진건설현재가.setText(randomInt4+"");

                    // 파산은행 random 값 생성
                    double randomDouble5 = Math.random();
                    int randomInt5 = (int)(randomDouble5*100)+1;

                    final TextView 파산은행현재가 = (TextView) findViewById(R.id.파산은행현재가);
                    파산은행현재가.setText(randomInt5+"");

                    try {
                        Thread.sleep(3000) ;
                    } catch (Exception e) {
                        e.printStackTrace() ;
                    }

                    final TextView 단절통신이전가 = (TextView) findViewById(R.id.단절통신이전가);
                    단절통신이전가.setText(randomInt1+"");

                    final TextView 사망생명이전가 = (TextView) findViewById(R.id.사망생명이전가);
                    사망생명이전가.setText(randomInt2+"");

                    final TextView 석기전자이전가 = (TextView) findViewById(R.id.석기전자이전가);
                    석기전자이전가.setText(randomInt3+"");

                    final TextView 지진건설이전가 = (TextView) findViewById(R.id.지진건설이전가);
                    지진건설이전가.setText(randomInt4+"");

                    final TextView 파산은행이전가 = (TextView) findViewById(R.id.파산은행이전가);
                    파산은행이전가.setText(randomInt5+"");


                }
            }
        }

        // 스레드 1 생성
        Runnable1 thread1 = new Runnable1() ;
        Thread t1 = new Thread(thread1) ;

        //스레드 실행
        t1.start() ;


    }

}