package com.psato.foundation.presentation.summary;

import android.content.Context;

import com.psato.foundation.data.model.Show;
import com.psato.foundation.di.component.ApplicationComponent;
import com.psato.foundation.di.component.DaggerShowSummaryComponent;
import com.psato.foundation.presentation.base.BaseViewModel;
import com.psato.foundation.presentation.base.ViewModelLoader;

import javax.inject.Inject;

public class SummaryVMLoader extends ViewModelLoader {

    private ApplicationComponent mApplicationComponent;

    private Show mShow;


    public SummaryVMLoader(Context context, ApplicationComponent appComponent, Show show) {
        super(context);
        mApplicationComponent = appComponent;
        mShow = show;
    }

    @Override
    protected BaseViewModel initializeInjector() {
        ViewModelHolder holder = new ViewModelHolder();
        DaggerShowSummaryComponent.builder().applicationComponent(mApplicationComponent).show(mShow).build().inject(holder);

        return holder.mViewModel;
    }

    public class ViewModelHolder{
        @Inject
        SummaryViewModel mViewModel;

        private ViewModelHolder(){

        }
    }
}
