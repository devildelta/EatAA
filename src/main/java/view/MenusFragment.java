package org.eataa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import roboguice.inject.InjectView;

import org.eataa.R;

public class MenusFragment extends Main.AAFragment {
    @InjectView(R.id.text1) TextView text1;

    @Override
    public String getTitle() {return "Menus";}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menus, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text1.setText("menus fragment");
    }
}
