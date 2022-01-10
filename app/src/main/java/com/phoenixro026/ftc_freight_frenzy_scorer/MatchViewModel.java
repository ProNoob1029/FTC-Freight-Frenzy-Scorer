package com.phoenixro026.ftc_freight_frenzy_scorer;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

/**
 * View Model to keep a reference to the word repository and
 * an up-to-date list of all words.
 */

public class MatchViewModel extends AndroidViewModel {

    private final MatchRepository mRepository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private final LiveData<List<Match>> mAllMatches;
    private final LiveData<List<Match>> mAllMatchesDesc;

    public MatchViewModel(Application application) {
        super(application);
        mRepository = new MatchRepository(application);
        mAllMatches = mRepository.getAllMatches();
        mAllMatchesDesc = mRepository.getAllMatchesDesc();
    }

    LiveData<List<Match>> getAllMatches() {
        return mAllMatches;
    }

    LiveData<List<Match>> getAllMatchesDesc() {
        return mAllMatchesDesc;
    }

    void insert(Match match) {
        mRepository.insert(match);
    }

    void update(Match match) {
        mRepository.update(match);
    }
}
