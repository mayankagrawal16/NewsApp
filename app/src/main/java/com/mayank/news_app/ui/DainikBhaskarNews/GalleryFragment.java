package com.mayank.news_app.ui.DainikBhaskarNews;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mayank.news_app.R;
import com.mayank.news_app.WebViewController;
import com.mayank.news_app.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    WebView webView;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        webView=root.findViewById(R.id.webViewDainikBhaskar);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.bhaskar.com/");
        webView.setWebViewClient(new WebViewController());
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keycode, KeyEvent event) {

                if(event.getAction()==KeyEvent.ACTION_DOWN)
                {
                    if(keycode==KeyEvent.KEYCODE_BACK)
                    {
                        if(webView.canGoBack())
                        {
                            webView.goBack();
                        }
                        else
                        {
                            getActivity().onBackPressed();
                        }
                    }
                }
                return true;
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}