package sti.gimay.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private boolean toggleButtonValue = false;
    private DatabaseReference mDatabase; //variable for Database Reference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setTitle("Toggle Demo");

        ToggleButton toggleButton = findViewById(R.id.toggle_button);

        toggleButtonValue = toggleButton.isChecked();

        toggleButton.setOnCheckedChangeListener(this);
        mDatabase = FirebaseDatabase.getInstance().getReference(); // init Database Ref: rice-e-rrigate-test
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        int value = 0;

        switch (id){
            case R.id.toggle_button:
                toggleButtonValue = isChecked;
                value = isChecked ? 1 : 0;
                break;
        }
        mDatabase.child("arduinoDevice").child("switch").setValue(value); // Insert Data to Realtime Database: arduinoDevice/switch=value;
    }
}
