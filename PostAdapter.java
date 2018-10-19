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


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>
{
   private Context context;
   private List<Article> articles;

    public PostAdapter( Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;

    }



    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater li=LayoutInflater.from(context);
        View v=li.inflate(R.layout.post_list,parent,false);
        return new PostViewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

               final Article a= articles.get(position);

               holder.posttitle.setText(a.getTitle());
               holder.postdescription.setText(a.getContent());
        Glide.with(context).load(holder.postimage.getContext()).load(a.getUrlToImage()).into(holder.postimage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,Webview.class);
                i.putExtra("url",a.getUrl());
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


    public class PostViewHolder extends RecyclerView.ViewHolder
    {
        ImageView postimage;
        TextView posttitle;
        TextView postdescription;
        public PostViewHolder(View itemView)
        {

            super(itemView);

               postimage=itemView.findViewById(R.id.kenburn);
               posttitle=itemView.findViewById(R.id.top_author);
               postdescription=itemView.findViewById(R.id.top_title);
        }
    }
}
