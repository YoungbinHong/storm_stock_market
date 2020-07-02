package com.example.stormstockmarket;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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

    // 예수금 및 잔고
    int account = 10000;                                                        // 예수금 (account)
    int aup1 = 0; int aup2 = 0; int aup3 = 0; int aup4 = 0; int aup5 = 0;       // 평균단가 (average unit price)
    int qua1 = 0; int qua2 = 0; int qua3 = 0; int qua4 = 0; int qua5 = 0;       // 수량 (quantity)
    int pm1 = 0; int pm2 = 0; int pm3 = 0; int pm4 = 0; int pm5 = 0;            // 매입금액 (purchase amount)
    int tv1 = 0; int tv2 = 0; int tv3 = 0; int tv4 = 0; int tv5 = 0;            // 평가금액 (total valuation)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 온갖 요소들의 ID 설정
        final TextView 단절통신현재가 = (TextView) findViewById(R.id.단절통신현재가);
        final TextView 사망생명현재가 = (TextView) findViewById(R.id.사망생명현재가);
        final TextView 석기전자현재가 = (TextView) findViewById(R.id.석기전자현재가);
        final TextView 지진건설현재가 = (TextView) findViewById(R.id.지진건설현재가);
        final TextView 파산은행현재가 = (TextView) findViewById(R.id.파산은행현재가);

        final TextView 단절통신이전가 = (TextView) findViewById(R.id.단절통신이전가);
        final TextView 사망생명이전가 = (TextView) findViewById(R.id.사망생명이전가);
        final TextView 석기전자이전가 = (TextView) findViewById(R.id.석기전자이전가);
        final TextView 지진건설이전가 = (TextView) findViewById(R.id.지진건설이전가);
        final TextView 파산은행이전가 = (TextView) findViewById(R.id.파산은행이전가);

        final TextView 단절통신등락률 = (TextView) findViewById(R.id.단절통신등락률);
        final TextView 사망생명등락률 = (TextView) findViewById(R.id.사망생명등락률);
        final TextView 석기전자등락률 = (TextView) findViewById(R.id.석기전자등락률);
        final TextView 지진건설등락률 = (TextView) findViewById(R.id.지진건설등락률);
        final TextView 파산은행등락률 = (TextView) findViewById(R.id.파산은행등락률);

        final TextView 단절통신평균단가 = (TextView) findViewById(R.id.단절통신평균단가);
        final TextView 사망생명평균단가 = (TextView) findViewById(R.id.사망생명평균단가);
        final TextView 석기전자평균단가 = (TextView) findViewById(R.id.석기전자평균단가);
        final TextView 지진건설평균단가 = (TextView) findViewById(R.id.지진건설평균단가);
        final TextView 파산은행평균단가 = (TextView) findViewById(R.id.파산은행평균단가);

        final TextView 단절통신수량 = (TextView) findViewById(R.id.단절통신수량);
        final TextView 사망생명수량 = (TextView) findViewById(R.id.사망생명수량);
        final TextView 석기전자수량 = (TextView) findViewById(R.id.석기전자수량);
        final TextView 지진건설수량 = (TextView) findViewById(R.id.지진건설수량);
        final TextView 파산은행수량 = (TextView) findViewById(R.id.파산은행수량);

        final TextView 단절통신매입금액 = (TextView) findViewById(R.id.단절통신매입금액);
        final TextView 사망생명매입금액 = (TextView) findViewById(R.id.사망생명매입금액);
        final TextView 석기전자매입금액 = (TextView) findViewById(R.id.석기전자매입금액);
        final TextView 지진건설매입금액 = (TextView) findViewById(R.id.지진건설매입금액);
        final TextView 파산은행매입금액 = (TextView) findViewById(R.id.파산은행매입금액);

        final TextView 단절통신평가금액 = (TextView) findViewById(R.id.단절통신평가금액);
        final TextView 사망생명평가금액 = (TextView) findViewById(R.id.사망생명평가금액);
        final TextView 석기전자평가금액 = (TextView) findViewById(R.id.석기전자평가금액);
        final TextView 지진건설평가금액 = (TextView) findViewById(R.id.지진건설평가금액);
        final TextView 파산은행평가금액 = (TextView) findViewById(R.id.파산은행평가금액);

        final TextView 예수금 = (TextView) findViewById(R.id.예수금);

        // 스레드1
        class Thread1 extends Thread {
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

                    단절통신현재가.setText(array1[0]+"");
                    사망생명현재가.setText(array2[0]+"");
                    석기전자현재가.setText(array3[0]+"");
                    지진건설현재가.setText(array4[0]+"");
                    파산은행현재가.setText(array5[0]+"");

                    단절통신이전가.setText(array1[1]+"");
                    사망생명이전가.setText(array2[1]+"");
                    석기전자이전가.setText(array3[1]+"");
                    지진건설이전가.setText(array4[1]+"");
                    파산은행이전가.setText(array5[1]+"");

                    if(hasNoZero(array1)){
                        flu1 = array1[0]-array1[1];
                    }
                    else{flu1 = 0;}

                    if(hasNoZero(array2)){
                        flu2 = array2[0]-array2[1];
                    }
                    else{flu2 = 0;}

                    if(hasNoZero(array3)){
                        flu3 = array3[0]-array3[1];
                    }
                    else{flu3 = 0;}

                    if(hasNoZero(array4)){
                        flu4 = array4[0]-array4[1];
                    }
                    else{flu4 = 0;}

                    if(hasNoZero(array5)){
                        flu5 = array5[0]-array5[1];
                    }
                    else{flu5 = 0;}

                    if(flu1>0) {
                        단절통신등락률.setText("+"+flu1+"");
                        단절통신등락률.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(flu1==0){
                        단절통신등락률.setText(flu1+"");
                        단절통신등락률.setTextColor(Color.parseColor("#000000"));
                    }
                    if(flu1<0){
                        단절통신등락률.setText(flu1+"");
                        단절통신등락률.setTextColor(Color.parseColor("#0000FF"));
                    }

                    if(flu2>0) {
                        사망생명등락률.setText("+"+flu2+"");
                        사망생명등락률.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(flu2==0){
                        사망생명등락률.setText(flu2+"");
                        사망생명등락률.setTextColor(Color.parseColor("#000000"));
                    }
                    if(flu2<0){
                        사망생명등락률.setText(flu2+"");
                        사망생명등락률.setTextColor(Color.parseColor("#0000FF"));
                    }

                    if(flu3>0) {
                        석기전자등락률.setText("+"+flu3+"");
                        석기전자등락률.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(flu3==0){
                        석기전자등락률.setText(flu3+"");
                        석기전자등락률.setTextColor(Color.parseColor("#000000"));
                    }
                    if(flu3<0){
                        석기전자등락률.setText(flu3+"");
                        석기전자등락률.setTextColor(Color.parseColor("#0000FF"));
                    }

                    if(flu4>0) {
                        지진건설등락률.setText("+"+flu4+"");
                        지진건설등락률.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(flu4==0){
                        지진건설등락률.setText(flu4+"");
                        지진건설등락률.setTextColor(Color.parseColor("#000000"));
                    }
                    if(flu4<0){
                        지진건설등락률.setText(flu4+"");
                        지진건설등락률.setTextColor(Color.parseColor("#0000FF"));
                    }

                    if(flu5>0) {
                        파산은행등락률.setText("+"+flu5+"");
                        파산은행등락률.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(flu5==0){
                        파산은행등락률.setText(flu5+"");
                        파산은행등락률.setTextColor(Color.parseColor("#000000"));
                    }
                    if(flu5<0){
                        파산은행등락률.setText(flu5+"");
                        파산은행등락률.setTextColor(Color.parseColor("#0000FF"));
                    }

                    try {
                        Thread.sleep(10000) ;
                    } catch (Exception e) {
                        e.printStackTrace() ;
                    }

                }
            }
        }

        class Thread2 extends Thread{
            @Override
            public void run(){
                while(true){

                    tv1 = array1[0]*qua1;
                    tv2 = array2[0]*qua2;
                    tv3 = array3[0]*qua3;
                    tv4 = array4[0]*qua4;
                    tv5 = array5[0]*qua5;

                    단절통신평균단가.setText(aup1+"");
                    사망생명평균단가.setText(aup2+"");
                    석기전자평균단가.setText(aup3+"");
                    지진건설평균단가.setText(aup4+"");
                    파산은행평균단가.setText(aup5+"");

                    단절통신수량.setText(qua1+"");
                    사망생명수량.setText(qua2+"");
                    석기전자수량.setText(qua3+"");
                    지진건설수량.setText(qua4+"");
                    파산은행수량.setText(qua5+"");

                    단절통신매입금액.setText(pm1+"");
                    사망생명매입금액.setText(pm2+"");
                    석기전자매입금액.setText(pm3+"");
                    지진건설매입금액.setText(pm4+"");
                    파산은행매입금액.setText(pm5+"");

                    단절통신평가금액.setText(tv1+"");
                    사망생명평가금액.setText(tv2+"");
                    석기전자평가금액.setText(tv3+"");
                    지진건설평가금액.setText(tv4+"");
                    파산은행평가금액.setText(tv5+"");

                    if(tv1>pm1){
                        단절통신평가금액.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(tv1==pm1){
                        단절통신평가금액.setTextColor(Color.parseColor("#000000"));
                    }
                    if(tv1<pm1){
                        단절통신평가금액.setTextColor(Color.parseColor("#0000FF"));
                    }

                    if(tv2>pm2){
                        사망생명평가금액.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(tv2==pm2){
                        사망생명평가금액.setTextColor(Color.parseColor("#000000"));
                    }
                    if(tv2<pm2){
                        사망생명평가금액.setTextColor(Color.parseColor("#0000FF"));
                    }

                    if(tv3>pm3){
                        석기전자평가금액.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(tv3==pm3){
                        석기전자평가금액.setTextColor(Color.parseColor("#000000"));
                    }
                    if(tv3<pm3){
                        석기전자평가금액.setTextColor(Color.parseColor("#0000FF"));
                    }

                    if(tv4>pm4){
                        지진건설평가금액.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(tv4==pm4){
                        지진건설평가금액.setTextColor(Color.parseColor("#000000"));
                    }
                    if(tv4<pm4){
                        지진건설평가금액.setTextColor(Color.parseColor("#0000FF"));
                    }

                    if(tv5>pm5){
                        파산은행평가금액.setTextColor(Color.parseColor("#FF0000"));
                    }
                    if(tv5==pm5){
                        파산은행평가금액.setTextColor(Color.parseColor("#000000"));
                    }
                    if(tv5<pm5){
                        파산은행평가금액.setTextColor(Color.parseColor("#0000FF"));
                    }


                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        // 스레드3
        class Thread3 extends Thread {
            @Override
            public void run(){
                while (true){
                    예수금.setText("나의 예수금 : "+account+"");
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // 스레드 1 생성 및 실행
        Thread thread1 = new Thread1();
        thread1.start();

        // 스레드 2 생성 및 실행
        Thread thread2 = new Thread2();
        thread2.start();

        // 스레드 3 생성 및 실행
        Thread thread3 = new Thread3();
        thread3.start();

    }

    // 매수 주문
    public void onClickHandler1(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("단절통신 매수 주문");
        builder.setMessage("\n현재 가격 : " + array1[0]+"\n\n주문 수량을 아래에 입력하세요.\n");

        final EditText editText = new EditText(MainActivity.this);
        editText.setText("");
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(editText);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String stringQua = editText.getText().toString();
                int intQua = Integer.parseInt(stringQua);
                int total = intQua*array1[0];

                if(total>account){
                    Toast.makeText(getApplicationContext(), "예수금 잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    account -= total;
                    qua1 += intQua;
                    pm1 += total;
                    aup1 = pm1/qua1;

                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(300);
                    Toast.makeText(getApplicationContext(), "매수 주문이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "주문이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void onClickHandler2(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("사망생명 매수 주문");
        builder.setMessage("\n현재 가격 : " + array2[0]+"\n\n주문 수량을 아래에 입력하세요.\n");

        final EditText editText = new EditText(MainActivity.this);
        editText.setText("");
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(editText);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String stringQua = editText.getText().toString();
                int intQua = Integer.parseInt(stringQua);
                int total = intQua*array2[0];

                if(total>account){
                    Toast.makeText(getApplicationContext(), "예수금 잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    account -= total;
                    qua2 += intQua;
                    pm2 += total;
                    aup2 = pm2/qua2;

                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(300);
                    Toast.makeText(getApplicationContext(), "매수 주문이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "주문이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void onClickHandler3(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("석기전자 매수 주문");
        builder.setMessage("\n현재 가격 : " + array3[0]+"\n\n주문 수량을 아래에 입력하세요.\n");

        final EditText editText = new EditText(MainActivity.this);
        editText.setText("");
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(editText);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String stringQua = editText.getText().toString();
                int intQua = Integer.parseInt(stringQua);
                int total = intQua*array3[0];

                if(total>account){
                    Toast.makeText(getApplicationContext(), "예수금 잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    account -= total;
                    qua3 += intQua;
                    pm3 += total;
                    aup3 = pm3/qua3;

                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(300);
                    Toast.makeText(getApplicationContext(), "매수 주문이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "주문이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void onClickHandler4(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("지진건설 매수 주문");
        builder.setMessage("\n현재 가격 : " + array4[0]+"\n\n주문 수량을 아래에 입력하세요.\n");

        final EditText editText = new EditText(MainActivity.this);
        editText.setText("");
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(editText);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String stringQua = editText.getText().toString();
                int intQua = Integer.parseInt(stringQua);
                int total = intQua*array4[0];

                if(total>account){
                    Toast.makeText(getApplicationContext(), "예수금 잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    account -= total;
                    qua4 += intQua;
                    pm4 += total;
                    aup4 = pm4/qua4;

                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(300);
                    Toast.makeText(getApplicationContext(), "매수 주문이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "주문이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void onClickHandler5(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("사망생명 매수 주문");
        builder.setMessage("\n현재 가격 : " + array5[0]+"\n\n주문 수량을 아래에 입력하세요.\n");

        final EditText editText = new EditText(MainActivity.this);
        editText.setText("");
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(editText);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String stringQua = editText.getText().toString();
                int intQua = Integer.parseInt(stringQua);
                int total = intQua*array5[0];

                if(total>account){
                    Toast.makeText(getApplicationContext(), "예수금 잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    account -= total;
                    qua5 += intQua;
                    pm5 += total;
                    aup5 = pm5/qua5;

                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(300);
                    Toast.makeText(getApplicationContext(), "매수 주문이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "주문이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // 매도 주문
    public void onClickHandler6(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("단절통신 매도 주문");
        builder.setMessage("\n매도하시겠습니까?\n");

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(qua1==0){
                    Toast.makeText(getApplicationContext(), "주문 가능 수량이 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    account += tv1;
                    aup1 = 0;
                    qua1 = 0;
                    pm1 = 0;
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(300);
                    Toast.makeText(getApplicationContext(), "매도 주문이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "주문이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void onClickHandler7(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("사망생명 매도 주문");
        builder.setMessage("\n매도하시겠습니까?\n");

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(qua2==0){
                    Toast.makeText(getApplicationContext(), "주문 가능 수량이 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    account += tv2;
                    aup2 = 0;
                    qua2 = 0;
                    pm2 = 0;
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(300);
                    Toast.makeText(getApplicationContext(), "매도 주문이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "주문이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void onClickHandler8(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("석기전자 매도 주문");
        builder.setMessage("\n매도하시겠습니까?\n");

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(qua3==0){
                    Toast.makeText(getApplicationContext(), "주문 가능 수량이 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    account += tv3;
                    aup3 = 0;
                    qua3 = 0;
                    pm3 = 0;
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(300);
                    Toast.makeText(getApplicationContext(), "매도 주문이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "주문이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void onClickHandler9(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("지진건설 매도 주문");
        builder.setMessage("\n매도하시겠습니까?\n");

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(qua4==0){
                    Toast.makeText(getApplicationContext(), "주문 가능 수량이 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    account += tv4;
                    aup4 = 0;
                    qua4 = 0;
                    pm4 = 0;
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(300);
                    Toast.makeText(getApplicationContext(), "매도 주문이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "주문이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void onClickHandler10(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("파산은행 매도 주문");
        builder.setMessage("\n매도하시겠습니까?\n");

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(qua5==0){
                    Toast.makeText(getApplicationContext(), "주문 가능 수량이 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    account += tv5;
                    aup5 = 0;
                    qua5 = 0;
                    pm5 = 0;
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(300);
                    Toast.makeText(getApplicationContext(), "매도 주문이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "주문이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}