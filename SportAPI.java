package arr.com.retrofit2;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class SportAPI
{
    private static final String key = "f445286a4cee457b8f75961c843bceb4";

    private static final String url3 = "https://newsapi.org/v2/";

    public static SportNews sportnews=null;

    public static SportNews getsportservice()
    {
        if(sportnews==null)
        {
            Retrofit rt=new Retrofit.Builder()
                    .baseUrl(url3)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            sportnews=rt.create(SportNews.class);

        }
        return sportnews;

    }

    public interface SportNews
    {

        @GET("top-headlines?country=in&category=sports&apiKey="+key)
        Call<arr.com.retrofit2.SportNews> getsportlist();
    }
}
