package com.san.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class StoryActivity extends AppCompatActivity  implements TextToSpeech.OnInitListener {
    TextView textView;
    private TextToSpeech tts;
    Button readButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        tts = new TextToSpeech(this, this);


        textView = findViewById(R.id.txt);
       String dstory= getIntent().getStringExtra("position");
       textView.setText(dstory);
       readButton = findViewById(R.id.btn_read);

    }

    public void textToSpeech(View view) {
        tts.speak(textView.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                readButton.setEnabled(true);
              //  speakOut();
            }

        } else { Log.e("TTS", "Initilization Failed!");}

    }
}