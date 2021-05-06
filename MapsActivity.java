package se1a_2200347.map07;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

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
//        test1();
}

    private void test1(){
        String src_lat = "35.681382";
        String src_ltg = "139.7660842";

        String des_lat = "35.684752";
        String des_ltg = "139.707937";

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);

        intent.setClassName("com.google.android.apps.maps",
                            "com.google.android.maps.MapsActivity");
        String str = String.format(Locale.US,
                "http://maps.google.com/maps?saddr=%s,%s&daddr=%s,%s",
                                    src_lat, src_ltg, des_lat, des_ltg);
        intent.setData(Uri.parse(str));
        startActivity(intent);
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

        // Add marker in ECC
        LatLng eccComp = new LatLng(34.7064635, 135.5034325);
        mMap.addMarker(new MarkerOptions().position(eccComp).title("ECC コンピュータ専門学校はココ！"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eccComp, 17f));

        // Add markers in YODOBASHI_CAMERA, THIRD_BUILDING, BELLFA
        LatLng yodo_c = new LatLng(34.7040943, 135.4957208);
        mMap.addMarker(new MarkerOptions().position(yodo_c).title("よく行く家電量販店！"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(yodo_c, 16f));

        LatLng third_B = new LatLng(34.6990586, 135.4968484);
        mMap.addMarker(new MarkerOptions().position(third_B).title("カードショップ内包！"));

        LatLng belffa = new LatLng(34.7158277, 135.5279824);
        mMap.addMarker(new MarkerOptions().position(belffa).title("最近行ってない"));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                mMap.clear();
                return false;
            }
        });

        //マップを長押しした時のイベント処理
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
           @Override
           public void onMapLongClick(LatLng longpushlocation) {
               //長押し時の処理
               LatLng now = new LatLng(longpushlocation.latitude, longpushlocation.longitude);
               mMap.addMarker(new MarkerOptions().position(now));
           }
        });
    }

//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//
//    }

}