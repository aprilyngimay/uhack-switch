package sti.gimay.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private boolean toggleButtonValue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setTitle("Toggle Demo");

        ToggleButton toggleButton = findViewById(R.id.toggle_button);

        toggleButtonValue = toggleButton.isChecked();

        toggleButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        String message = "";

        switch (id){
            case R.id.toggle_button:
                toggleButtonValue = isChecked;
                message = isChecked ? "Toggle Button is on" : "Toggle Button is off";
                break;
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
