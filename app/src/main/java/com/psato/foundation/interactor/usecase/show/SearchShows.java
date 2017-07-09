package com.psato.foundation.interactor.usecase.show;

import com.psato.foundation.data.repository.show.ShowRepository;
import com.psato.foundation.interactor.usecase.UseCase;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by psato on 29/10/16.
 */

public class SearchShows extends UseCase {
    private ShowRepository mShowRepository;
    private String mQuery;

    @Inject
    public SearchShows(ShowRepository showRepository) {
        mShowRepository = showRepository;
    }

    public void setQuery(String query) {
        mQuery = query;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mShowRepository.searchShow(mQuery);
    }
}
