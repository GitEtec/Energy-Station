package deb.px.com.example.energystation;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    private static final float INITIAL_ZOOM = 10.9f;
    private static final float ITEM_SELECTED_ZOOM = 15f;
    private boolean initialZoom = true;

    private EnergyStation energyStation = new EnergyStation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Spinner stationsSpinner = findViewById(R.id.stationsSpinner);
        ArrayAdapter adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, energyStation.getStationsName());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stationsSpinner.setAdapter(adapter);
        stationsSpinner.setOnItemSelectedListener(stationsSpinnerListener);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private final AdapterView.OnItemSelectedListener stationsSpinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            CameraPosition cameraPosition;
            if (initialZoom) {
                initialZoom = false;
                cameraPosition = new CameraPosition.Builder().zoom(INITIAL_ZOOM).target(new LatLng(-23.534465, -46.585443)).build();
            } else
                cameraPosition = new CameraPosition.Builder().zoom(ITEM_SELECTED_ZOOM).target(energyStation.getLatLng(position)).build();

            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for (int i = 0; i < EnergyStation.TOTAL_STATIONS; i++)
            mMap.addMarker(new MarkerOptions().position(energyStation.getLatLng(i)).title(energyStation.getStationName(i)));
    }
}
