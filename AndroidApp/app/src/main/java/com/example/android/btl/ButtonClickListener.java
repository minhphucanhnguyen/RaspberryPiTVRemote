package com.example.android.btl;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

    public class ButtonClickListener implements View.OnClickListener{


        private String send;
        private DatabaseReference ref;
        private int index;
        public ButtonClickListener(DatabaseReference ref, String send,int index)
        {
            this.send=send;
            this.ref=ref;
        this.index=index;

        }
        @Override
        public void onClick(View v) {

            if(send!=null) {

               send= MainActivity.send_code;

               if (index==MainActivity.old_index)
                    MainActivity.count++;
               else
               {
                   MainActivity.old_index=index;
                   MainActivity.count=0;
               }

                send=send+"|"+name(index)+"|"+String.valueOf(MainActivity.count);
                Log.d("CODING",send);

                ref.setValue(send);

            }

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


    }


