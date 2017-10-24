package com.psato.foundation.di.component;

import com.psato.foundation.data.model.Show;
import com.psato.foundation.di.LoaderScoped;
import com.psato.foundation.presentation.summary.SummaryVMLoader;

import dagger.BindsInstance;
import dagger.Component;

@LoaderScoped
@Component(dependencies = {ApplicationComponent.class})
public interface ShowSummaryComponent {
    void inject(SummaryVMLoader.ViewModelHolder viewModelHolder);

    @Component.Builder
    interface Builder {
        ShowSummaryComponent build();

        Builder applicationComponent(ApplicationComponent component);

        @BindsInstance
        Builder show(Show show);
    }
}
