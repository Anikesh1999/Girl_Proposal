package com.anikesh.anonsoft.girl_proposal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class RiteshFacebook extends AppCompatActivity {

    ImageView fb_bg;
    Toast detail;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.ritesh_facebook);
        fb_bg = findViewById(R.id.fb_bg);

        LayoutInflater inflater = getLayoutInflater();
        View detail_toast = inflater.inflate(R.layout.detail_toast, (ViewGroup) findViewById(R.id.detail));
        detail = new Toast(getApplicationContext());
        detail.setDuration(Toast.LENGTH_LONG);
        detail.setGravity(Gravity.CENTER,0,0);
        detail.setView(detail_toast);
    }

    public void showNumber(View view){
        detail.show();
    }
}
