package com.example.wubagifview.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.example.wubagifview.R;
import com.example.wubagifview.model.ImageData;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

import java.util.ArrayList;
import java.util.List;

public class GifAdapter extends BaseAdapter {

    Context mContext;
    List<ImageData> mImageDataList = new ArrayList<>();

    public GifAdapter(Context context){
        mContext = context;
    }

    public void setData(List<ImageData> imageData){
        mImageDataList = imageData;
    }

    @Override
    public int getCount() {
        return mImageDataList == null ?  0 : mImageDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return mImageDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        ImageData imageData = mImageDataList.get(i);
        if(view == null){
            viewHolder = new ViewHolder();
            view = View.inflate(mContext, R.layout.image_listitem, null);
            viewHolder.imageView = view.findViewById(R.id.placeholder_image);
            viewHolder.gifImageView = view.findViewById(R.id.placeholder_gif);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageBitmap(getImageRes(imageData.imageUrl));
        viewHolder.gifImageView.setVisibility(View.GONE);
        try {
            GifDrawable gifFromResDrawable = new GifDrawable( mContext.getResources(), getIntGifRes(imageData.gifUrl));
            viewHolder.gifImageView.setImageDrawable(gifFromResDrawable);
            viewHolder.gifImageView.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    private Bitmap getImageRes(String name) {
        ApplicationInfo appInfo = mContext.getApplicationInfo();
        int resID = mContext.getResources().getIdentifier(name, "drawable", appInfo.packageName);
        return BitmapFactory.decodeResource(mContext.getResources(), resID);
    }

    private int getIntGifRes(String name){
        ApplicationInfo appInfo = mContext.getApplicationInfo();
        return mContext.getResources().getIdentifier(name, "drawable", appInfo.packageName);
    }


    static class ViewHolder{
        GifImageView gifImageView;
        ImageView imageView;
    }

}
