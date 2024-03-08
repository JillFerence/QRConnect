package com.example.qrconnect;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The EventDetailsAcitivty class displays details of a specific event.
 * It allows users to navigate back, access the menu, and send notifications for the event.
 * It extends AppCompatActivity.
 */
public class EventDetailsActivity extends AppCompatActivity {
    /**
     * Called when the activity is first created. Responsible for initializing the activity.
     * @param savedInstanceState A Bundle containing the activity's previously frozen state, if there was one.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        // initialize backButton
        ImageButton backButton = findViewById(R.id.event_details_back_nav_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // initialize menu button
        ImageButton menuButton = findViewById(R.id.event_details_menu_icon_button);

        menuButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    Intent showIntent = new Intent(EventDetailsActivity.this, AttendeeListActivity.class);
                    //TODO: showIntent.putExtra("EVENT", event);
                    startActivity(showIntent);
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

        });

        // initialize send notification button
        ImageButton sendNotificationsButton = findViewById(R.id.event_details_send_notifications);

        sendNotificationsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    Intent showIntent = new Intent(EventDetailsActivity.this, SendNotificationsActivity.class);
                    //TODO: showIntent.putExtra("EVENT", event);
                    startActivity(showIntent);
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
