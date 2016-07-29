package com.avontell.pagerindicatorbinder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

/**
 * A class that binds together a ViewPager with a view that supports
 * children. The position of the ViewPager will update the view
 * with the children such that the current position is indicated
 * @author Aaron Vontell, Egli Hila
 * @version 0.3
 */
public class IndicatorBinder {

    private ViewPager mViewPager;
    private Context mContext;
    private ViewGroup mContainer;
    private LinearLayout mTabContainer;
    private List<TextView> mTabViews;
    private Drawable mSelected, mUnselected;
    private int mBackgroundSelectedColor;
    private int mBackgroundUnselectedColor;
    private int mTextSelectedColor;
    private int mTextUnselectedColor;

    private boolean isProgressStyle = false;

    /**
     * Returns if the current indicator is set to progress style or not
     * @return returns true or false
     */
    public boolean isProgressStyle() {
        return isProgressStyle;
    }

    /**
     * Set whether the indicators are set to selected as your swipe through the view pager or not
     * Currently only setup to work with bind method
     * Default is false
     * @param progressStyle boolean for progress style
     */
    public void setProgressStyle(boolean progressStyle) {
        isProgressStyle = progressStyle;
    }

    /**
     * Initializes Binder for drawable indicators
     */
    private void initializeIndicator(){
        mContainer.removeAllViews();
        mViewPager.getAdapter().notifyDataSetChanged();
        for(int i = 0; i < mViewPager.getAdapter().getCount(); i++) {
            ImageView indImage = new ImageView(mContext);
            if(isProgressStyle){
                indImage.setImageDrawable((i <= mViewPager.getCurrentItem()) ? mSelected : mUnselected);
            }
            else {
                indImage.setImageDrawable((i == mViewPager.getCurrentItem()) ? mSelected : mUnselected);
            }
            mContainer.addView(indImage);
        }
    }

    /**
     * Initializes Binder for tab indicators
     */
    private void initializeTabIndicator(){
        mTabContainer.removeAllViews();
        mViewPager.getAdapter().notifyDataSetChanged();
        for(int i = 0; i < mTabViews.size(); i++) {

            TextView tab = mTabViews.get(i);

            // Make sure each TextView takes the right amount of space and gravity
            tab.setLayoutParams(
                    new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
            tab.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

            // Set colors of the TextView
            if(i == mViewPager.getCurrentItem()) {
                tab.setBackgroundColor(ContextCompat.getColor(mContext, mBackgroundSelectedColor));
                tab.setTextColor(ContextCompat.getColor(mContext, mTextSelectedColor));
            } else {
                tab.setBackgroundColor(ContextCompat.getColor(mContext, mBackgroundUnselectedColor));
                tab.setTextColor(ContextCompat.getColor(mContext, mTextUnselectedColor));
            }

            // Set Click Listeners of the tabs
            final Integer pos = i;
            tab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mViewPager.setCurrentItem(pos, true);
                }
            });

            mTabContainer.addView(tab);
        }
    }

    /**
     * Refreshes all data for the binder
     * Should be called when the data set changes
     */
    public void invalidate(){
        if(mTabViews == null){
            initializeIndicator();
        } else {
            initializeTabIndicator();
        }

    }

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
    public IndicatorBinder bind(@NonNull final Context context,
                            @NonNull final ViewPager viewPager,
                            @NonNull final ViewGroup indicatorContainer,
                            @DrawableRes final int indicatorOnResource,
                            @DrawableRes final int indicatorOffResource) {

        // Load global variables
        mViewPager = viewPager;
        mContext = context;
        mContainer = indicatorContainer;

        // Load the indicator drawables
        mSelected = ContextCompat.getDrawable(context, indicatorOnResource);
        mUnselected = ContextCompat.getDrawable(context, indicatorOffResource);


        // Load the container with indicators
        initializeIndicator();

        // Listener to detect when to update indicators
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i < mViewPager.getAdapter().getCount(); i++){
                    ImageView indicator = (ImageView) mContainer.getChildAt(i);

                    if(isProgressStyle){
                        indicator.setImageDrawable((i <= position) ? mSelected : mUnselected);
                    }
                    else {
                        indicator.setImageDrawable((i == position) ? mSelected : mUnselected);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return this;
    }

    /**
     * Binds the viewPager to tabContainer, such that tabContainer serves as a list of
     * clickable tabs that map to sections of the ViewPager. Pass in a list of TextViews to use in the
     * tab (must be equal to viewPager.getAdapter().getCount()), background colors, and text colors for the
     * selected and unselected states
     * @param context The calling application
     * @param viewPager The ViewPager you wish to attach tabs to
     * @param tabContainer The Linear Layout that will hold each tab TextView
     * @param tabViews The list of tabs that you wish to use
     * @param backgroundSelectedColor The background color resource for a selected tab
     * @param backgroundUnselectedColor The background color resource for an unselected tab
     * @param textSelectedColor The text color resource for a selected tab
     * @param textUnselectedColor The text color resource for an unselected tab
     */
    public IndicatorBinder bindTextTabs(
            @NonNull final Context context,
            @NonNull final ViewPager viewPager,
            @NonNull final LinearLayout tabContainer,
            @NonNull final List<TextView> tabViews,
            @ColorRes final int backgroundSelectedColor,
            @ColorRes final int backgroundUnselectedColor,
            @ColorRes final int textSelectedColor,
            @ColorRes final int textUnselectedColor) {

        // Load global variables
        mViewPager = viewPager;
        mContext = context;
        mTabContainer = tabContainer;
        mTabViews = tabViews;
        mBackgroundSelectedColor = backgroundSelectedColor;
        mBackgroundUnselectedColor = backgroundUnselectedColor;
        mTextSelectedColor = textSelectedColor;
        mTextUnselectedColor = textUnselectedColor;

        // Check that the correct number of tabs are available
        if(viewPager.getAdapter().getCount() != tabViews.size()) {
            throw new RuntimeException("Expected " + viewPager.getAdapter().getCount() +
                    " tab views, but found " + tabViews.size());
        }

        // Load tabView into tabContainer
        initializeTabIndicator();

        // Set listener for ViewPager changes
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i < mTabViews.size(); i++){
                    TextView tab = (TextView) mTabContainer.getChildAt(i);
                    if(i == position) {
                        tab.setBackgroundColor(ContextCompat.getColor(mContext, mBackgroundSelectedColor));
                        tab.setTextColor(ContextCompat.getColor(mContext, mTextSelectedColor));
                    } else {
                        tab.setBackgroundColor(ContextCompat.getColor(mContext, mBackgroundUnselectedColor));
                        tab.setTextColor(ContextCompat.getColor(mContext, mTextUnselectedColor));
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return this;
    }

    /**
     * Binds the scrollView to indicatorContainer, such that indicatorContainer has a list of
     * indicators, all displaying the drawable at indicatorOffResource except for the ith child,
     * where i is the ith segment of the scrollview, and each segment is a child in the ScrollView's
     * immediate ViewGroup
     * @param context The calling application
     * @param scrollView The scrollView you wish to attach indicators to
     * @param indicatorContainer The container that will hold each indicator resource
     * @param indicatorOnResource The drawable to display for indicators that are not selected
     * @param indicatorOffResource The drawable to display for the selected indicator
     */
    public static void bindScroll(final @NonNull Context context,
                            @NonNull ScrollView scrollView,
                            @NonNull final ViewGroup indicatorContainer,
                            @DrawableRes final int indicatorOnResource,
                            @DrawableRes final int indicatorOffResource) {

        throw new RuntimeException("Not yet implemented");

    }

}
