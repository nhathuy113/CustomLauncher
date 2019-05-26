package com.example.customlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PackageName: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable appIcon;
        //
        final ImageView chromeIcon = (ImageView) findViewById(R.id.chromeButton);
        final ImageView mapsIcon = (ImageView) findViewById(R.id.mapsButton);

        try {
            // Chrome
            appIcon = getPackageManager().getApplicationIcon("com.android.chrome");
            chromeIcon.setImageDrawable(appIcon);

            chromeIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
                    startActivity(launchIntent);
                }
            });

            // Maps
            appIcon = getPackageManager().getApplicationIcon("com.google.android.apps.maps");
            mapsIcon.setImageDrawable(appIcon);

            mapsIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
                    startActivity(launchIntent);
                }
            });
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        //chromeIcon.setImageDrawable(this, getActivityIcon("com.android.chrome", "com.google.android.apps.chrome.Main"));
    }
}
