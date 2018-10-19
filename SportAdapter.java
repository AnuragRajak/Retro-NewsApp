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

public class SportAdapter  extends RecyclerView.Adapter<SportAdapter.SportViewHolder>
{
    private Context context;
    private List<Article> articleLists;

    public SportAdapter(Context context, List<Article> articleLists) {
        this.context = context;
        this.articleLists = articleLists;
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li=LayoutInflater.from(context);
        View v=li.inflate(R.layout.post_list,parent,false);
        return new SportViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder holder, int position)
    {

        final Article a= articleLists.get(position);
        holder.title.setText(a.getTitle());
        holder.description.setText(a.getDescription());
        Glide.with(holder.imageView.getContext()).load(a.getUrlToImage()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(context,Webview.class);
                i.putExtra("url",a.getUrl());
                context.startActivity(i);

            }
        });




    }

    @Override
    public int getItemCount() {
        return articleLists.size();
    }

    public class SportViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView title;
        TextView description;
        public SportViewHolder(View itemView)
        {
            super(itemView);

           imageView= itemView.findViewById(R.id.kenburn);
            title=itemView.findViewById(R.id.top_author);
            description=itemView.findViewById(R.id.top_title);
        }
    }
}
