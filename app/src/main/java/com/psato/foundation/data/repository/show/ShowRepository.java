package com.psato.foundation.data.repository.show;

import com.psato.foundation.data.model.Show;
import com.psato.foundation.data.model.ShowInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by psato on 29/06/16.
 */

public interface ShowRepository {
    Observable<List<ShowInfo>> searchShow(String query);
    Observable<Show> showSummary(String id);
}
