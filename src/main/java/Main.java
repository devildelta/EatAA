package org.eataa;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import roboguice.activity.RoboActivity;

import org.eataa.R;

@ContentView(R.layout.main_layout)
public class Main extends RoboActivity {
    @InjectView(R.id.text1) TextView hello;

    @Override
    protected void onCreate(Bundle state) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(state);
        hello.setText("Hello!");
    }
}

