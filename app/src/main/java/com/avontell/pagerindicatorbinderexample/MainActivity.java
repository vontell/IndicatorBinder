package com.avontell.pagerindicatorbinderexample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.avontell.pagerindicatorbinder.ImageAdapter;
import com.avontell.pagerindicatorbinder.IndicatorBinder;

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
        IndicatorBinder.bind(this,
                                  viewPager,
                                  indicatorContainer,
                                  selectedImage,
                                  unselectedImage);

        // OPTIONAL: Attach more than one indicator container!
        LinearLayout alternateContainer = (LinearLayout) findViewById(R.id.indicator_alt);
        IndicatorBinder.bind(this,
                                  viewPager,
                                  alternateContainer,
                                  selectedImage,
                                  unselectedImage);

    }
}
