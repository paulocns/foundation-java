package com.psato.devfest.interactor.usecase.show;

import com.psato.devfest.data.repository.show.ShowRepository;
import com.psato.devfest.interactor.usecase.UseCase;

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
