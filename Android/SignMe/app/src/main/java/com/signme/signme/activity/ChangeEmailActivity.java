package com.signme.signme.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.signme.signme.R;
import com.signme.signme.server.APIInterface;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ghdth on 2017-10-09.
 */

public class ChangeEmailActivity extends AppCompatActivity {
    private EditText emailfield ,newfield;
    private String email,confrimemail;
    private Retrofit retrofit;
    private APIInterface apiInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);
        newfield=(EditText)findViewById(R.id.new_email);
        emailfield=(EditText) findViewById(R.id.now_email);
        email=emailfield.getText().toString();
        confrimemail=newfield.getText().toString();


        retrofit = new Retrofit.Builder()
                .baseUrl(APIInterface.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        apiInterface = retrofit.create(APIInterface.class);
        //Call<Void> call = apiInterface.modifyAnswerToSurvey();

        //뒤로가기
        ImageView backbtn=(ImageView)findViewById(R.id.modify_back);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     finish();
            }
        });


        //저장
        ImageView checkbtn=(ImageView)findViewById(R.id.modify_check);
        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(ChangeEmailActivity.this);
                dialog.setTitle("저장");
                dialog.setMessage("변경한 내용을 저장하시겠습니까?");
                dialog.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(email.equals(confrimemail)){
                            retrofit = new Retrofit.Builder()
                                    .baseUrl(APIInterface.URL)
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
                            Map<String, Object> fieldMap = new HashMap<>();
                            fieldMap.put("email",email);
                            apiInterface = retrofit.create(APIInterface.class);
                            Call<Void> call=apiInterface.modifyAnswerToResponse("",fieldMap, getSharedPreferences("test", MODE_PRIVATE).getString("signme-x-access-token", null));
                            call.enqueue(new Callback<Void>() {
                                @Override
                                public void onResponse(Call<Void> call, Response<Void> response) {


                                }

                                @Override
                                public void onFailure(Call<Void> call, Throwable t) {

                                }
                            });
                        }
                    }
                });
                dialog.setNegativeButton("취소",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

    }
}
