package ec.klecet.com.klecetbustrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    Marker myMarker;

    Double latitude;
    Double longitude;
    private GoogleMap mMap;

    DatabaseReference dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        dref=FirebaseDatabase.getInstance().getReference("B1Location");


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
        try {

            dref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    Location teacher = (Location) dataSnapshot.getValue(Location.class);
                    Log.d("Location Object", teacher.toString());
                    String teacherString = String.valueOf(teacher);
                    //adapter.add(teacherString);

                    LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );
                    mMap.setTrafficEnabled(false);
                    mMap.setIndoorEnabled(false);
                    mMap.getUiSettings().setZoomControlsEnabled(true);
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                            .target(mMap.getCameraPosition().target)
                            .zoom(17)
                            .bearing(30)
                            .tilt(45)
                            .build()));

                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title(dataSnapshot.getKey()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    Location teacher = (Location) dataSnapshot.getValue(Location.class);
                    String teacherString = String.valueOf(teacher);
                    //adapter.add(teacherString);
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    //list.remove(dataSnapshot.getValue(Location.class));
                    //adapter.notifyDataSetChanged();
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });

        }  catch (Exception e) {
                e.printStackTrace();
            }
    }
}
