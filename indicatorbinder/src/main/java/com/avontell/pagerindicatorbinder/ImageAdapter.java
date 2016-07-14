package com.avontell.pagerindicatorbinder;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Class that serves ImageViews for a view pager, for effects such as a carousel
 * @author Aaron Vontell
 * @version 0.1
 */
public class ImageAdapter extends PagerAdapter{

    Context context;
    int[] imageResources;

    /**
     * Create an adapter that handles a slideshow of images
     * @param context The calling activity
     * @param imageResources The images to use within the slideshow, as drawable resources
     */
    public ImageAdapter(Context context, int[] imageResources) {
        this.context = context;
        this.imageResources = imageResources;
    }

    @Override
    public int getCount() {
        return imageResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View result;

        //If this is an image, add an ImageView to the pager
        //Otherwise, add the extra view to the pager
        ImageView itemView = new ImageView(context);
        itemView.setImageResource(imageResources[position]);
        itemView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(itemView);
        result = itemView;

        return result;

    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
