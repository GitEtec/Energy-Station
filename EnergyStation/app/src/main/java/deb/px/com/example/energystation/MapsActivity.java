package deb.px.com.example.energystation;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng etec = new LatLng(-23.523253, -46.475199);
        mMap.addMarker(new MarkerOptions().position(etec).title("Etec ZL"));
        /*mMap.moveCamera(CameraUpdateFactory.newLatLng(etec));*/
        CameraPosition cameraPosition = new CameraPosition.Builder().zoom(15).target(etec).build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        //teste
        // Add a marker in Sydney and move the camera
        LatLng es1 = new LatLng(-23.523174, -46.474738);
        mMap.addMarker(new MarkerOptions().position(es1).title("Energy Station 1 ZL"));
        /*mMap.moveCamera(CameraUpdateFactory.newLatLng(etec));*/
        CameraPosition newcameraPosition = new CameraPosition.Builder().zoom(15).target(es1).build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(newcameraPosition));

        //teste2
        LatLng es2 = new LatLng( -23.513939, -46.476571);
        mMap.addMarker(new MarkerOptions().position(es2).title("Energy Station 2 ZL"));
        /*mMap.moveCamera(CameraUpdateFactory.newLatLng(etec));*/
        CameraPosition new1cameraPosition = new CameraPosition.Builder().zoom(15).target(es2).build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new1cameraPosition));

    }
}
