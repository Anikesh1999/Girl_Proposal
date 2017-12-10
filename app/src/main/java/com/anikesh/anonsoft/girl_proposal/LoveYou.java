package com.anikesh.anonsoft.girl_proposal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoveYou extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.love_you);
        intent = new Intent(LoveYou.this,RiteshFacebook.class);
    }
    public void moveToFacebook(View view){
        startActivity(intent);
    }
}
