package com.psato.foundation.presentation.summary;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psato.foundation.R;
import com.psato.foundation.data.model.Show;
import com.psato.foundation.databinding.FragmentSummaryBinding;
import com.psato.foundation.infrastructure.Constants;
import com.psato.foundation.infrastructure.FoundationApplication;
import com.psato.foundation.presentation.base.BaseFragment;

import java.lang.ref.WeakReference;

/**
 * Created by psato on 29/10/16.
 */

public class SummaryFragment extends BaseFragment {

    private static final String SHOW = "SHOW";

    public static SummaryFragment getNewInstance(Show show) {
        SummaryFragment fragment = new SummaryFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(SHOW,show);
        fragment.setArguments(bundle);
        return fragment;
    }

    private FragmentSummaryBinding mBinding;
    private Show mShow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        mBinding = DataBindingUtil.bind(view);
        mShow = (Show) getArguments().getSerializable(SHOW);
        getLoaderManager().initLoader(Constants.LoaderID.SUMMARY_ID, new Bundle(), new LoaderCallBack(this));
        return view;
    }

    private void bindViewModel(SummaryViewModel viewModel) {
        mBinding.setViewModel(viewModel);
        mBinding.executePendingBindings();
    }

    @Override
    public void onDestroyView() {
        mBinding = null;
        super.onDestroyView();
    }

    private static class LoaderCallBack implements LoaderManager.LoaderCallbacks {

        private WeakReference<SummaryFragment> mFragmentReference;

        LoaderCallBack(SummaryFragment fragment) {
            mFragmentReference = new WeakReference<>(fragment);
        }

        @Override
        public Loader onCreateLoader(int id, Bundle args) {
            SummaryFragment fragment = mFragmentReference.get();
            if (fragment != null) {
                FoundationApplication app = (FoundationApplication) fragment.getActivity().getApplication();
                return new SummaryVMLoader(fragment.getContext(), app.getApplicationComponent(), fragment.mShow);
            }
            return null;
        }

        @Override
        public void onLoadFinished(Loader loader, Object data) {
            SummaryFragment fragment = mFragmentReference.get();
            if (fragment != null) {
                fragment.bindViewModel((SummaryViewModel) data);
            }
        }

        @Override
        public void onLoaderReset(Loader loader) {
            loader.reset();
        }
    }
}
