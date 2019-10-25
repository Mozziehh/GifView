package com.example.wubagifview;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;

public class WubaHybridApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
