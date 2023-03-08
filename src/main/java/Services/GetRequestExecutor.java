package Services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public abstract class GetRequestExecutor {
    private OkHttpClient httpClient;

    protected GetRequestExecutor() {
        httpClient = new OkHttpClient();
    }

    protected Response execute(String url) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();


        return httpClient.newCall(request).execute();
    }
}
