package com.avontell.pagerindicatorbinderexample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.avontell.pagerindicatorbinder.ImageAdapter;
import com.avontell.pagerindicatorbinder.IndicatorBinder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EXAMPLE WITH BASIC DRAWABLE RESOURCES ---------------------------------------------------

        // Grab the views
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_one);
        LinearLayout indicatorContainer = (LinearLayout) findViewById(R.id.indicator_cont);

        // Populate ViewPager with necessary information
        int[] drawableResources = {R.drawable.image_one, R.drawable.image_two,
                                   R.drawable.image_three, R.drawable.image_four,
                                   R.drawable.image_five};
        ImageAdapter adapter = new ImageAdapter(this, drawableResources);
        viewPager.setAdapter(adapter);

        // Get resources for drawables
        int selectedImage = R.drawable.indicator_selected;
        int unselectedImage = R.drawable.indicator_unselected;

        // Bind the view pager to the indicatorContainer
        IndicatorBinder sample = new IndicatorBinder().bind(this,
                                  viewPager,
                                  indicatorContainer,
                                  selectedImage,
                                  unselectedImage);
        // Set whether you want a progress style
        sample.setProgressStyle(true);

        // EXAMPLE WITH TABS -----------------------------------------------------------------------

        // Create each tab TextView
        List<TextView> tabViews = new ArrayList<>();
        tabViews.add(new TextView(this));
        tabViews.add(new TextView(this));
        tabViews.add(new TextView(this));
        tabViews.add(new TextView(this));
        tabViews.add(new TextView(this));
        tabViews.get(0).setText("Tab 1");
        tabViews.get(1).setText("Tab 2");
        tabViews.get(2).setText("Tab 3");
        tabViews.get(3).setText("Tab 4");
        tabViews.get(4).setText("Tab 5");

        // Set the requested colors
        int selectedBackgroundColor = R.color.tabBackgroundSelected;
        int selectedTextColor = R.color.tabTextSelected;
        int unselectedBackgroundColor = R.color.tabBackgroundUnselected;
        int unselectedTextColor = R.color.tabTextUnselected;

        // Grab the LinearLayout
        LinearLayout tabContainer = (LinearLayout) findViewById(R.id.tab_container);

        new IndicatorBinder().bindTextTabs(this,
                                     viewPager,
                                     tabContainer,
                                     tabViews,
                                     selectedBackgroundColor,
                                     unselectedBackgroundColor,
                                     selectedTextColor,
                                     unselectedTextColor);

    }
}
