package com.psato.foundation.presentation.bindadapter;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.psato.foundation.data.model.ShowInfo;
import com.psato.foundation.presentation.showlist.ShowListAdapter;

import java.util.List;

/**
 * Created by psato on 29/10/16.
 */

public class RecyclerViewBindingAdapter {

    @BindingAdapter("data")
    public static void setData(RecyclerView recyclerView, List<ShowInfo> infoList){
        if(infoList != null){
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if(adapter instanceof ShowListAdapter){
                ShowListAdapter showListAdapter = (ShowListAdapter) adapter;
                showListAdapter.setData(infoList);
            }
        }
    }
}
