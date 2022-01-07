package com.example.ftc_freight_frenzy_scorer;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final MatchListAdapter adapter = new MatchListAdapter(new MatchListAdapter.MatchDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        MatchViewModel mWordViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        // Update the cached copy of the words in the adapter.
        mWordViewModel.getAllMatches().observe(this, adapter::submitList);

    }
}
