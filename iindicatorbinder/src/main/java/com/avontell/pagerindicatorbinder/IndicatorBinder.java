package com.avontell.pagerindicatorbinder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A class that binds together a ViewPager with a view that supports
 * children. The position of the ViewPager will update the view
 * with the children such that the current position is indicated
 * @author Aaron Vontell
 * @version 0.1
 */
public class IndicatorBinder {

    /**
     * Binds the viewPager to indicatorContainer, such that indicatorContainer has a list of
     * indicators, all displaying the drawable at indicatorOffResource except for the ith child,
     * where i is the position of the viewPager, and whose visual is given by indicatorOffResource.
     * * Note that this attaches an OnPageChangeListener to viewPager. Also note that viewPager
     *   must have an adapter attached.
     * @param context The calling application
     * @param viewPager The ViewPager you wish to attach indicators to
     * @param indicatorContainer The container that will hold each indicator resource
     * @param indicatorOnResource The drawable to display for indicators that are not selected
     * @param indicatorOffResource The drawable to display for the selected indicator
     */
    public static void bind(final @NonNull Context context,
                            @NonNull ViewPager viewPager,
                            @NonNull final ViewGroup indicatorContainer,
                            @DrawableRes final int indicatorOnResource,
                            @DrawableRes final int indicatorOffResource) {

        // Load the indicator drawables
        final Drawable selected = context.getResources().getDrawable(indicatorOnResource);
        final Drawable unselected = context.getResources().getDrawable(indicatorOffResource);

        // Load the container with indicators
        final int numItems = viewPager.getAdapter().getCount();
        indicatorContainer.removeAllViews();
        for(int i = 0; i < numItems; i++) {
            ImageView indImage = new ImageView(context);
            if(i == viewPager.getCurrentItem()) {
                indImage.setImageDrawable(selected);
            } else {
                indImage.setImageDrawable(unselected);
            }
            indicatorContainer.addView(indImage);
        }

        // Listener to detect when to update indicators
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i < numItems; i++){
                    ImageView indicator = (ImageView) indicatorContainer.getChildAt(i);
                    if(i == position){
                        indicator.setImageDrawable(selected);
                    }
                    else {
                        indicator.setImageDrawable(unselected);
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
