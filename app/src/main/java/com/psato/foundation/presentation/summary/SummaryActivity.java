package com.psato.foundation.presentation.summary;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.psato.foundation.R;
import com.psato.foundation.data.model.Show;


public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_summary);
        if (savedInstanceState == null) {
            Show show = (Show) getIntent().getSerializableExtra("SHOW");
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_content, SummaryFragment.getNewInstance(show))
                    .commit();
        }
    }
}
