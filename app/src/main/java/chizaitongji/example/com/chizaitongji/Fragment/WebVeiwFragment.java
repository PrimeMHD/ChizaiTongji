package chizaitongji.example.com.chizaitongji.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import chizaitongji.example.com.chizaitongji.Adapter.ArticleThumbnailAdapter;
import chizaitongji.example.com.chizaitongji.R;
import me.yokeyword.fragmentation.SupportFragment;

public class WebVeiwFragment extends SupportFragment {
    protected Context mContext;
    private static final String TAG = "WebViewFragment";
    private WebView webView;
    private String targetPageUrl;
    //private static final String HOMEPAGE_URL="http://mp.weixin.qq.com/s/X3NMeVi0VW2r4IwP5UwyUw";


    public String getTargetPageUrl() {
        return targetPageUrl;
    }

    public void setTargetPageUrl(String targetPageUrl) {
        this.targetPageUrl = targetPageUrl;
    }

    public static WebVeiwFragment newInstance(final String targetPageUrl) {
        WebVeiwFragment fragment = new WebVeiwFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setTargetPageUrl(targetPageUrl);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "on Create");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.layout_fragment_webview, container, false);
        webView = (WebView) v.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(targetPageUrl);
        Log.d(TAG, "loadhome");
        return v;
    }

    public void loadNewSite(final String url) {
        //webView.loadUrl(url);
        Log.d(TAG, "load new site");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

}
