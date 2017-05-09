package com.example.rinkou02;

import android.content.res.Resources;
import java.util.Random;

public class Janken {
    Resources res;
    Hand[] hands = new Hand[3];
    int you;
    int cpu_h;
    int result;

    //コンストラクタ
    Janken(Resources res , int you){
        this.res = res;
        this.you = you;
        Hand r = new Hand(res.getString(R.string.btn01));
        Hand s = new Hand(res.getString(R.string.btn02));
        Hand p = new Hand(res.getString(R.string.btn03));
        hands[0] = r;
        hands[1] = s;
        hands[2] = p;
        r.setStrongerThan(s);
        s.setStrongerThan(p);
        p.setStrongerThan(r);

        cpu_h = new Random().nextInt(hands.length);
        result = hands[you].judge(hands[cpu_h]);
    }

    //結果の取得(文字列生成)
    public String toStringResult() {
        String result_s = "";
        if(result == 0) result_s = res.getString(R.string.result_draw);
        if (result > 0) result_s = res.getString(R.string.result_win);
        if (result < 0) result_s = res.getString(R.string.result_lose);

        return res.getString(R.string.text_1,
                hands[you].toString(),
                hands[cpu_h].toString(),
                result_s);
    }
    public int getResultId(){
        return result;
    }
}
