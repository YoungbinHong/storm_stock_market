package com.example.stormstockmarket;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 가격용 배열
    int array1[] = {0,0};
    int array2[] = {0,0};
    int array3[] = {0,0};
    int array4[] = {0,0};
    int array5[] = {0,0};

    // 가격 진행 함수
    void push(int [] array, int nextValue){
        array[1] = array[0];
        array[0] = nextValue;
    }

    // 등락률용 함수 및 변수
    boolean hasNoZero(int [] array){
        return (array[0]*array[1]==0)?false:true;
    }

    double flu1, flu2, flu3, flu4, flu5; // 등락률
    boolean sign1, sign2, sign3, sign4, sign5; // 등락률 부호

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 스레드 클래스
        class Runnable1 implements Runnable {
            @Override
            public void run() {

                while (true) {

                    double randomDouble1 = Math.random();
                    int randomInt1 = (int)(randomDouble1*100)+1;
                    double randomDouble2 = Math.random();
                    int randomInt2 = (int)(randomDouble2*100)+1;
                    double randomDouble3 = Math.random();
                    int randomInt3 = (int)(randomDouble3*100)+1;
                    double randomDouble4 = Math.random();
                    int randomInt4 = (int)(randomDouble4*100)+1;
                    double randomDouble5 = Math.random();
                    int randomInt5 = (int)(randomDouble5*100)+1;

                    push(array1,randomInt1);
                    push(array2,randomInt2);
                    push(array3,randomInt3);
                    push(array4,randomInt4);
                    push(array5,randomInt5);

                    final TextView 단절통신현재가 = (TextView) findViewById(R.id.단절통신현재가);
                    단절통신현재가.setText(array1[0]+"");

                    final TextView 사망생명현재가 = (TextView) findViewById(R.id.사망생명현재가);
                    사망생명현재가.setText(array2[0]+"");

                    final TextView 석기전자현재가 = (TextView) findViewById(R.id.석기전자현재가);
                    석기전자현재가.setText(array3[0]+"");

                    final TextView 지진건설현재가 = (TextView) findViewById(R.id.지진건설현재가);
                    지진건설현재가.setText(array4[0]+"");

                    final TextView 파산은행현재가 = (TextView) findViewById(R.id.파산은행현재가);
                    파산은행현재가.setText(array5[0]+"");

                    final TextView 단절통신이전가 = (TextView) findViewById(R.id.단절통신이전가);
                    단절통신이전가.setText(array1[1]+"");

                    final TextView 사망생명이전가 = (TextView) findViewById(R.id.사망생명이전가);
                    사망생명이전가.setText(array2[1]+"");

                    final TextView 석기전자이전가 = (TextView) findViewById(R.id.석기전자이전가);
                    석기전자이전가.setText(array3[1]+"");

                    final TextView 지진건설이전가 = (TextView) findViewById(R.id.지진건설이전가);
                    지진건설이전가.setText(array4[1]+"");

                    final TextView 파산은행이전가 = (TextView) findViewById(R.id.파산은행이전가);
                    파산은행이전가.setText(array5[1]+"");

                    if(hasNoZero(array1)){
                        if(array1[0]>array1[1]){
                            sign1 = true;
                        }else{sign1 = false;}
                        flu1 = Math.abs((array1[0]-array1[1]))/array1[1]*100;
                    }
                    else{flu1 = 0;}

                    if(hasNoZero(array2)){
                        if(array2[0]>array2[1]){
                            sign2 = true;
                        }else{sign2 = false;}
                        flu2 = Math.abs((array2[0]-array2[1]))/array2[1]*100;
                    }
                    else{flu2 = 0;}

                    if(hasNoZero(array3)){
                        if(array3[0]>array3[1]){
                            sign3 = true;
                        }else{sign3 = false;}
                        flu3 = Math.abs((array3[0]-array3[1]))/array3[1]*100;
                    }
                    else{flu3 = 0;}

                    if(hasNoZero(array4)){
                        if(array4[0]>array4[1]){
                            sign4 = true;
                        }else{sign4 = false;}
                        flu4 = Math.abs((array4[0]-array4[1]))/array4[1]*100;
                    }
                    else{flu4 = 0;}

                    if(hasNoZero(array5)){
                        if(array5[0]>array5[1]){
                            sign5 = true;
                        }else{sign5 = false;}
                        flu5 = Math.abs((array5[0]-array5[1]))/array5[1]*100;
                    }
                    else{flu5 = 0;}

                    final TextView 단절통신등락률 = (TextView) findViewById(R.id.단절통신등락률);
                    final TextView 사망생명등락률 = (TextView) findViewById(R.id.사망생명등락률);
                    final TextView 석기전자등락률 = (TextView) findViewById(R.id.석기전자등락률);
                    final TextView 지진건설등락률 = (TextView) findViewById(R.id.지진건설등락률);
                    final TextView 파산은행등락률 = (TextView) findViewById(R.id.파산은행등락률);

                    if(sign1==true) {
                        단절통신등락률.setText("+"+flu1+"");
                        단절통신등락률.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(flu1==0){
                        단절통신등락률.setText(flu1+"");
                        단절통신등락률.setTextColor(Color.parseColor("#000000"));
                    }
                    if(sign1==false){
                        단절통신등락률.setText("-"+flu1+"");
                        단절통신등락률.setTextColor(Color.parseColor("#0000FF"));
                    }

                    if(sign2==true) {
                        사망생명등락률.setText("+"+flu2+"");
                        사망생명등락률.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(flu2==0){
                        사망생명등락률.setText(flu2+"");
                        사망생명등락률.setTextColor(Color.parseColor("#000000"));
                    }
                    if(sign2==false){
                        사망생명등락률.setText("-"+flu2+"");
                        사망생명등락률.setTextColor(Color.parseColor("#0000FF"));
                    }

                    if(sign3==true) {
                        석기전자등락률.setText("+"+flu3+"");
                        석기전자등락률.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(flu3==0){
                        석기전자등락률.setText(flu3+"");
                        석기전자등락률.setTextColor(Color.parseColor("#000000"));
                    }
                    if(sign3==false){
                        석기전자등락률.setText("-"+flu3+"");
                        석기전자등락률.setTextColor(Color.parseColor("#0000FF"));
                    }

                    if(sign4==true) {
                        지진건설등락률.setText("+"+flu4+"");
                        지진건설등락률.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(flu4==0){
                        지진건설등락률.setText(flu4+"");
                        지진건설등락률.setTextColor(Color.parseColor("#000000"));
                    }
                    if(sign4==false){
                        지진건설등락률.setText("-"+flu4+"");
                        지진건설등락률.setTextColor(Color.parseColor("#0000FF"));
                    }

                    if(sign5==true) {
                        파산은행등락률.setText("+"+flu5+"");
                        파산은행등락률.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(flu5==0){
                        파산은행등락률.setText(flu5+"");
                        파산은행등락률.setTextColor(Color.parseColor("#000000"));
                    }
                    if(sign5==false){
                        파산은행등락률.setText("-"+flu5+"");
                        파산은행등락률.setTextColor(Color.parseColor("#0000FF"));
                    }

                    try {
                        Thread.sleep(3000) ;
                    } catch (Exception e) {
                        e.printStackTrace() ;
                    }

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