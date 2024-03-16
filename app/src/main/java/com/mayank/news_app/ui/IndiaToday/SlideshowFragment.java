package com.mayank.news_app.ui.IndiaToday;

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
import com.mayank.news_app.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    WebView webView;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

            webView=root.findViewById(R.id.webViewIndiaToday);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewController());
            webView.loadUrl("https://www.indiatoday.in/");
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