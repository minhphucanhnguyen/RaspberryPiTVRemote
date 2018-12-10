package com.example.android.btl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.Locale;

public class SpeechTouchListener implements View.OnTouchListener {
    private SpeechRecognizer speechRecognizer;
    private Intent intent;
    private DatabaseReference ref;

    private SRecognitionListener listener;

    public SpeechTouchListener(Context context, DatabaseReference ref,TextView textView)
    {
        this.ref = ref;

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(context);
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        listener=new SRecognitionListener(ref,textView);

        speechRecognizer.setRecognitionListener(listener);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:


                speechRecognizer.startListening(intent);
                break;
        }


        return false;
    }
}

