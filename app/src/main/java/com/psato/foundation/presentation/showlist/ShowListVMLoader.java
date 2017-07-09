package com.psato.foundation.presentation.showlist;

import android.content.Context;

import com.psato.foundation.di.component.ApplicationComponent;
import com.psato.foundation.di.component.DaggerSearchShowComponent;
import com.psato.foundation.di.component.SearchShowComponent;
import com.psato.foundation.presentation.base.BaseViewModel;
import com.psato.foundation.presentation.base.ViewModelLoader;

import javax.inject.Inject;

/**
 * Created by psato on 29/10/16.
 */

public class ShowListVMLoader extends ViewModelLoader {
    private SearchShowComponent mSearchShowComponent;
    private ApplicationComponent mApplicationComponent;
    public ShowListVMLoader(Context context, ApplicationComponent appComponent) {
        super(context);
        mApplicationComponent = appComponent;
    }

    @Override
    protected BaseViewModel initializeInjector() {
        mSearchShowComponent = DaggerSearchShowComponent.builder()
                .applicationComponent(mApplicationComponent).build();
        ViewModelHolder viewModelHolder =  new ViewModelHolder();
        mSearchShowComponent.inject(viewModelHolder);
        return viewModelHolder.mViewModel;
    }

    @Override
    protected void onReset() {
        super.onReset();
        mSearchShowComponent = null;
    }

    public class ViewModelHolder{
        @Inject
        ShowListViewModel mViewModel;

        private ViewModelHolder(){

        }
    }
}
