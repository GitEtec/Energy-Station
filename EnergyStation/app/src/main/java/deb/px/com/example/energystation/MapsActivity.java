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

        // Zona Leste - Av Aguia de Haia
        //  Av. Águia de Haia, 2600 - Loja 3 - Conj. Hab. Aguia de Haia, São Paulo - SP, 03694-000
        LatLng aguia = new LatLng(-23.523547, -46.474869);
        mMap.addMarker(new MarkerOptions().position(aguia).title("Energy Station - Av Aguia de Haia"));
        CameraPosition new0cameraPosition = new CameraPosition.Builder().zoom(15).target(aguia).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new0cameraPosition));

        //Zona Leste - Itaquera
        //  Av. Águia de Haia, 583 - Artur Alvim, São Paulo - SP, 03694-000
        LatLng itaquera = new LatLng(-23.561702, -46.445620);
        mMap.addMarker(new MarkerOptions().position(itaquera).title("Energy Station - Itaquera"));
        CameraPosition newcameraPosition = new CameraPosition.Builder().zoom(15).target(itaquera).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(newcameraPosition));

        //Zona Leste Tatuapé
        // R. João Rudge, 101 - Casa Verde, São Paulo - SP, 02513-020
        LatLng tatuape = new LatLng(-23.515416, -46.655445);
        mMap.addMarker(new MarkerOptions().position(tatuape).title(" Energy Station - Tatuapé"));
        CameraPosition new1cameraPosition = new CameraPosition.Builder().zoom(15).target(tatuape).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new1cameraPosition));

        //Centro Sé
        // R. Asdrúbal do Nascimento, 462 - Bela Vista, São Paulo - SP, 01316-030
        LatLng se = new LatLng(-23.553545, -46.637350);
        mMap.addMarker(new MarkerOptions().position(se).title("Energy Station  - Sé"));
        CameraPosition new2cameraPosition = new CameraPosition.Builder().zoom(15).target(se).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new2cameraPosition));

        //Centro Liberdade
        //  Rua Tamandaré, 54 - Liberdade, São Paulo - SP, 01525-000
        LatLng japao = new LatLng(-23.560184, -46.631561);
        mMap.addMarker(new MarkerOptions().position(japao).title("Energy Station  - Liberdade"));
        CameraPosition new3cameraPosition = new CameraPosition.Builder().zoom(15).target(japao).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new3cameraPosition));

        //Zona Sul - Jabaquara
        //Rua dos Curupiás, 312 - Jabaquara, São Paulo - SP, 04344-050
        LatLng jabaquara = new LatLng(-23.639100, -46.642923);
        mMap.addMarker(new MarkerOptions().position(jabaquara).title("Energy Station  - Jabaquara"));
        CameraPosition new4cameraPosition = new CameraPosition.Builder().zoom(15).target(jabaquara).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new4cameraPosition));

        //Zona Sul - Vila Mariana
        //Av. 23 de Maio, 3115 - Vila Mariana, São Paulo - SP, 04008-090
        LatLng vlmariana = new LatLng(-23.582142, -46.649867);
        mMap.addMarker(new MarkerOptions().position(vlmariana).title("Energy Station  - Vila Mariana"));
        CameraPosition new5cameraPosition = new CameraPosition.Builder().zoom(15).target(vlmariana).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new5cameraPosition));

        //Zona Norte - Santana
        //Av. Cruzeiro do Sul, 3449 - Santana, São Paulo - SP, 02031-200
        LatLng santana = new LatLng(-23.500074, -46.62511);
        mMap.addMarker(new MarkerOptions().position(santana).title("Energy Station  - Santana"));
        CameraPosition new6cameraPosition = new CameraPosition.Builder().zoom(15).target(santana).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new6cameraPosition));

        //Zona Norte - Pinheiros
        //Av. Rebouças, 2036 - Pinheiros, São Paulo - SP, 05402-300
        LatLng pinheiros = new LatLng(-23.564171, -46.680487);
        mMap.addMarker(new MarkerOptions().position(pinheiros).title("Energy Station  - Santana"));
        CameraPosition new7cameraPosition = new CameraPosition.Builder().zoom(15).target(pinheiros).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new7cameraPosition));

        //Zona Oeste- Morumbi
        //R. Dr. Flávio Américo Maurano, 965 - Jardim Morumbi, São Paulo - SP, 05656-020
        LatLng morumbi = new LatLng(-23.611236, -46.722073);
        mMap.addMarker(new MarkerOptions().position(morumbi).title("Energy Station  - Santana"));
        CameraPosition new8cameraPosition = new CameraPosition.Builder().zoom(15).target(morumbi).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new8cameraPosition));

        //Zona Oeste - Barra Funda
        //R. Barra Funda, 572 - Barra Funda, São Paulo - SP, 01152-010
        LatLng barra = new LatLng(-23.529214, -46.656278);
        mMap.addMarker(new MarkerOptions().position(barra).title("Energy Station  - Santana"));
        CameraPosition new9cameraPosition = new CameraPosition.Builder().zoom(15).target(barra).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new9cameraPosition));

    }
}
