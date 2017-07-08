package com.psato.devfest.data.repository.show;

import com.psato.devfest.data.model.ShowInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by psato on 29/06/16.
 */

public interface ShowRepository {
    Observable<List<ShowInfo>> searchShow(String query);
}
