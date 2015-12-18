package org.eataa;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.Window;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v13.app.FragmentPagerAdapter;

import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import roboguice.activity.RoboActivity;
import roboguice.fragment.provided.RoboFragment;

import org.eataa.R;

@ContentView(R.layout.main)
public class Main extends RoboActivity {
    @InjectView(R.id.pager) ViewPager pager;

    @Override
    protected void onCreate(Bundle state) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getApplicationInfo().targetSdkVersion = 14;
        super.onCreate(state);
        pager.setAdapter(new AAPagerAdapter());

    }

    public class AAPagerAdapter extends FragmentPagerAdapter {
        ArrayList<AAFragment> fragments;
        public AAPagerAdapter() {
            super(Main.this.getFragmentManager());
            fragments = new ArrayList<AAFragment>();
            fragments.add(new MenusFragment());
            fragments.add(new ConnectFragment());
        }
        @Override public int getCount() {
            return fragments.size();
        }
        @Override public Fragment getItem(int i) {
            return fragments.get(i);
        }
        @Override public CharSequence getPageTitle (int i) {
            return fragments.get(i).getTitle();
        }
    }

    public static abstract class AAFragment extends RoboFragment {
        public String getTitle() {return "Untitled";}
    }
}

