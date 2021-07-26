package com.san.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        String [] tStory = getResources().getStringArray(R.array.story_titles);
        String [] detailsedStoryArray = getResources().getStringArray(R.array.detail_story);
        listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.row,R.id.rowTxt,tStory);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String detailedStory = detailsedStoryArray[position];
                Intent intent=new Intent(MainActivity.this,StoryActivity.class);
                intent.putExtra("position",detailedStory);
                startActivity(intent);
            }
        });

    }
}