package deb.px.com.example.energystation.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

import deb.px.com.example.energystation.R;
import deb.px.com.example.energystation.config.ConfigFirebase;
import deb.px.com.example.energystation.model.EnergyStation;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    private final LatLng INITIAL_LATLNG = new LatLng(-23.534465, -46.585443);

    private boolean initialZoom = true;

    private static final float INITIAL_ZOOM = 10.9f;
    private static final float STATION_SELECTED_ZOOM = 15f;

    private int totalStations;

    private List<EnergyStation> energyStationsList = new LinkedList<>();
    private List<String> stationsName = new LinkedList<>();
    private ArrayAdapter spinnerAdapter;

    private DatabaseReference energyStationsReference;
    private ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Spinner stationsSpinner = findViewById(R.id.stationsSpinner);
        spinnerAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, stationsName);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stationsSpinner.setAdapter(spinnerAdapter);
        stationsSpinner.setOnItemSelectedListener(stationsSpinnerListener);

        energyStationsReference = ConfigFirebase.getDatabase()
                .child("stations");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private final AdapterView.OnItemSelectedListener stationsSpinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
            CameraPosition cameraPosition;
            if (initialZoom) {
                initialZoom = false;
                cameraPosition = new CameraPosition.Builder().zoom(INITIAL_ZOOM).target(INITIAL_LATLNG).build();
            } else
                cameraPosition = new CameraPosition.Builder().zoom(STATION_SELECTED_ZOOM).target(energyStationsList.get(position).getMyLatLng().toLatLng()).build();

            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(MapsActivity.this, LocationActivity.class);
                intent.putExtra("station", findEnergyStation(marker.getTitle()));
                startActivity(intent);
            }
        });
    }

    public EnergyStation findEnergyStation(String title) {
        for (EnergyStation energyStation : energyStationsList) {
            if (energyStation.getTitle().equals(title))
                return energyStation;
        }
        return null;
    }

    private void loadEnergyStations() {
        valueEventListener = energyStationsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                energyStationsList.clear();
                mMap.clear();
                totalStations = 0;

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    EnergyStation energyStation = data.getValue(EnergyStation.class);
                    energyStationsList.add(energyStation);
                    stationsName.add(energyStation.getTitle());
                    totalStations++;
                }

                for (int i = 0; i < totalStations; i++)
                    mMap.addMarker(new MarkerOptions().position(energyStationsList.get(i).getMyLatLng().toLatLng()).title(energyStationsList.get(i).getTitle()));

                spinnerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadEnergyStations();
    }

    @Override
    protected void onStop() {
        super.onStop();
        energyStationsReference.removeEventListener(valueEventListener);
    }
}
