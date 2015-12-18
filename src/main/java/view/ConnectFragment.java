package org.eataa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import roboguice.inject.InjectView;

import org.eataa.R;

public class ConnectFragment extends Main.AAFragment {
    @InjectView(R.id.text2) TextView text2;
    public String getTitle() {return "Connect";}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        return inflater.inflate(R.layout.connect, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text2.setText("connect fragment");
    }

}
