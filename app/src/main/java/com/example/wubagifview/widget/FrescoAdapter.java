package com.example.wubagifview.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wubagifview.R;
import com.example.wubagifview.model.ImageData;
import com.example.wubagifview.utils.FrescoUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class FrescoAdapter extends RecyclerView.Adapter<FrescoAdapter.ViewHolder> {

    List<ImageData> mImageDataList = new ArrayList<>();
    private Context mContext;
    public FrescoAdapter(Context context, List<ImageData> data){
        mImageDataList = data;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycle_item,
                parent,
                false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageData imageData = mImageDataList.get(position);

        FrescoUtils.loadWebpImage(mContext, holder.draweeImage, imageData, imageData.imageUrl, true, position);
        if(!TextUtils.isEmpty(imageData.gifUrl)){
            FrescoUtils.loadWebpGif(mContext, holder.draweeImage, holder.draweeGif, imageData, imageData.gifUrl, false, position);
            holder.draweeGif.setVisibility(View.VISIBLE);
            holder.textView.setText("GIF-" + position);
        }else{
            holder.draweeGif.setVisibility(View.GONE);
            holder.textView.setText("IMAGE-" + position);
        }
    }

    @Override
    public int getItemCount() {
        return mImageDataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView draweeImage;
        SimpleDraweeView draweeGif;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            draweeImage = (SimpleDraweeView) itemView.findViewById(R.id.item_draweeview);
            draweeGif = (SimpleDraweeView) itemView.findViewById(R.id.item_draweeview_gif);
            textView = (TextView) itemView.findViewById(R.id.item_draweeview_text);
        }
    }
}
