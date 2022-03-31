package com.ali.retrofitapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.pgamer.repl.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<RecentlyAdded>> call = jsonPlaceHolderApi.getSubbed();
        call.enqueue(new Callback<List<RecentlyAdded>>() {
            @Override
            public void onResponse(Call<List<RecentlyAdded>> call, Response<List<RecentlyAdded>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }
                List<RecentlyAdded> subbed = response.body();
                textView.setText(" ");
                for (RecentlyAdded item: subbed) {
                    String content = "";
                    content += "Title: " + item.getTitle() + "\n";
                    content += "Episode: " + item.getEpisode() + "\n";
                    content += "Date" + item.getDate() + "\n";
                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<RecentlyAdded>> call, Throwable t) {
                textView.setText(t.getMessage());

            }
        });


    }
}