package arr.com.retrofit2;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class TimesAPI {

    private static final String key = "f445286a4cee457b8f75961c843bceb4";

    private static final String url1 = "https://newsapi.org/v2/";

    public static TimesIndia timesIndia = null;

    public static TimesIndia gettimesservice() {

        if (timesIndia == null) {
            Retrofit rt = new Retrofit.Builder()
                    .baseUrl(url1)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            timesIndia = rt.create(TimesIndia.class);
        }
        return timesIndia;

    }

    public interface TimesIndia
    {
        @GET("top-headlines?country=in&category=entertainment&apiKey=" + key)
        Call<arr.com.retrofit2.TimesIndia> gettimeslist();


    }

}

