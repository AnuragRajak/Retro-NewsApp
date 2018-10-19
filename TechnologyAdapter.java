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

public class TechnologyAdapter   extends RecyclerView.Adapter<TechnologyAdapter.TechnologyViewHolder>
{
    private Context context;
    private List<Article> articleListt;

    public TechnologyAdapter(Context context, List<Article> articleListt) {
        this.context = context;
        this.articleListt = articleListt;
    }

    @NonNull
    @Override
    public TechnologyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li=LayoutInflater.from(context);
        View v=li.inflate(R.layout.post_list,parent,false);
        return new TechnologyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TechnologyViewHolder holder, int position)
    {
        final Article a2= articleListt.get(position);
        holder.title.setText(a2.getTitle());
        holder.description.setText(a2.getDescription());
        Glide.with(holder.imageView).load(a2.getUrlToImage()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,Webview.class);
                i.putExtra("url",a2.getUrl());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleListt.size();
    }

    public class TechnologyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView title;
        TextView description;

        public TechnologyViewHolder(View itemView)
        {
            super(itemView);

          imageView=  itemView.findViewById(R.id.kenburn);
         title=   itemView.findViewById(R.id.top_author);
         description=   itemView.findViewById(R.id.top_title);

        }
    }
}
