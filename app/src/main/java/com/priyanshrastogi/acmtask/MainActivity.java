package com.priyanshrastogi.acmtask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CardAdapter mAdapter;

    private static final String REQUEST_URL = "https://raw.githubusercontent.com/ACM-SNU/projects-android-task/master/json/details.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.mRecyclerView);
        mAdapter = new CardAdapter(this, new ArrayList<Card>());
        recyclerView.setAdapter(mAdapter);

        MainAsyncTask task = new MainAsyncTask();
        task.execute(REQUEST_URL);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private class MainAsyncTask extends AsyncTask<String, Void, List<Card>> {

        @Override
        protected List<Card> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<Card> result = FetchData.fetchFromUrl(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<Card> data) {
            mAdapter.clear();

            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }
        }
    }
}
