package ec.klecet.com.klecetbustrack;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AllBusMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    DatabaseReference dref,dref2,dref3,dref4,dref5,dref6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_bus_maps);
        dref = FirebaseDatabase.getInstance().getReference("B1Location");
        dref2 = FirebaseDatabase.getInstance().getReference("B2Location");
        dref3 = FirebaseDatabase.getInstance().getReference("B3Location");
        dref4 = FirebaseDatabase.getInstance().getReference("B4Location");
        dref5 = FirebaseDatabase.getInstance().getReference("B5Location");
        dref6 = FirebaseDatabase.getInstance().getReference("B6Location");

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

        //final BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.bus);

        try {
            mMap.setTrafficEnabled(false);
            mMap.setIndoorEnabled(false);
            mMap.getUiSettings().setZoomControlsEnabled(true);

            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                    .target(mMap.getCameraPosition().target)
                    .zoom(17)
                    .build()));


            dref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title("B1")).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
              /*      LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title("B1"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));*/

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });

            dref2.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title("B2")).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
               /*     LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title("B2"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));*/

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
            dref3.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title("B3")).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
              /*      LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title("B3"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));*/

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });

            dref4.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title("B4")).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    /*LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title("B4"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));*/

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });

            dref5.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title("B5")).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                   /* LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title("B5"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));*/

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
            dref6.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title("B6")).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                   /* LatLng newLocation = new LatLng(
                            dataSnapshot.child("latitude").getValue(Long.class),
                            dataSnapshot.child("longitude").getValue(Long.class)
                    );

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));
                    mMap.addMarker(new MarkerOptions()
                            .position(newLocation)
                            .title("B6"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(newLocation));*/

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
