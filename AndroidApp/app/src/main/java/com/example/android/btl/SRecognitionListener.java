package com.example.android.btl;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class SRecognitionListener implements RecognitionListener
{
    int index=-1;
private DatabaseReference ref;
private TextView textView;
private boolean alreadyOn=false;
    public SRecognitionListener(DatabaseReference ref, TextView textView) {
        this.ref = ref;
        this.textView = textView;
    }

    public void run(String result) {
        String r=MainActivity.send_code;
        switch (result)
        {
            case "turn on tv":
                if(!MainActivity.toogle)
                {
                    send(18,null);

                    MainActivity.toogle=true; 
                }
                break;
            case "turn off tv":
            if (MainActivity.toogle)
            {
                send(18,null);
                MainActivity.toogle=false;
            }
                break;
            case "up":
                send(22,null);
                break;
            case "back":
                send(24,null);
                break;
            case "okay":
                send(10,null);
                break;

            case "down":
                send(23,null);
                break;
            case "left":
                send(20,null);
                break;
            case "right":
                send(21,null);
                break;
            case "open menu":
                send(15,null);
                break;
            case "mute":
                send(16,null);
                break;
            case "exit":
                send(17,null);
                break;
            case "open source":
                send(19,null);

                break;
            case "channel up":
                send(13,null);
                break;
            case "channel down":
                send(14,null);
                break;
            case "volume up":
                send(11,null);
                break;
            case "volume down":
                send(12,null);
                break;

             default: {
                 String[] part = result.split(" ");
                 if (part.length == 3 && part[0].equals("open") && part[1].equals("channel")) {
                     int s= Integer.valueOf(part[2]);
                     send(s,null);
                 }
                 break;
             }





        }


    }



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
    public void onResults(Bundle results)
    {
        ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if (matches != null) {
            String s = matches.get(0);
            s=s.toLowerCase();
            textView.setText(s);
            run(s);

        }

    }
    void send(int index,String val)
    {
    String send;


            send= MainActivity.send_code;

            if (index==MainActivity.old_index)
                MainActivity.count++;
            else
            {
                MainActivity.old_index=index;
                MainActivity.count=0;
            }

    if (index!=-1)
        send=send+"|"+name(index)+"|"+String.valueOf(MainActivity.count);
            else
                {
                    send=send+"|"+val+"|"+String.valueOf(MainActivity.count);

                }

            ref.setValue(send);
    }
    String name(int index)
    {
        switch (index) {
            case 0:
                return "ZERO";
            case 1:
                return "ONE";
            case 2:
                return "TWO";
            case 3:
                return "THREE";
            case 4:
                return "FOUR";
            case 5:
                return "FIVE";
            case 6:
                return "SIX";
            case 7:
                return "SEVEN";
            case 8:
                return "EIGHT";
            case 9:
                return "NINE";
            case 10:
                return "OK";
            case 11:
                return "VOL_UP";
            case 12:
                return "VOL_DOWN";
            case 13:
                return "CHAN_UP";
            case 14:
                return "CHAN_DOWN";
            case 15:
                return "MENU";
            case 16:
                return "MUTE";
            case 17:
                return "EXIT";
            case 18:
                return "POWER";
            case 20:
                return "LEFT";
            case 21:
                return "RIGHT";
            case 22:
                return "UP";
            case 23:
                return "DOWN";
            case 24:
                return "BACK";
            case 19:
                return "SOURCE";


        }
        return "POWER";
    }
    @Override
    public void onPartialResults(Bundle partialResults) {

    }

    @Override
    public void onEvent(int eventType, Bundle params) {

    }

}

