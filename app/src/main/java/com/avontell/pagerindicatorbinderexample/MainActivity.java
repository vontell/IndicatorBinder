package com.avontell.pagerindicatorbinderexample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        // INCLUDES PROGRESS STYLE -----------------------------------------------------------------

        // Grab the views
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_one);
        LinearLayout indicatorContainer = (LinearLayout) findViewById(R.id.indicator_cont);

        // Populate ViewPager with necessary information
        final ArrayList<Integer> drawableResources = new ArrayList<>();

        drawableResources.add(R.drawable.image_one);
        drawableResources.add(R.drawable.image_two);
        drawableResources.add(R.drawable.image_three);
        drawableResources.add(R.drawable.image_four);
        drawableResources.add(R.drawable.image_five);

        final ImageAdapter adapter = new ImageAdapter(this, drawableResources);
        viewPager.setAdapter(adapter);

        // Get resources for drawables
        int selectedImage = R.drawable.indicator_selected;
        int unselectedImage = R.drawable.indicator_unselected;

        // Bind the view pager to the indicatorContainer
        final IndicatorBinder sample = new IndicatorBinder().bind(this,
                                  viewPager,
                                  indicatorContainer,
                                  selectedImage,
                                  unselectedImage);

        // Set whether you want a progress style
        sample.setProgressStyle(true);

        // EXAMPLE WITHOUT PROGRESS STYLE ----------------------------------------------------------

        LinearLayout indicatorContainerDefault = (LinearLayout) findViewById(R.id.indicator_default);

        // Bind the view pager to the indicatorContainer
        final IndicatorBinder defaultInd = new IndicatorBinder().bind(this,
                                viewPager,
                                indicatorContainerDefault,
                                selectedImage,
                                unselectedImage);

        // Set whether you want a progress style
        defaultInd.setProgressStyle(false);

        // EXAMPLE WITH TABS -----------------------------------------------------------------------

        // Create each tab TextView
        final List<TextView> tabViews = new ArrayList<>();
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

        final IndicatorBinder tabBinder = new IndicatorBinder().bindTextTabs(this,
                                     viewPager,
                                     tabContainer,
                                     tabViews,
                                     selectedBackgroundColor,
                                     unselectedBackgroundColor,
                                     selectedTextColor,
                                     unselectedTextColor);

        // Button to add more images to viewPager
        Button addBtn = (Button) findViewById(R.id.add_to_adapter_btn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create new textview for adapter
                TextView textView = new TextView(MainActivity.this);
                textView.setText("Tab " + (tabViews.size() + 1));

                // Add image to viewpager
                drawableResources.add(R.drawable.image_one);
                // Add textview to tab views
                tabViews.add(textView);
                // Refresh all three sample data sets
                tabBinder.invalidate();
                sample.invalidate();
                defaultInd.invalidate();
            }
        });
    }
}
