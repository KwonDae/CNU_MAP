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

public class TourCourse2 extends BaseActivity implements MapView.POIItemEventListener, NavigationView.OnNavigationItemSelectedListener {

    private MapView mapView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_course2);

        mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view5);
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(36.370082,127.346223), true);
        mapView.setZoomLevel(1,true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);

        mapView.setPOIItemEventListener(this);
        MapPolyline polyline = new MapPolyline();
        polyline.setTag(1000);
        polyline.setLineColor(Color.argb(128,255,51,0));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.362750, 127.344862));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.363353, 127.345995));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.363502, 127.345514));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.364402, 127.345163));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.365771, 127.344553));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.366131, 127.343951));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.366831, 127.342953));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.367811, 127.341427));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.368866, 127.341524));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.369857, 127.341046));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.370357, 127.342869));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.371376, 127.342907));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.375522, 127.344211));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.370480, 127.343586));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.370444, 127.344020));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.371662, 127.345518));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.372711, 127.346079));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(36.371348, 127.347360));
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
                        Toast.makeText(TourCourse2.this, "Map Click", Toast.LENGTH_SHORT).show();
                        Intent mapIntent = new Intent(TourCourse2.this, ShowMap_Activity.class);
                        startActivity(mapIntent);
                        finish();
                        break;

                    case R.id.navigation_road:
                        Toast.makeText(TourCourse2.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent roadIntent = new Intent(TourCourse2.this, FindWay_Activity.class);
                        startActivity(roadIntent);
                        finish();
                        break;
                    case R.id.navigation_sisul:
                        Toast.makeText(TourCourse2.this, "Road Click", Toast.LENGTH_SHORT).show();
                        Intent sisulIntent = new Intent(TourCourse2.this, AroundArea_Activity.class);
                        startActivity(sisulIntent);
                        finish();
                        break;
                    case R.id.navigation_event:
                        Toast.makeText(TourCourse2.this, "Event Click", Toast.LENGTH_SHORT).show();
                        Intent eventIntent = new Intent(TourCourse2.this, EventActivity.class);
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
