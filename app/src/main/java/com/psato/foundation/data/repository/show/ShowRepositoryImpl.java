package com.psato.foundation.data.repository.show;

import com.psato.foundation.data.model.Show;
import com.psato.foundation.data.model.ShowInfo;
import com.psato.foundation.data.remote.TraktAPI;

import java.util.List;

import rx.Observable;

/**
 * Created by psato on 29/06/16.
 */

public class ShowRepositoryImpl implements ShowRepository {
    private TraktAPI mTraktAPI;

    public ShowRepositoryImpl(TraktAPI traktAPI) {
        mTraktAPI = traktAPI;
    }

    @Override
    public Observable<List<ShowInfo>> searchShow(final String query) {
        return mTraktAPI.searchForShows(query, 100);
    }

    @Override
    public Observable<Show> showSummary(String id) {
        return  mTraktAPI.showSummary(id, "full");
    }


}
