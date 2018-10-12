package mapa.maps;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements
        GoogleMap.OnMarkerClickListener,
        OnMapReadyCallback {

    private static final LatLng SENAI = new LatLng(-25.513857, -49.235107);

    private static final LatLng TERMINAL = new LatLng(-25.5174, -49.2301);

    private static final LatLng SABORES = new LatLng(-25.516855, -49.231667);

    private Marker mSenai, mTerminal, mSabores;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {

        mMap = map;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);

        float zoomLevel = 14.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SENAI, zoomLevel));

        mSenai = mMap.addMarker(new MarkerOptions()
                .position(SENAI)
                .title("Senai - Boqueirão"));
        mSenai.setTag(0);

        mTerminal = mMap.addMarker(new MarkerOptions()
                .position(TERMINAL)
                .title("Terminal - Boqueirão"));
        mTerminal.setTag(0);

        mSabores = mMap.addMarker(new MarkerOptions()
                .position(SABORES)
                .title("Restaurante - Sabores Grill"));
        mSabores.setTag(0);

        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {


        if(marker.getTitle().equals("Senai - Boqueirão")) {
            View view = LayoutInflater.from(MapsActivity.this).inflate(R.layout.activity_senai, null);

            AlertDialog.Builder builder = new AlertDialog.Builder(MapsActivity.this);
            builder.setCancelable(true);
            builder.setTitle("Senai -  Boqueirão");
            builder.setMessage("").setView(view);
            builder.create().show();
        }

        else if(marker.getTitle().equals("Terminal - Boqueirão")){
            View view1 = LayoutInflater.from(MapsActivity.this).inflate(R.layout.activity_terminal, null);

            AlertDialog.Builder builder1 = new AlertDialog.Builder(MapsActivity.this);
            builder1.setCancelable(true);
            builder1.setTitle("Terminal -  Boqueirão");
            builder1.setMessage("").setView(view1);
            builder1.create().show();
        }

        else if(marker.getTitle().equals("Restaurante - Sabores Grill")){
            View view2 = LayoutInflater.from(MapsActivity.this).inflate(R.layout.activity_sabores, null);

            AlertDialog.Builder builder2 = new AlertDialog.Builder(MapsActivity.this);
            builder2.setCancelable(true);
            builder2.setTitle("Restaurante - Sabores Grill");
            builder2.setMessage("").setView(view2);
            builder2.create().show();
        }

        return false;
    }

}
