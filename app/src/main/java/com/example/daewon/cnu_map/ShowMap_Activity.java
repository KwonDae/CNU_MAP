package com.example.daewon.cnu_map;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class ShowMap_Activity extends BaseActivity implements MapView.POIItemEventListener, NavigationView.OnNavigationItemSelectedListener{

    private MapView mapView;
    private MapPOIItem library_marker, engineer1,engineer5, gyeongsang, campusCenter, Hall,
            sanhak, engineer2,engineer3,engineer4, mainGate, studentUnion2,studentUnion1,studentUnion3,
            social,medicine,science, cultured;
    private MapPoint mypoint = MapPoint.mapPointWithGeoCoord(36.370082, 127.346223);
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_map_);


        mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(36.370082,127.346223), true);
        mapView.setZoomLevel(1,true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);
        /////////////////////////////////////////////////////////////////////////////////////////////
        // Location List

        mapView.setPOIItemEventListener(this);
        library_marker = new MapPOIItem();
        library_marker.setItemName("중앙도서관");
        library_marker.setTag(0);
        library_marker.setMapPoint(mypoint);
        library_marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        library_marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(library_marker);

        engineer1 = new MapPOIItem();
        engineer1.setItemName("공과대학 1호관");
        engineer1.setTag(0);
        engineer1.setMapPoint(MapPoint.mapPointWithGeoCoord(36.367603,127.344742));
        engineer1.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        engineer1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(engineer1);


        gyeongsang = new MapPOIItem();
        gyeongsang.setItemName("경상대학");
        gyeongsang.setTag(0);
        gyeongsang.setMapPoint(MapPoint.mapPointWithGeoCoord(36.367439,127.346160));
        gyeongsang.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        gyeongsang.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(gyeongsang);

        engineer5 = new MapPOIItem();
        engineer5.setItemName("공과대학 5호관");
        engineer5.setTag(0);
        engineer5.setMapPoint(MapPoint.mapPointWithGeoCoord(36.366667,127.344359));
        engineer5.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        engineer5.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        engineer5.isMoveToCenterOnSelect();
        mapView.addPOIItem(engineer5);

        campusCenter = new MapPOIItem();
        campusCenter.setItemName("대학본부");
        campusCenter.setTag(0);
        campusCenter.setMapPoint(MapPoint.mapPointWithGeoCoord(36.368978,127.346882));
        campusCenter.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        campusCenter.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(campusCenter);

        Hall = new MapPOIItem();
        Hall.setItemName("정심화국제 문화회관");
        Hall.setTag(0);
        Hall.setMapPoint(MapPoint.mapPointWithGeoCoord(36.363095,127.346031));
        Hall.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        Hall.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(Hall);

        sanhak = new MapPOIItem();
        sanhak.setItemName("산학연교육연구관");
        sanhak.setTag(0);
        sanhak.setMapPoint(MapPoint.mapPointWithGeoCoord(36.365682,127.344672));
        sanhak.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        sanhak.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(sanhak);

        engineer2 = new MapPOIItem();
        engineer2.setItemName("공과대학 2호관");
        engineer2.setTag(0);
        engineer2.setMapPoint(MapPoint.mapPointWithGeoCoord(36.364334,127.346321));
        engineer2.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        engineer2.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(engineer2);

        mainGate = new MapPOIItem();
        mainGate.setItemName("정문");
        mainGate.setTag(0);
        mainGate.setMapPoint(MapPoint.mapPointWithGeoCoord(36.362765,127.344839));
        mainGate.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        mainGate.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(mainGate);

        engineer3 = new MapPOIItem();
        engineer3.setItemName("공과대학 3호관");
        engineer3.setTag(0);
        engineer3.setMapPoint(MapPoint.mapPointWithGeoCoord(36.365201,127.346612));
        engineer3.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        engineer3.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(engineer3);

        engineer4 = new MapPOIItem();
        engineer4.setItemName("공과대학 4호관");
        engineer4.setTag(0);
        engineer4.setMapPoint(MapPoint.mapPointWithGeoCoord(36.365029,127.347682));
        engineer4.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        engineer4.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(engineer4);

        studentUnion2 = new MapPOIItem();
        studentUnion2.setItemName("제2후생관");
        studentUnion2.setTag(0);
        studentUnion2.setMapPoint(MapPoint.mapPointWithGeoCoord(36.365958,127.345839));
        studentUnion2.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        studentUnion2.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(studentUnion2);

        studentUnion1 = new MapPOIItem();
        studentUnion1.setItemName("제1후생관");
        studentUnion1.setTag(0);
        studentUnion1.setMapPoint(MapPoint.mapPointWithGeoCoord(36.367833,127.343307));
        studentUnion1.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        studentUnion1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(studentUnion1);

        studentUnion3 = new MapPOIItem();
        studentUnion3.setItemName("제3후생관");
        studentUnion3.setTag(0);
        studentUnion3.setMapPoint(MapPoint.mapPointWithGeoCoord(36.371410,127.344823));
        studentUnion3.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        studentUnion3.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(studentUnion3);

        social = new MapPOIItem();
        social.setItemName("사회과학대학");
        social.setTag(0);
        social.setMapPoint(MapPoint.mapPointWithGeoCoord(36.366419,127.342217));
        social.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        social.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(social);

        medicine = new MapPOIItem();
        medicine.setItemName("약학대학");
        medicine.setTag(0);
        medicine.setMapPoint(MapPoint.mapPointWithGeoCoord(36.368968,127.343181));
        medicine.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        medicine.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(medicine);

        science = new MapPOIItem();
        science.setItemName("자연과학대학");
        science.setTag(0);
        science.setMapPoint(MapPoint.mapPointWithGeoCoord(36.366869,127.340166));
        science.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        science.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(science);

        cultured = new MapPOIItem();
        cultured.setItemName("백마교양교육관");
        cultured.setTag(0);
        cultured.setMapPoint(MapPoint.mapPointWithGeoCoord(36.367862,127.341175));
        cultured.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        cultured.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(cultured);
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

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    // net.daum.mf.map.api.MapView.POIItemEventListener
    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {
        if (mapPOIItem.equals(library_marker)){
            Intent intent=new Intent(ShowMap_Activity.this,Detail_place_Activity.class);
            String url="http://place.map.daum.net/8105719";
            intent.putExtra("library_url",url);
            startActivity(intent);

        }
    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
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
}
