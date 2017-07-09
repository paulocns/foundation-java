package com.psato.foundation.presentation.showlist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psato.foundation.R;
import com.psato.foundation.databinding.FragmentShowListBinding;
import com.psato.foundation.infrastructure.Constants;
import com.psato.foundation.infrastructure.FoundationApplication;
import com.psato.foundation.presentation.base.BaseFragment;
import com.psato.foundation.presentation.utils.DividerDecoration;

import java.lang.ref.WeakReference;

/**
 * Created by psato on 29/10/16.
 */

public class ShowListFragment extends BaseFragment {

    private FragmentShowListBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_list, container, false);
        mBinding = DataBindingUtil.bind(view);
        mBinding.showListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.showListRecyclerView.setAdapter(new ShowListAdapter());
        mBinding.showListRecyclerView.addItemDecoration(new DividerDecoration.Builder(getContext()).build());
        getLoaderManager().initLoader(Constants.LoaderID.SHOW_LIST_ID, new Bundle(), new LoaderCallBack(this));
        return view;
    }


    private void bindViewModel(ShowListViewModel viewModel) {
        mBinding.setViewModel(viewModel);
        mBinding.executePendingBindings();
    }

    @Override
    public void onDestroyView() {
        mBinding = null;
        super.onDestroyView();
    }

    private static class LoaderCallBack implements LoaderManager.LoaderCallbacks {

        private WeakReference<ShowListFragment> mFragmentReference;

        LoaderCallBack(ShowListFragment fragment) {
            mFragmentReference = new WeakReference<>(fragment);
        }

        @Override
        public Loader onCreateLoader(int id, Bundle args) {
            ShowListFragment fragment = mFragmentReference.get();
            if (fragment != null) {
                FoundationApplication app = (FoundationApplication) fragment.getActivity().getApplication();
                return new ShowListVMLoader(fragment.getContext(), app.getApplicationComponent());
            }
            return null;
        }

        @Override
        public void onLoadFinished(Loader loader, Object data) {
            ShowListFragment fragment = mFragmentReference.get();
            if (fragment != null) {
                fragment.bindViewModel((ShowListViewModel) data);
            }
        }

        @Override
        public void onLoaderReset(Loader loader) {
            loader.reset();
        }
    }
}
