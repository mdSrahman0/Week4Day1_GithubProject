/**
 * 1. Create an application with two screen
 *         -Screen one: should have your Github profile. Use at least 4 fields from the response to
 *         update the views.
 *         -Screen 2: Populate the recyclerView with the repositories you get from your profile.
 *         Use at least 3 fields in each item view.
 */

package com.example.week4day1_githubproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.week4day1_githubproject.model.GithubResponse;
import com.example.week4day1_githubproject.model.OkHttpClass;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplayUser;
    TextView tvDisplayBio;
    TextView tvDisplayCompany;
    TextView tvDisplayLocaiton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplayUser = findViewById(R.id.tvDisplayUser);
        tvDisplayBio = findViewById(R.id.tvDisplayBio);
        tvDisplayCompany = findViewById(R.id.tvDisplayCompany);
        tvDisplayLocaiton = findViewById(R.id.tvDisplayLocation);

        OkHttpClass okHttpClass = new OkHttpClass();
        okHttpClass.getAsyncResponse();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Register to EventBus
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Unregister to EventBus
        EventBus.getDefault().unregister(this);
    }

    //Subscribe to the posting event on EventBus that is passing a UserResponse
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void userResponseEvent(GithubResponse githubResponse) {
        Log.d("TAG_EVENT_RECEIVED", githubResponse.getName());
        tvDisplayUser.setText("Name: " + githubResponse.getName());
        tvDisplayBio.setText("Bio: " + githubResponse.getBio());
        tvDisplayCompany.setText("Company: " + githubResponse.getCompany());
        tvDisplayLocaiton.setText("Location: " + githubResponse.getLocation());
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }
}
