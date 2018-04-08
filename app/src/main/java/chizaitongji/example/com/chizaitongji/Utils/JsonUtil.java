package chizaitongji.example.com.chizaitongji.Utils;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import chizaitongji.example.com.chizaitongji.Bean.ArticleThumbnail;
import chizaitongji.example.com.chizaitongji.Bean.CanteenThumbnail;
import chizaitongji.example.com.chizaitongji.Bean.Notification;
import chizaitongji.example.com.chizaitongji.Bean.SubCanteenInfo;
import chizaitongji.example.com.chizaitongji.R;

public class JsonUtil {
    private static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss", Locale.getDefault());
    private static SimpleDateFormat sFormat1 = new SimpleDateFormat("HHmm", Locale.getDefault());
    private static SimpleDateFormat sFormat2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private static SimpleDateFormat sFormat3 = new SimpleDateFormat("yyyyMMddHHmm", Locale.getDefault());

    public enum ArticleType {INFORM_ARTICLE, RECOMMAND_ARTICLE}

    ;
    private static final String TAG = "JsonUtil";

    public static List<ArticleThumbnail> getArticles(Context context, ArticleType articleType) {
        InputStream is;
        switch (articleType) {
            case INFORM_ARTICLE:
                is = context.getResources().openRawResource(R.raw.resource_article_info);
                break;
            case RECOMMAND_ARTICLE:
                is = context.getResources().openRawResource(R.raw.resource_article_reco);
                break;
            default:
                is = context.getResources().openRawResource(R.raw.resource_article_info);
        }

        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String json = writer.toString();
        final List<ArticleThumbnail> list;
        list = new Gson().fromJson(json, new TypeToken<List<ArticleThumbnail>>() {
        }.getType());
        return list;
    }

    public static List<CanteenThumbnail> getCanteenThumbnails(Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.resource_canteen_info);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String json = writer.toString();
        final List<CanteenThumbnail> list;
        list = new Gson().fromJson(json, new TypeToken<List<CanteenThumbnail>>() {
        }.getType());
        return list;
    }

    public static List<SubCanteenInfo> getSubCanteenInfos(Context context, EnumPack.CanteenName canteenName) {
        InputStream is;
        switch (canteenName) {
            case XUEYUAN:
                is = context.getResources().openRawResource(R.raw.resource_canconc_xueyuan);
                break;
            case BEIYUAN:
                is = context.getResources().openRawResource(R.raw.resource_canconc_beiyuan);
                break;
            case XIBEI:
                is = context.getResources().openRawResource(R.raw.resource_canconc_xibei);
                break;
            case XIYUAN:
                is = context.getResources().openRawResource(R.raw.resource_canconc_xiyuan);
                break;
            case SANHAOWU:
                is = context.getResources().openRawResource(R.raw.resource_canconc_sanhaowu);
                break;
            default:
                is = null;
        }
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String json = writer.toString();
        Log.d(TAG, json);
        final List<SubCanteenInfo> list;
        list = new Gson().fromJson(json, new TypeToken<List<SubCanteenInfo>>() {
        }.getType());
        return list;

    }

    public static List<Notification> getNotifications(Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.notification);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String json = writer.toString();
        final List<Notification> list;
        list = new Gson().fromJson(json, new TypeToken<List<Notification>>() {
        }.getType());
        return list;
    }


}
