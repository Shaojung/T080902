package tw.com.pcschool.t080902;

import android.location.Address;
import android.location.Geocoder;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View v)
    {
        Geocoder geo = new Geocoder(MainActivity.this);
        try {
            List<Address> mylist = geo.getFromLocation(25.0337, 121.5645, 2);
            if (mylist.size() > 0)
            {
                Address addr = mylist.get(0);
                for (int i=0; i<=addr.getMaxAddressLineIndex();i++)
                {
                    Log.d("GEO", addr.getAddressLine(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void click2(View v)
    {
        Geocoder geo = new Geocoder(MainActivity.this);
        try {
            List<Address> mylist = geo.getFromLocationName("新北市三重區重新路二段60號", 1);
            if (mylist.size() > 0)
            {
                Address addr = mylist.get(0);
                Log.d("GEO", "Lat:" + addr.getLatitude() + ", Lng:" + addr.getLongitude());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
