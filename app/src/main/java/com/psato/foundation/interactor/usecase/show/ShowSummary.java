package com.psato.foundation.interactor.usecase.show;

import com.psato.foundation.data.repository.show.ShowRepository;
import com.psato.foundation.interactor.usecase.UseCase;

import javax.inject.Inject;

import rx.Observable;

public class ShowSummary extends UseCase{

    private ShowRepository mShowRepository;

    private String mShowId;

    @Inject
    public ShowSummary(ShowRepository showRepository) {
        mShowRepository = showRepository;
    }

    public void setShowId(String showId) {
        mShowId = showId;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mShowRepository.showSummary(mShowId);
    }
}
