package com.signme.signme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long pressedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);

        ImageButton drawerIB = (ImageButton) findViewById(R.id.ib_drawer);
        drawerIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        NavigationView nv = (NavigationView) findViewById(R.id.navigation);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this, "" + item.getItemId() , Toast.LENGTH_SHORT).show();
                switch(item.getItemId()){
                    // 마이페이지 선택시
                    case R.id.nav_mypage:
                        Intent  mypage_btn=new Intent(getApplicationContext(),MypageActivity.class);
                        startActivity(mypage_btn);
                        break;
                    // 신청서 일정 선택시
                    case R.id.nav_schedule :

                        break;

                    // 가정통신문 선택시
                    case R.id.nav_newsLetter :

                        break;

                    // 채팅 선택시
                    case R.id.nav_chat :

                        break;

                    // 설정 선택시
                    case R.id.nav_option :

                        break;
                }

                return true;
            }
        });
    }
    //두번 클릭 시 종료
    @Override
    public void onBackPressed(){
        if(pressedTime==0){
            Toast.makeText(MainActivity.this,"한번 더 누르면 종료됩니다.",Toast.LENGTH_LONG).show();
            pressedTime=System.currentTimeMillis();
        }
        else{
            int seconds=(int)(System.currentTimeMillis()-pressedTime);
            if(seconds>2000){
                pressedTime=0;
            }
            else{
                finish();
            }
        }
    }


    public void sideButtonClicked(View view){

    }

    public void mypageButtonClicked(View view) {
        Log.d(getLocalClassName(), "mypageButtonClicked: ");
    }
    public void profileonClick(View view){

    }

}
