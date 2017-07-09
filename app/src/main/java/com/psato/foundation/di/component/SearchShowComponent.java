package com.psato.foundation.di.component;

import com.psato.foundation.di.LoaderScoped;
import com.psato.foundation.presentation.showlist.ShowListVMLoader;

import dagger.Component;


@LoaderScoped
@Component(dependencies = {ApplicationComponent.class})
public interface SearchShowComponent {
    void inject(ShowListVMLoader.ViewModelHolder viewModelHolder);
}
