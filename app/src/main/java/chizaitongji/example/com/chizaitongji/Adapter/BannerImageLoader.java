package chizaitongji.example.com.chizaitongji.Adapter;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

public class BannerImageLoader extends ImageLoader {
    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Uri uri = Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + (Integer) path);
        imageView.setImageURI(uri);
    }


}
