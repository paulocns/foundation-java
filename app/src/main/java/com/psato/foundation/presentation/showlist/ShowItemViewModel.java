package com.psato.foundation.presentation.showlist;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.psato.foundation.data.model.ShowInfo;
import com.psato.foundation.presentation.summary.SummaryActivity;

/**
 * Created by psato on 30/10/16.
 */

public class ShowItemViewModel extends BaseObservable {

    private ShowInfo mShowInfo;

    public ShowItemViewModel(ShowInfo showInfo) {
        mShowInfo = showInfo;
    }

    @Bindable
    public String getShowName(){
        return mShowInfo.getShow().getTitle();
    }

    @Bindable
    public String getScore(){
        return mShowInfo.getScore();
    }

    public void onShowCLicked(View v){
        Intent intent =  new Intent(v.getContext(), SummaryActivity.class);
        intent.putExtra("SHOW",mShowInfo.getShow());
        v.getContext().startActivity(intent);
    }
}
