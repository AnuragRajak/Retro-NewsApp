package arr.com.retrofit2;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ScienceApi
{
    public static final String key="f445286a4cee457b8f75961c843bceb4";

    public static final  String url="https://newsapi.org/v2/";

    public static PostService postService=null;

    public static PostService getPostService()
    {
        if (postService==null)
        {
            Retrofit rt=new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService=rt.create(PostService.class);
        }
        return postService;
    }

public interface PostService
{
    @GET("top-headlines?country=in&category=science&apiKey="+key)
    Call<PostList> getPostList();
}


}
