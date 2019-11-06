package deb.px.com.example.energystation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import deb.px.com.example.energystation.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openMap(View view) {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }
}
