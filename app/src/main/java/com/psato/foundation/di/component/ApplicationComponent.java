package com.psato.foundation.di.component;

import com.psato.foundation.data.repository.show.ShowRepository;
import com.psato.foundation.di.module.ApplicationModule;
import com.psato.foundation.di.module.NetworkModule;
import com.psato.foundation.di.module.ShowRepositoryModule;
import com.psato.foundation.infrastructure.FoundationApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by psato on 29/10/16.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
        ShowRepositoryModule.class
})
public interface ApplicationComponent {
    // expose to sub graphs

    FoundationApplication application();

    ShowRepository showRepository();
}
