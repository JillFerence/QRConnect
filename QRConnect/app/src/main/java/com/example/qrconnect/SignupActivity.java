package com.example.qrconnect;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * This class maintains the functions of loading event details when a user wants to sign up
 */
public class SignupActivity extends AppCompatActivity {
    /**
     * Initializes the activity, sets the content view, and begins the process of loading event details.
     * It retrieves the event ID passed from the previous activity and uses it to load the corresponding
     * event details from Firestore and the event poster from Firebase Storage.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState.
     *                           Otherwise, it is null.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String eventId = getIntent().getStringExtra("EVENT_ID");
        Log.d("Signup Activity", "Received event ID: " + eventId);
        setContentView(R.layout.activity_signup_event);
        loadSignupDetails(eventId);
        setupButtonListener();
        signupBackAction();
    }
    /**
     * Fetches and displays the details of an event including its title, description, date, time, location,
     * and capacity from Firestore. It also retrieves the event's poster image from Firebase Storage and displays
     * it using Glide.
     *
     * @param eventId The unique identifier of the event whose details are to be loaded and displayed.
     */
    private void loadSignupDetails(String eventId){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference eventRef = db.collection("events").document(eventId);

        eventRef.get().addOnSuccessListener(documentSnapshot -> {
            if (documentSnapshot.exists()) {
                // Set text fields with data from Firestore
                TextView eventTitle = findViewById(R.id.signup_event_title_textview);
                TextView eventDescription = findViewById(R.id.signup_description_text);
                TextView eventDate = findViewById(R.id.signup_date_text);
                TextView eventTime = findViewById(R.id.signup_time_text);
                TextView eventAddress = findViewById(R.id.signup_location_text);
                TextView eventCapacity = findViewById(R.id.signup_capacity_text);
                ImageView eventPoster = findViewById(R.id.signup_event_image);
                TextView eventCurrentAttendance = findViewById(R.id.signup_event_current_attendance_text);

                eventTitle.setText(documentSnapshot.getString("title"));
                eventDescription.setText(documentSnapshot.getString("description"));
                eventDate.setText(documentSnapshot.getString("date"));
                eventTime.setText(documentSnapshot.getString("time"));
                eventAddress.setText(documentSnapshot.getString("location"));
                Long capacity = documentSnapshot.getLong("capacity");
                eventCapacity.setText(capacity != null && capacity != 0L ? String.valueOf(capacity) : "Unlimited");
                Long attendance = documentSnapshot.getLong("currentAttendance");
                eventCurrentAttendance.setText(attendance != null ? String.valueOf(attendance) : "0");

                // Load the poster image from Firebase Storage
                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageRef = storage.getReference().child("eventposters/" + eventId + "_eventPoster.jpg");

                // Use Glide or a similar library to load the image
                storageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                    Glide.with(this)
                            .load(uri)
                            .into(eventPoster);
                }).addOnFailureListener(e -> {
                    Log.d("SignupActivity", "Error loading image: ", e);
                });
            } else {
                Log.d("SignupActivity", "Document does not exist.");
            }
        }).addOnFailureListener(e -> {
            Log.d("SignupActivity", "Error fetching document: ", e);
        });
    }
    /**
     * Sets up the action for the back navigation button. When clicked, it finishes the current activity,
     * effectively navigating the user back to the previous screen.
     */
    private void signupBackAction(){
        ImageButton backButton = findViewById(R.id.signup_details_back_nav_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    /**
     * Sets up listeners for buttons in the activity.
     */
    private void setupButtonListener() {
        Button signupButton = findViewById(R.id.signup_button_signup_bottom);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Signup Logic and alert dialog
                // Can use event.signupUser ...
            }
        });
    }
}

