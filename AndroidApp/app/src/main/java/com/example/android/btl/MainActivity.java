package com.example.android.btl;

import android.content.Intent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    TextView v1;
    SearchableSpinner s;
    SpeechRecognizer m;
    Intent mS;
    SearchableSpinner spinner;
    SearchableSpinner spinner2;
    Button buttons[];
   static String send_code;
   static String tv_typed;
   static String remote_typed;
   static boolean toogle=false;

    static int old_index=-1;
    ArrayList<String> yy = new ArrayList<>();
    String toshiba[]={"CT-90048"};
    String lg[]={};
    String sam[]={"BN59-01005A","BN59-01015A","BN59-00937A","BN59-00634A"};
    ArrayAdapter<String> re;
    static int count=0;
    SpeechTouchListener touchListener;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        DatabaseReference myRef=FirebaseDatabase.getInstance().getReference("message");


        buttons=new Button[26];
        v1=findViewById(R.id.textView);
        buttons[0]=findViewById(R.id.b0);
        buttons[1]=findViewById(R.id.b1);
        buttons[2]=findViewById(R.id.b2);
        buttons[3]=findViewById(R.id.b3);
        buttons[4]=findViewById(R.id.b4);
        buttons[5]=findViewById(R.id.b5);
        buttons[6]=findViewById(R.id.b6);
        buttons[7]=findViewById(R.id.b7);
        buttons[8]=findViewById(R.id.b8);
        buttons[9]=findViewById(R.id.b9);
        buttons[10]=findViewById(R.id.bOk);
        buttons[11]=findViewById(R.id.bRight);
        buttons[12]=findViewById(R.id.bLeft);
        buttons[13]=findViewById(R.id.bUp);
        buttons[14]=findViewById(R.id.bDown);
        buttons[15]=findViewById(R.id.bMenu);
        buttons[16]=findViewById(R.id.bMute);
        buttons[17]=findViewById(R.id.bExit);
        buttons[18]=findViewById(R.id.power);
        buttons[25]=findViewById(R.id.micro);
        buttons[20]=findViewById(R.id.bLeft1);
        buttons[21]=findViewById(R.id.bRight1);
        buttons[22]=findViewById(R.id.bUp1);
        buttons[23]=findViewById(R.id.bDown1);
        buttons[19]=findViewById(R.id.bSource);
        buttons[24]=findViewById(R.id.bBack);

        spinner=findViewById(R.id.spinner);
spinner2=findViewById(R.id.spinner2);

        tv_typed=getResources().getStringArray(R.array.planets)[0];
        remote_typed=getResources().getStringArray(R.array.planets2)[0];
        send_code=tv_typed+"|"+remote_typed;

        for (int i=0;i<25;i++)

            buttons[i].setOnClickListener(new ButtonClickListener(myRef,send_code,i));



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv_typed=parent.getItemAtPosition(position).toString();

                spinner2.setEnabled(true);
                re.clear();
                switch (tv_typed){
                    case "LG":
                        re.addAll(lg);
                        if(lg.length!=0)
                        remote_typed=lg[0];
                        else
                          spinner2.setEnabled(false);
                        re.notifyDataSetChanged();
                        break;
                    case "Samsung":
                        re.addAll(sam);
                        remote_typed=sam[0];
                        re.notifyDataSetChanged();
                        break;
                    case "Toshiba":
                     re.addAll(toshiba);
                     remote_typed=toshiba[0];
                     re.notifyDataSetChanged();
                        break;
                }
                send_code=tv_typed+"|"+remote_typed;




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
            });
        spinner.setTitle("TV");
       re=new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,yy);

        spinner2.setAdapter(re);
        spinner2.setTitle("Remote");

spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       remote_typed=parent.getItemAtPosition(position).toString();


        send_code=tv_typed+"|"+remote_typed;


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});
        spinner2.setEnabled(false);
buttons[25].setOnTouchListener(new SpeechTouchListener(this,myRef,v1));




//        FirebaseDatabase database=FirebaseDatabase.getInstance();
        //      DatabaseReference myRef=database.getReference("messages");
        //    myRef.setValue("FFF");
        //  s= findViewById(R.id.spinner);
        //      s.setSelection(0);
   /*     v1 = findViewById(R.id.te);
        m = SpeechRecognizer.createSpeechRecognizer(this);
        mS = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mS.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        mS.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        m.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle results) {
                ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (matches != null) {
                    v1.setText(matches.get(0));

                }
            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });
        Button l = findViewById(R.id.bu);
        l.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        v1.setText("GGG");
                        break;

                    case MotionEvent.ACTION_DOWN:
                        m.startListening(mS);
                        break;
                }


                return false;
            }
        });

//s.setOnItemSelectedListener(this);


    }


    public void getSpeechInput(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    v1.setText(result.get(0));
                }
                break;
        }
    }*/
}
}
