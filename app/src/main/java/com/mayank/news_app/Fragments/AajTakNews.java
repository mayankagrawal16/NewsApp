package com.mayank.news_app.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.mayank.news_app.R;
import com.mayank.news_app.WebViewController;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AajTakNews#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AajTakNews extends Fragment {

    WebView webView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AajTakNews() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AajTakNews.
     */
    // TODO: Rename and change types and number of parameters
    public static AajTakNews newInstance(String param1, String param2) {
        AajTakNews fragment = new AajTakNews();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_aaj_tak_news, container, false);
        webView=view.findViewById(R.id.webViewaaj);
        webView.loadUrl("https://www.aajtak.in/");
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
        return  view;
    }
}