package arr.com.retrofit2;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class TechnologyAPI
{

    private static final String key = "f445286a4cee457b8f75961c843bceb4";

    private static final String url2 = "https://newsapi.org/v2/";

    public static TechnologyNews technologyNews=null;

    public static TechnologyNews gettechnologyservice()
    {
             if(technologyNews==null)
             {
                 Retrofit rt=new Retrofit.Builder()
                             .baseUrl(url2)
                             .addConverterFactory(GsonConverterFactory.create())
                         .build();
                 technologyNews=rt.create(TechnologyNews.class);
             }
             return technologyNews;
    }


    public interface TechnologyNews
    {
        @GET("top-headlines?country=in&category=technology&apiKey="+key)
        Call<arr.com.retrofit2.TechnologyNews> gettechnolgylist();

    }
}

