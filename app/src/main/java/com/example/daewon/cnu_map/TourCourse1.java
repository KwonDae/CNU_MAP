package com.example.daewon.cnu_map;

import android.content.Intent;
import android.graphics.Color;
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

import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapView;

public class TourCourse1 extends BaseActivity implements MapView.POIItemEventListener, NavigationView.OnNavigationItemSelectedListener {

    private MapView mapView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_course1);

        mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view4);
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(36.370082,127.346223), true);
        mapView.setZoomLevel(1,true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);

        mapView.setPOIItemEventListener(this);
        MapPolyline polyline = new MapPolyline();
        polyline.setTag(1000);
        polyline.setLineColor(Color.argb(255,255,194,214));

        // polyLine 좌표 지정.
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.362750, 127.344862));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.369231, 127.345908));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.369791, 127.347164));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.371337, 127.347346));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.372691, 127.346060));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.371595, 127.345453));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.370433, 127.344016));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.369231, 127.345908));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.369964, 127.347768));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.370664, 127.348508));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.368910, 127.349967));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.369446, 127.351126));
        mapView.addPolyline(polyline);
        MapPointBounds mapPointBounds = new MapPointBounds(polyline.getMapPoints());
        int padding = 100;
        mapView.moveCamera(CameraUpdateFactory.newMapPointBounds(mapPointBounds, padding));
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
                        Toast.makeText(TourCourse1.this, "Map Click", Toast.LENGTH_SHORT).show();
                        Intent mapIntent = new Intent(TourCourse1.this, ShowMap_Activity.class);
                        startActivity(mapIntent);
                        finish();
                        break;

                    case R.id.navigation_road:
                        Toast.makeText(TourCourse1.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent roadIntent = new Intent(TourCourse1.this, FindWay_Activity.class);
                        startActivity(roadIntent);
                        finish();
                        break;
                    case R.id.navigation_sisul:
                        Toast.makeText(TourCourse1.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent sisulIntent = new Intent(TourCourse1.this, AroundArea_Activity.class);
                        startActivity(sisulIntent);
                        finish();
                        break;
                    case R.id.navigation_event:
                        Toast.makeText(TourCourse1.this, "Event Click", Toast.LENGTH_SHORT).show();
                        Intent eventIntent = new Intent(TourCourse1.this, EventActivity.class);
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
