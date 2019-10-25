package com.example.wubagifview.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.example.wubagifview.model.ImageData;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

public class FrescoUtils {
    /**

     * Fresco 加载本地webp图片

     * @param draweeView

     * @param resId

     */
    public static void loadDrawable(SimpleDraweeView draweeView, @DrawableRes int resId) {
        Uri uri = Uri.parse(imageTranslateUri(draweeView.getContext(), resId));
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .setOldController(draweeView.getController())
                .build();
        draweeView.setController(controller);

    }

    /**
     * Fresco 加载webp图片
     * @param draweeView
     * @param imageUrl
     */
    public static void loadWebpImage(final Context context, final SimpleDraweeView draweeView, final ImageData imageData, String imageUrl, final boolean reSize, final int position) {
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(imageUrl))
                .setAutoPlayAnimations(true)
                .setOldController(draweeView.getController())
                .setControllerListener(new ControllerListener<ImageInfo>() {
                    @Override
                    public void onSubmit(String id, Object callerContext) {

                    }

                    @Override
                    public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
                        if (imageInfo == null) {
                            return;
                        }

                        if(imageData.getScale() == 0){
                            int width = imageInfo.getWidth();
                            int height = imageInfo.getHeight();
                            float scale = (float) width/ (float) height;
                            imageData.setScale(scale);
                        }
                        final ViewGroup.LayoutParams layoutParams = draweeView.getLayoutParams();
                        layoutParams.width = DisplayUtils.getScreenWidth((Activity) context) / 2 - DisplayUtils.dp2px(context,10);
                        layoutParams.height = (int) (layoutParams.width/ imageData.getScale());

                        imageData.setWidth(layoutParams.width);
                        imageData.setHeight(layoutParams.height);

                        imageData.setPosition(position);

                        draweeView.setLayoutParams(layoutParams);

                    }

                    @Override
                    public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {

                    }

                    @Override
                    public void onIntermediateImageFailed(String id, Throwable throwable) {

                    }

                    @Override
                    public void onFailure(String id, Throwable throwable) {

                    }

                    @Override
                    public void onRelease(String id) {

                    }
                })
                .build();

        draweeView.setController(controller);

    }

    /**
     * Fresco 加载webpGID
     * @param imageView
     * @param imageUrl
     */
    public static void loadWebpGif(final Context context, final SimpleDraweeView imageView,final SimpleDraweeView gifView, final ImageData imageData, String imageUrl, final boolean reSize, final int position) {
        DraweeController controller = Fresco.newDraweeControllerBuilder()

                .setUri(Uri.parse(imageUrl))

                .setAutoPlayAnimations(true)

                .setOldController(gifView.getController())

                .setControllerListener(new ControllerListener<ImageInfo>() {
                    @Override
                    public void onSubmit(String id, Object callerContext) {

                    }

                    @Override
                    public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
                        if (imageInfo == null) {
                            return;
                        }
                        final ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        final ViewGroup.LayoutParams gifLayoutParams = gifView.getLayoutParams();
                        gifLayoutParams.width = layoutParams.width;
                        gifLayoutParams.height = layoutParams.height;

                        gifView.setLayoutParams(gifLayoutParams);

                    }

                    @Override
                    public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {

                    }

                    @Override
                    public void onIntermediateImageFailed(String id, Throwable throwable) {

                    }

                    @Override
                    public void onFailure(String id, Throwable throwable) {

                    }

                    @Override
                    public void onRelease(String id) {

                    }
                })
                .build();

        gifView.setController(controller);
    }

    /**
     * drawable路径转换成 url
     * @param context
     * @param resId
     * @return
     */

    public static String imageTranslateUri(Context context, int resId) {
        Resources r = context.getResources();
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +"://" + r.getResourcePackageName(resId) +"/" + r.getResourceTypeName(resId) +"/" + r.getResourceEntryName(resId));
        return uri.toString();
    }
}
