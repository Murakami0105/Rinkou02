package com.example.rinkou02;

public class Hand {
    public String name;
    private Hand strongerThan;

    //コンストラクタ
    Hand(String name){
        this.name = name;
    }

    //強弱判定の設定
    public void setStrongerThan(Hand h){
        this.strongerThan = h;
    }

    //勝敗判定(0：あいこ　1：勝ち　-1：負け)
    public int judge(Hand h){
        if(h == this)
            return 0;
        else if(this.strongerThan == h)
            return 1;
        else
            return -1;
    }

    public String toString(){
        return name;
    }
}
