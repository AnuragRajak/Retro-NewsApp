package arr.com.retrofit2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import arr.com.retrofit2.WebView.Webview;

public class TimesAdapter  extends RecyclerView.Adapter<TimesAdapter.TimesViewHolder>
{

    private Context context;
    private List<Article> articleList;

    public TimesAdapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public TimesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li=LayoutInflater.from(context);
        View v=li.inflate(R.layout.post_list,parent,false);
        return new TimesViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull TimesViewHolder holder, int position)
    {
               final Article article=articleList.get(position);
               holder.title.setText(article.getTitle());
               holder.description.setText(article.getDescription());




        Glide.with(holder.imageView.getContext()).load(article.getUrlToImage()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(context,Webview.class);
                           i.putExtra("url",article.getUrl());
                        context.startActivity(i);

            }
        });



    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class TimesViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView title;
        TextView description;

        public TimesViewHolder(View itemView)
        {

            super(itemView);
            imageView=itemView.findViewById(R.id.kenburn);
            title=itemView.findViewById(R.id.top_author);
            description=itemView.findViewById(R.id.top_title);
        }
    }
}
