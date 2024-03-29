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
 * Use the {@link DainikJagranNews#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DainikJagranNews extends Fragment {

    WebView webView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DainikJagranNews() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DainikJagranNews.
     */
    // TODO: Rename and change types and number of parameters
    public static DainikJagranNews newInstance(String param1, String param2) {
        DainikJagranNews fragment = new DainikJagranNews();
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
        View view= inflater.inflate(R.layout.fragment_dainik_jagran_news, container, false);

        webView=view.findViewById(R.id.webViewDainik);
        webView.loadUrl("https://www.jagran.com/");
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