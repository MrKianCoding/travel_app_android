package com.example.travel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPagerLocation;
    BottomNavigationView bottomNavigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerLocation = findViewById(R.id.viewPagerLocation);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setItemIconTintList(null);

        List<TravelLocationModel> travelLocationModelList = new ArrayList<>();

        TravelLocationModel travelLocationIstanbul = new TravelLocationModel();
        travelLocationIstanbul.photo = this.getResources().getDrawable(R.drawable.istanbul);
        travelLocationIstanbul.title = "Istanbul";
        travelLocationIstanbul.description = "Turkey, Istanbul";
        travelLocationIstanbul.starRating = 4.4f;
        travelLocationModelList.add(travelLocationIstanbul);

        TravelLocationModel travelLocationParis = new TravelLocationModel();
        travelLocationParis.photo = this.getResources().getDrawable(R.drawable.paris);
        travelLocationParis.title = "Paris";
        travelLocationParis.description = "France, paris";
        travelLocationParis.starRating = 4.5f;
        travelLocationModelList.add(travelLocationParis);

        TravelLocationModel travelLocationLondon = new TravelLocationModel();
        travelLocationLondon.photo = this.getResources().getDrawable(R.drawable.london);
        travelLocationLondon.title = "London";
        travelLocationLondon.description = "United Kingdom, London";
        travelLocationLondon.starRating = 4.4f;
        travelLocationModelList.add(travelLocationLondon);

        TravelLocationModel travelLocationMumbai = new TravelLocationModel();
        travelLocationMumbai.photo = this.getResources().getDrawable(R.drawable.mumbai);
        travelLocationMumbai.title = "Mumbai";
        travelLocationMumbai.description = "India, Mumbai";
        travelLocationMumbai.starRating = 4.3f;
        travelLocationModelList.add(travelLocationMumbai);

        TravelLocationModel travelLocationWashington = new TravelLocationModel();
        travelLocationWashington.photo = this.getResources().getDrawable(R.drawable.washington);
        travelLocationWashington.title = "Washington";
        travelLocationWashington.description = "United states, Washington";
        travelLocationWashington.starRating = 4.6f;
        travelLocationModelList.add(travelLocationWashington);

        viewPagerLocation.setAdapter(new TravelLocationAdapter(travelLocationModelList));


        viewPagerLocation.setClipToPadding(false);
        viewPagerLocation.setClipChildren(false);
        viewPagerLocation.setOffscreenPageLimit(3);
        viewPagerLocation.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });

        viewPagerLocation.setPageTransformer(compositePageTransformer);

    }
}