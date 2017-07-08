package com.psato.devfest.presentation.showlist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.psato.devfest.R;
import com.psato.devfest.databinding.ActivityListBinding;

public class ShowListActivity extends AppCompatActivity {

    private ActivityListBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_content, new ShowListFragment())
                    .commit();
        }
    }
}
