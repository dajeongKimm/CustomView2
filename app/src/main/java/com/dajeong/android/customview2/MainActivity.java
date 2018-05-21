package com.dajeong.android.customview2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    FrameLayout frameLayout;
    CustomView stage; //게임이 보여지는 영역

    float deviceWidth = 0;
    //float deciveHeight = 0;
    float unit = 0;
    float player_size = 0;

    float play_x = 0;
    float play_y =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        frameLayout = findViewById(R.id.frameLayout);
        stage = new CustomView(this );
        frameLayout.addView(stage); //프레임레이아웃안에 스테이지(커스텀) 넣어줌
    }

    public void init() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        deviceWidth = metrics.widthPixels ; //넓이 좌표 가져옴
        unit = deviceWidth/10; //움직일 칸의 수
        player_size =unit; //결국 동그라이믜 크기는 unit이 됨.

        play_x = deviceWidth/2;
        play_y = deviceWidth/2;
    }

    public void up(View view){
        play_y = play_y-unit;
        stage.invalidate(); //이 함수를 호출해야 화면에 그려진다.

    }
    public void down(View view){
        play_y = play_y+unit;
        stage.invalidate();
    }
    public void left(View view){
        play_x = play_x-unit;
        stage.invalidate();
    }
    public void right(View view){
        play_x = play_x+unit;
        stage.invalidate();
    }

    class CustomView extends View {

        public CustomView(Context context) {
            super(context);
        }

        //1. 화면에 동그라미를 그려주기 위해 view안에 있는 onDraw함수 오버라이드 함
        //2. 동그라이를 그리려면 그릴 좌표가 필요함. 한가운데에 그리려면 한가운데 좌표를 찾아야함.
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);



            Paint paint = new Paint();
            paint.setColor(Color.DKGRAY);
            //그려주는 함수
            canvas.drawCircle(play_x,play_y,player_size/2, paint);
        }
    }

}

