package com.example.offispi;

import android.content.DialogInterface;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;


import androidx.appcompat.app.AlertDialog;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MsgHandler extends FirebaseMessagingService {

    private static final String TAG = "MsgHandler";

    public MsgHandler() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message Notification Data: " + remoteMessage.getData());
            Map<String, String> data = remoteMessage.getData();
            String name = data.get("name");
            String present = data.get("present");

            String hasArrived = (present.equals("1") ? "g" : "");
            final String person = name + hasArrived;

            Globals.CURRENT_ACTIVITY.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder alert = new AlertDialog.Builder(Globals.CURRENT_ACTIVITY);

                    alert.setTitle("  ");
                    final ImageView img = new ImageView(Globals.CURRENT_ACTIVITY);
                    alert.setView(img);
                    int res = Globals.CURRENT_ACTIVITY.getResources().getIdentifier(person, "drawable", Globals.CURRENT_ACTIVITY.getPackageName());
                    img.setImageResource(res);

                    alert.setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    alert.show();

              /*      ImageView img = Globals.CURRENT_ACTIVITY.findViewById(R.id.person);
                    String mDrawableName = person;
                    int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
                    // img.setImageResource(R.drawable.adi);
                    img.setImageResource(resID);
                    Log.d(TAG, "Message Notification: " + person); */
                }
            });
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
    }
}
