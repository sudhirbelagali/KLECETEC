package ec.klecet.com.klecetbustrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
public class LocationUpdates extends AppCompatActivity {
    DatabaseReference dref;
    ListView listview;
    ArrayList<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_updates);
        listview=(ListView)findViewById(R.id.list_latlong);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list);
        listview.setAdapter(adapter);
        dref=FirebaseDatabase.getInstance().getReference("Location");

        dref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Location teacher = (Location) dataSnapshot.getValue(Location.class);
                Log.d("Location Object", teacher.toString());
                String teacherString = String.valueOf(teacher);
                adapter.add(teacherString);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Location teacher = (Location) dataSnapshot.getValue(Location.class);
                String teacherString = String.valueOf(teacher);
                adapter.add(teacherString);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                list.remove(dataSnapshot.getValue(Location.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stringText;

                //in normal case
                stringText= ((TextView)view).getText().toString();
                //show selected
                Toast.makeText(LocationUpdates.this, stringText, Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("latlong", stringText);
                startActivity(i);
            }
        });
    }
}