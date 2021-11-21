package com.example.sideandroidnetflix.Activity;

import android.os.StrictMode;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sideandroidnetflix.R;
import com.example.sideandroidnetflix.lib.HTTP.HTTP;
import com.example.sideandroidnetflix.lib.HTTP.Header;
import com.example.sideandroidnetflix.lib.HTTP.Parameter;
import com.example.sideandroidnetflix.lib.HTTP.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) { StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); StrictMode.setThreadPolicy(policy); }

        String url = "http://www.naver.com";
        Header header = new Header();
        Parameter parameter = new Parameter();
        try {
            Response response = HTTP.GET(url, header, parameter)
                    .setConnectTimeOut(1000)
                    .request();

            System.out.println("success !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
