package com.example.daewon.cnu_map;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class BusActivity extends BaseActivity implements MapView.POIItemEventListener, NavigationView.OnNavigationItemSelectedListener {

    private MapView mapView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;
    private MapPOIItem Hall, gyeongsang,library_up,dormitary,dongmun,farmer,library_down,art,music,animal,gym,
    west,socialscience,sanhak,engineer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view3);
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(36.370082,127.346223), true);
        mapView.setZoomLevel(1,true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);
        ///////////////////////////////////////////////////////////////////////////////////////////
        /* MapPOIItem List */

        mapView.setPOIItemEventListener(this);
        gyeongsang = new MapPOIItem();
        gyeongsang.setItemName("경상대학");
        gyeongsang.setTag(0);
        gyeongsang.setMapPoint(MapPoint.mapPointWithGeoCoord(36.367306,127.345626));
        gyeongsang.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        gyeongsang.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(gyeongsang);

        Hall = new MapPOIItem();
        Hall.setItemName("정심화국제 문화회관");
        Hall.setTag(0);
        Hall.setMapPoint(MapPoint.mapPointWithGeoCoord(36.363813,127.345160));
        Hall.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        Hall.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(Hall);

        library_up = new MapPOIItem();
        library_up.setItemName("중앙도서관 앞(상행)");
        library_up.setTag(0);
        library_up.setMapPoint(MapPoint.mapPointWithGeoCoord(36.369472,127.346498));
        library_up.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        library_up.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(library_up);

        dormitary = new MapPOIItem();
        dormitary.setItemName("학생생활관");
        dormitary.setTag(0);
        dormitary.setMapPoint(MapPoint.mapPointWithGeoCoord(36.372556,127.346165));
        dormitary.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        dormitary.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(dormitary);

        dongmun = new MapPOIItem();
        dongmun.setItemName("동문주차장");
        dongmun.setTag(0);
        dongmun.setMapPoint(MapPoint.mapPointWithGeoCoord(36.367424,127.352119));
        dongmun.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        dongmun.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(dongmun);

        farmer = new MapPOIItem();
        farmer.setItemName("농업생명과학대 앞");
        farmer.setTag(0);
        farmer.setMapPoint(MapPoint.mapPointWithGeoCoord(36.369402,127.351416));
        farmer.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        farmer.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(farmer);

        library_down = new MapPOIItem();
        library_down.setItemName("중앙도서관 앞(하행)");
        library_down.setTag(0);
        library_down.setMapPoint(MapPoint.mapPointWithGeoCoord(36.369566,127.346390));
        library_down.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        library_down.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(library_down);

        art = new MapPOIItem();
        art.setItemName("예술대학 앞");
        art.setTag(0);
        art.setMapPoint(MapPoint.mapPointWithGeoCoord(36.370504,127.343571));
        art.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        art.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(art);

        music = new MapPOIItem();
        music.setItemName("음대2호관 앞");
        music.setTag(0);
        music.setMapPoint(MapPoint.mapPointWithGeoCoord(36.373962,127.343821));
        music.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        music.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(music);

        animal = new MapPOIItem();
        animal.setItemName("공동동물실험센터 앞");
        animal.setTag(0);
        animal.setMapPoint(MapPoint.mapPointWithGeoCoord(36.376476, 127.344007));
        animal.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        animal.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(animal);

        gym = new MapPOIItem();
        gym.setItemName("체육관 입구");
        gym.setTag(0);
        gym.setMapPoint(MapPoint.mapPointWithGeoCoord(36.372091, 127.343023));
        gym.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        gym.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(gym);

        west = new MapPOIItem();
        west.setItemName("서문");
        west.setTag(0);
        west.setMapPoint(MapPoint.mapPointWithGeoCoord(36.369180, 127.341296));
        west.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        west.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(west);

        socialscience = new MapPOIItem();
        socialscience.setItemName("사회과학대학 앞");
        socialscience.setTag(0);
        socialscience.setMapPoint(MapPoint.mapPointWithGeoCoord(36.366865, 127.342744));
        socialscience.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        socialscience.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(socialscience);

        sanhak = new MapPOIItem();
        sanhak.setItemName("산학연 앞");
        sanhak.setTag(0);
        sanhak.setMapPoint(MapPoint.mapPointWithGeoCoord(36.365903, 127.345315));
        sanhak.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        sanhak.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(sanhak);

        engineer1 = new MapPOIItem();
        engineer1.setItemName("공과대학1호관 앞");
        engineer1.setTag(0);
        engineer1.setMapPoint(MapPoint.mapPointWithGeoCoord(36.367175, 127.345497));
        engineer1.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        engineer1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(engineer1);
        ///////////////////////////////////////////////////////////////////////////////////////////
        mapViewContainer.addView(mapView);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.show_map_drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_map:
                        Toast.makeText(BusActivity.this, "Map Click", Toast.LENGTH_SHORT).show();
                        Intent mapIntent = new Intent(BusActivity.this, ShowMap_Activity.class);
                        startActivity(mapIntent);
                        finish();
                        break;

                    case R.id.navigation_road:
                        Toast.makeText(BusActivity.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent roadIntent = new Intent(BusActivity.this, FindWay_Activity.class);
                        startActivity(roadIntent);
                        finish();
                        break;
                    case R.id.navigation_sisul:
                        Toast.makeText(BusActivity.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent sisulIntent = new Intent(BusActivity.this, AroundArea_Activity.class);
                        startActivity(sisulIntent);
                        finish();
                        break;
                    case R.id.navigation_event:
                        Toast.makeText(BusActivity.this, "Event Click", Toast.LENGTH_SHORT).show();
                        Intent eventIntent = new Intent(BusActivity.this, EventActivity.class);
                        startActivity(eventIntent);
                        finish();
                        break;

                }
                return true;
            }
        });



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {
        if (mapPOIItem.equals(gyeongsang)){
            Intent intent=new Intent(BusActivity.this,gyeongsang_station.class);
            startActivity(intent);
        }

        if (mapPOIItem.equals(Hall)){
            Intent intent=new Intent(BusActivity.this,Hall_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(library_up)){
            Intent intent=new Intent(BusActivity.this,Libraryup_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(dormitary)){
            Intent intent=new Intent(BusActivity.this,dormitary_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(dongmun)){
            Intent intent=new Intent(BusActivity.this,dongmun_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(farmer)){
            Intent intent=new Intent(BusActivity.this,farmer_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(library_down)){
            Intent intent=new Intent(BusActivity.this,librarydown_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(art)){
            Intent intent=new Intent(BusActivity.this,art_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(music)){
            Intent intent=new Intent(BusActivity.this,Music_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(animal)){
            Intent intent=new Intent(BusActivity.this,animal_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(gym)){
            Intent intent=new Intent(BusActivity.this,Gym_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(west)){
            Intent intent=new Intent(BusActivity.this,West_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(socialscience)){
            Intent intent=new Intent(BusActivity.this,SocialScience_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(sanhak)){
            Intent intent=new Intent(BusActivity.this,Sanhak_station.class);
            startActivity(intent);
        }
        if (mapPOIItem.equals(engineer1)){
            Intent intent=new Intent(BusActivity.this,Engineer1_station.class);
            startActivity(intent);
        }
    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
