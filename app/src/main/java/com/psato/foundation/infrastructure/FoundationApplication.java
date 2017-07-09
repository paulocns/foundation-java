package com.psato.foundation.infrastructure;

import android.app.Application;

import com.psato.foundation.di.component.ApplicationComponent;
import com.psato.foundation.di.component.DaggerApplicationComponent;
import com.psato.foundation.di.module.ApplicationModule;

/**
 * Created by psato on 29/10/16.
 */

public class FoundationApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
