package com.anikesh.anonsoft.girl_proposal;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button yes_btn,no_btn,no_btn1,no_btn2,no_btn3,no_btn4;
    Intent intent;
    TextView gaurav,manish,shohel;
    TextToSpeech textToSpeech;
    Integer ttsResult;
    String user="";
    String toast_msg="I Really Love You Yaar ....!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yes_btn = findViewById(R.id.yes_btn);
        no_btn =  findViewById(R.id.no_btn);
        no_btn1 = findViewById(R.id.no_btn1);
        no_btn2 = findViewById(R.id.no_btn2);
        no_btn3 = findViewById(R.id.no_btn3);
        no_btn4 = findViewById(R.id.no_btn4);

        gaurav = findViewById(R.id.gaurav);
        manish = findViewById(R.id.manish);
        shohel = findViewById(R.id.shohel);

        intent = new Intent(getApplicationContext(),LoveYou.class);


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status){
                if (status == TextToSpeech.SUCCESS){
                    ttsResult = textToSpeech.setLanguage(Locale.US);
                }
            }
        });
    }

    public void setValue(View view){
        if (view.getId() == R.id.gaurav){
            user = "Gaurav";

        }else if (view.getId() == R.id.manish){
            user= "Manish";

        }else {
            user= "Shohel";
        }
    }

    public void design(View view){

        switch (view.getId()){

            case R.id.yes_btn:
                if (!user.equals("")){
                    textToSpeech.speak("hi "+user,TextToSpeech.QUEUE_FLUSH,null);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    speak();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    startActivity(intent);
                    user = "";
                }
                break;
            case R.id.no_btn:
                if (!user.equals(""))
                    toast_msg = "               Your are "+user+"\n & you are not a girl, so Sorry .... ! ";
                no_btn.setVisibility(View.INVISIBLE);
                no_btn1.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),toast_msg,Toast.LENGTH_SHORT).show();
                break;
            case R.id.no_btn1:
                if (!user.equals(""))
                    toast_msg = "               Your are "+user+"\n & you are not a girl, so Sorry .... ! ";
                no_btn1.setVisibility(View.INVISIBLE);
                no_btn2.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),toast_msg,Toast.LENGTH_SHORT).show();
                break;
            case R.id.no_btn2:
                if (!user.equals(""))
                    toast_msg = "               Your are "+user+"\n & you are not a girl, so Sorry .... ! ";
                no_btn2.setVisibility(View.INVISIBLE);
                no_btn3.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),toast_msg,Toast.LENGTH_SHORT).show();
                break;
            case R.id.no_btn3:
                if (!user.equals(""))
                    toast_msg = "               Your are "+user+"\n & you are not a girl, so Sorry .... ! ";
                no_btn3.setVisibility(View.INVISIBLE);
                no_btn4.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),toast_msg,Toast.LENGTH_SHORT).show();
                break;
            case R.id.no_btn4:
                if (!user.equals(""))
                    toast_msg = "               Your are "+user+"\n & you are not a girl, so Sorry .... ! ";
                no_btn4.setVisibility(View.INVISIBLE);
                no_btn1.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),toast_msg,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void speak(){
        if ((ttsResult == TextToSpeech.LANG_NOT_SUPPORTED) || (ttsResult == TextToSpeech.LANG_MISSING_DATA)){
            Toast.makeText(getApplicationContext(),"I Knew That You're Going To Say Me Too \n         I Was Expeting It",Toast.LENGTH_LONG).show();
        }else {
            textToSpeech.speak(" Wow",TextToSpeech.QUEUE_FLUSH,null);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            textToSpeech.speak(" I Was Expecting It",TextToSpeech.QUEUE_FLUSH,null);
        }
    }
    public void reset(View view){
        user = "";
    }
    public void developer(View view){
        textToSpeech.speak(" Hi Anikesh WhatsApp ",TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        if (textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
