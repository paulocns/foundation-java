package com.psato.foundation.presentation.summary;

import android.databinding.Bindable;
import android.util.Log;

import com.psato.foundation.BR;
import com.psato.foundation.data.model.Show;
import com.psato.foundation.interactor.rx.DefaultSubscriber;
import com.psato.foundation.interactor.usecase.show.ShowSummary;
import com.psato.foundation.presentation.base.BaseViewModel;

import javax.inject.Inject;

/**
 * Created by psato on 29/10/16.
 */

public class SummaryViewModel extends BaseViewModel {

    private Show mShow;
    private ShowSummary mShowSummary;
    private String mOverview = "";
    private boolean mShowLoading;

    @Inject
    public SummaryViewModel(Show show, ShowSummary showSummary) {
        mShow = show;
        mShowSummary = showSummary;
    }

    @Bindable
    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        if (!mOverview.equals(overview)) {
            mOverview = overview;
            notifyPropertyChanged(BR.overview);
        }
    }

    @Bindable
    public boolean getShowLoading(){
        return mShowLoading;
    }

    public void setShowLoading(boolean isLoading){
        if(isLoading != mShowLoading){
            mShowLoading = isLoading;
            notifyPropertyChanged(BR.showLoading);
        }
    }

    @Inject
    @Override
    public void start() {
        showSummary(mShow.getIds().getTrakt());
    }

    @Override
    public void stop() {

    }

    private void showSummary(String id){
        if(mShowSummary != null) {
            setShowLoading(true);
            mShowSummary.unsubscribe();
            mShowSummary.setShowId(id);
            mShowSummary.execute(new SummarySubscriber());
        }
    }

    private class SummarySubscriber extends DefaultSubscriber<Show>{

        @Override
        public void onError(Throwable e) {
            setShowLoading(false);
            Log.e("SATO","onError",e);
        }

        @Override
        public void onNext(Show show) {
            setShowLoading(false);
            setOverview(show.getOverview());
        }
    }

}
