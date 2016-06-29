package com.avontell.pagerindicatorbinder;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * A class that binds together a ViewPager with a view that supports
 * children. The position of the ViewPager will update the view
 * with the children such that the current position is indicated
 * @author Aaron Vontell
 * @version 0.1
 */
public class PagerIndicatorBinder {

    /**
     * Binds the viewPager to indicatorContainer, such that indicatorContainer has a list of
     * indicators, all displaying the drawable at indicatorOffResource except for the ith child,
     * where i is the position of the viewPager, and whose visual is given by indicatorOffResource
     * @param viewPager The ViewPager you wish to attach indicators to
     * @param indicatorContainer The container that will hold each indicator resource
     * @param indicatorOnResource The drawable to display for indicators that are not selected
     * @param indicatorOffResource The drawable to display for the selected indicator
     */
    public static void bind(@NonNull ViewPager viewPager,
                            @NonNull ViewGroup indicatorContainer,
                            @DrawableRes int indicatorOnResource,
                            @DrawableRes int indicatorOffResource) {

    }

    /**
     * Binds the viewPager to indicatorContainer, such that indicatorContainer has a list of
     * indicators, all displaying the view at indicatorOffView except for the ith child,
     * where i is the position of the viewPager, and whose visual is given by indicatorOffView
     * @param viewPager The ViewPager you wish to attach indicators to
     * @param indicatorContainer The container that will hold each indicator resource
     * @param indicatorOnView The view to display for indicators that are not selected
     * @param indicatorOffView The view to display for the selected indicator
     */
    public static void bind(@NonNull ViewPager viewPager,
                            @NonNull ViewGroup indicatorContainer,
                            @NonNull View indicatorOnView,
                            @NonNull View indicatorOffView) {

    }

}
