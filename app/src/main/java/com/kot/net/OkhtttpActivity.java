package com.kot.net;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.kot.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhtttpActivity extends AppCompatActivity {
    //    https://tls13.1d.pw/

    String tlsUrl = "https://tls13.1d.pw/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhtttp);
        findViewById(R.id.bt_reqeust).setOnClickListener(v -> Executors.newCachedThreadPool().execute(() -> {
            try {
                run(tlsUrl);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));

        findViewById(R.id.bt_url_connection).setOnClickListener(v -> {
            Executors.newCachedThreadPool().execute(() -> onward10HttpUrlConnection(tlsUrl));
        });
    }

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            Log.i("OkhtttpActivity", "run: " + string);
            return string;
        }
    }


    public void onward10HttpUrlConnection(String url) {
        try {
            // Create a URL object for the target server
            URL mUrl = new URL(url);

            // Open a connection to the URL
            HttpsURLConnection connection = (HttpsURLConnection) mUrl.openConnection();

            // Set the enabled protocols to include TLS 1.3
//            connection.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});

            // Set the request method
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Print the response content
            Log.i("onward10HttpUr", "onward10HttpUrlConnection: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}