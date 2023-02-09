package com.dasmic.android.lib.message.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.dasmic.android.lib.message.Enum.AppOptions;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Chaitanya Belwal on 8/19/2017.
 */

public class ActivityBaseAd extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    protected void setVersionBasedUI(MenuItem item,
                                     boolean showAds) {
        AdView mAdView = (AdView) findViewById(R.id.adView);

        if (AppOptions.isFreeVersion) {
            //Ads
            if (mAdView != null && showAds) {
                mAdView.setVisibility(View.VISIBLE);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
            }
            if (item != null) //Purchase Menu
                item.setVisible(true);
        } else { //Paid version
            //Ads
            if (mAdView != null) {
                mAdView.setVisibility(View.GONE);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
            }
            if (item != null) //Purchase Menu
                item.setVisible(false);
        }
    }


}