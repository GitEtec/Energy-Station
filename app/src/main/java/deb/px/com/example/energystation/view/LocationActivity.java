package deb.px.com.example.energystation.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import deb.px.com.example.energystation.R;
import deb.px.com.example.energystation.adapter.AdapterImages;
import deb.px.com.example.energystation.config.Storage;
import deb.px.com.example.energystation.helper.RecyclerItemClickListener;
import deb.px.com.example.energystation.model.EnergyStation;

public class LocationActivity extends AppCompatActivity {
    private EnergyStation energyStation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        Bundle bundle = getIntent().getExtras();
        energyStation = (EnergyStation) bundle.getSerializable("station");
        getSupportActionBar().setTitle(energyStation.getTitle());

        ImageView energySationImageView = findViewById(R.id.energyStationImageView);
        Storage.download(this, energySationImageView, energyStation.getTitle(), 0);
        energySationImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startImageViewer(energyStation.getTitle(), 0);
            }
        });

        TextView addressTextView = findViewById(R.id.addressTextView);
        addressTextView.setText(energyStation.getAddress());

        LinearLayout phoneLinearLayout = findViewById(R.id.phoneLinearLayout);
        if (!energyStation.getPhone().isEmpty()) {
            TextView phoneTextView = findViewById(R.id.phoneTextView);
            phoneTextView.setText(energyStation.getPhone());

            phoneLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + energyStation.getPhone())));
                }
            });
        } else
            phoneLinearLayout.setVisibility(View.GONE);

        if (!energyStation.getParking().isEmpty()) {
            TextView parkingTextView = findViewById(R.id.parkingTextView);
            parkingTextView.setText(energyStation.getParking());
        } else {
            LinearLayout parkingLinearLayout = findViewById(R.id.parkingLinearLayout);
            parkingLinearLayout.setVisibility(View.GONE);
        }

        if (!energyStation.getSchudele().isEmpty()) {
            TextView scheduleTextView = findViewById(R.id.scheduleTextView);
            scheduleTextView.setText(energyStation.getSchudele());
        } else {
            LinearLayout scheduleLinearLayout = findViewById(R.id.scheduleLinearLayout);
            scheduleLinearLayout.setVisibility(View.GONE);
        }

        if (!energyStation.getConvenience().isEmpty()) {
            TextView convenienceTextView = findViewById(R.id.convenienceTextView);
            convenienceTextView.setText(energyStation.getConvenience());
        } else {
            LinearLayout convenienceLinearLayout = findViewById(R.id.convenienceLinearLayout);
            convenienceLinearLayout.setVisibility(View.GONE);
        }

        RecyclerView imagesRecyclerView = findViewById(R.id.imagesRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        imagesRecyclerView.setLayoutManager(layoutManager);
        imagesRecyclerView.setHasFixedSize(true);
        imagesRecyclerView.setAdapter(new AdapterImages(getApplicationContext(), energyStation.getTitle(), energyStation.getTotalImages()));
        imagesRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, imagesRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startImageViewer(energyStation.getTitle(), position);
            }

            @Override
            public void onLongItemClick(View view, int position) {
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        }));
    }

    private void startImageViewer(String title, int number) {
        Intent intent = new Intent(LocationActivity.this, ImageViewerActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("number", number);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_location, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_star)
            Toast.makeText(this, "Starred", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
