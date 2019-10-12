package deb.px.com.example.energystation;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class EnergyStation {
    public static final int TOTAL_STATIONS = 11;

    private List<String> stationsName = new ArrayList<>();
    private List<LatLng> latLngs = new ArrayList<>();

    public EnergyStation() {
        stationsName.add("Energy Station - Av Aguia de Haia");
        stationsName.add("Energy Station - Itaquera");
        stationsName.add("Energy Station - Tatuapé");
        stationsName.add("Energy Station - Sé");
        stationsName.add("Energy Station - Liberdade");
        stationsName.add("Energy Station - Jabaquara");
        stationsName.add("Energy Station - Vila Mariana");
        stationsName.add("Energy Station - Santana");
        stationsName.add("Energy Station - Pinheiros");
        stationsName.add("Energy Station - Morumbi");
        stationsName.add("Energy Station - Barra Funda");

        // Zona Leste - Av Aguia de Haia
        // Av. Águia de Haia, 2600 - Loja 3 - Conj. Hab. Aguia de Haia, São Paulo - SP, 03694-000
        latLngs.add(new LatLng(-23.523547, -46.474869));

        // Zona Leste - Itaquera
        // Av. Águia de Haia, 583 - Artur Alvim, São Paulo - SP, 03694-000
        latLngs.add(new LatLng(-23.561702, -46.445620));

        // Zona Leste - Tatuapé
        // R. João Rudge, 101 - Casa Verde, São Paulo - SP, 02513-020
        latLngs.add(new LatLng(-23.515416, -46.655445));

        // Centro Sé
        // R. Asdrúbal do Nascimento, 462 - Bela Vista, São Paulo - SP, 01316-030
        latLngs.add(new LatLng(-23.553545, -46.637350));

        // Centro Liberdade
        // Rua Tamandaré, 54 - Liberdade, São Paulo - SP, 01525-000
        latLngs.add(new LatLng(-23.560184, -46.631561));

        // Zona Sul - Jabaquara
        // Rua dos Curupiás, 312 - Jabaquara, São Paulo - SP, 04344-050
        latLngs.add(new LatLng(-23.639100, -46.642923));

        // Zona Sul - Vila Mariana
        // Av. 23 de Maio, 3115 - Vila Mariana, São Paulo - SP, 04008-090
        latLngs.add(new LatLng(-23.582142, -46.649867));

        // Zona Norte - Santana
        // Av. Cruzeiro do Sul, 3449 - Santana, São Paulo - SP, 02031-200
        latLngs.add(new LatLng(-23.500074, -46.62511));

        // Zona Norte - Pinheiros
        // Av. Rebouças, 2036 - Pinheiros, São Paulo - SP, 05402-300
        latLngs.add(new LatLng(-23.564171, -46.680487));

        // Zona Oeste - Morumbi
        // R. Dr. Flávio Américo Maurano, 965 - Jardim Morumbi, São Paulo - SP, 05656-020
        latLngs.add(new LatLng(-23.611236, -46.722073));

        // Zona Oeste - Barra Funda
        // R. Barra Funda, 572 - Barra Funda, São Paulo - SP, 01152-010
        latLngs.add(new LatLng(-23.529214, -46.656278));
    }

    public List<String> getStationsName() {
        return stationsName;
    }

    public List<LatLng> getLatLngs() {
        return latLngs;
    }

    public String getStationName(int position) {
        return stationsName.get(position);
    }

    public LatLng getLatLng(int position) {
        return latLngs.get(position);
    }

}
