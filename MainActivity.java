package com.example.rinkou02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int select = 0;
    Button[] btn = new Button[4];
    TextView txt01;
    TextView txt02;

    int ct_round = 0;
    int ct_win = 0;
    int ct_lose = 0;
    int ct_draw = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //リソースIDの設定
        btn[0] = (Button)findViewById(R.id.button01);
        btn[1] = (Button)findViewById(R.id.button02);
        btn[2] = (Button)findViewById(R.id.button03);
        btn[3] = (Button)findViewById(R.id.button04);
        txt01 = (TextView)findViewById(R.id.text01);
        txt02 = (TextView)findViewById(R.id.text02);

        //Listenerの設定
        for (int i=0 ; i< btn.length ; i++)
            btn[i].setOnClickListener(this);

        //TextViewの初期化
        txt01.setText(getString(R.string.init_txt));
        txt02.setText(getString(R.string.text_2, 0, 0, 0, 0));

    }

    @Override
    public void onClick(View view) {
        //ボタンを押したときの動作
        switch (view.getId()){
            case R.id.button01:{
                select = 0;
                break;
            }
            case R.id.button02:{
                select = 1;
                break;
            }
            case R.id.button03:{
                select = 2;
                break;
            }
            case R.id.button04:{
                select = -1;
                break;
            }
        }

        //更新
        if(select >= 0){
            Janken j = new Janken(getResources(),select);
            ct_round++;
            if (j.getResultId() == 0) ct_draw++;
            if (j.getResultId() >  0) ct_win++;
            if (j.getResultId() <  0) ct_lose++;

            txt01.setText(j.toStringResult());
        }
        else{
            ct_round = 0;
            ct_win = 0;
            ct_lose = 0;
            ct_draw = 0;

            txt01.setText(getString(R.string.init_txt));
        }

        //表示更新
        txt02.setText(getString(R.string.text_2, ct_round, ct_win, ct_lose, ct_draw));
    }
}
