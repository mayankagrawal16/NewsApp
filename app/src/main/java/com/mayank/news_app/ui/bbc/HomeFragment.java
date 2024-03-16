package com.mayank.news_app.ui.bbc;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mayank.news_app.R;
import com.mayank.news_app.WebViewController;
import com.mayank.news_app.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    WebView webView;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        webView=root.findViewById(R.id.webViewbbc);
        webView.loadUrl("https://www.bbc.com/news/world");
        webView.getSettings().setJavaScriptEnabled(true);
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