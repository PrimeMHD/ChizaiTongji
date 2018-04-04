package chizaitongji.example.com.chizaitongji.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import chizaitongji.example.com.chizaitongji.Bean.ArticleThumbnail;
import chizaitongji.example.com.chizaitongji.Bean.CanteenThumbnail;
import chizaitongji.example.com.chizaitongji.Fragment.WebVeiwFragment;
import chizaitongji.example.com.chizaitongji.Listener.OnItemClickListener;
import chizaitongji.example.com.chizaitongji.R;

public class ArticleThumbnailAdapter extends RecyclerView.Adapter<ArticleThumbnailAdapter.MyViewHolder> {
    private List<ArticleThumbnail> articleThumbnailList;//存放数据

    private OnItemClickListener mClickListener;

    public ArticleThumbnailAdapter(List<ArticleThumbnail> articleThumbnailList) {
        this.articleThumbnailList = articleThumbnailList;

    }

    @Override
    public ArticleThumbnailAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_article, parent, false);
        final ArticleThumbnailAdapter.MyViewHolder holder = new ArticleThumbnailAdapter.MyViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                if (mClickListener != null) {
                    mClickListener.onItemClick(position, view, holder);
                }
            }
        });
        return holder;
    }

    //在这里可以获得每个子项里面的控件的实例，比如这里的TextView,子项本身的实例是itemView，
// 在这里对获取对象进行操作
    //holder.itemView是子项视图的实例，holder.textView是子项内控件的实例
    //position是点击位置
    @Override
    public void onBindViewHolder(ArticleThumbnailAdapter.MyViewHolder holder, int position) {
        //设置显示内容为list里的对应项
        ArticleThumbnail articleThumbnail = articleThumbnailList.get(position);
        //holder.imageView_article.setImageResource(articleThumbnail.getImageId());
        Picasso.get().load(articleThumbnail.getImageURL()).into(holder.imageView_article);
//        holder.imageView_canteenthumbnail.setImageResource(canteenThumbnail.getImageId());
        holder.textView_title.setText(articleThumbnail.getTitle());
        holder.textView_abstraction.setText(articleThumbnail.getAbstraction());
        holder.textView_articledate.setText(articleThumbnail.getDate().toString());

    }

    public ArticleThumbnail getItem(int position) {
        return articleThumbnailList.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    //要显示的子项数量
    @Override
    public int getItemCount() {
        return articleThumbnailList.size();
    }

    //这里定义的是子项的类，不要在这里直接对获取对象进行操作
    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_article;
        TextView textView_title;
        TextView textView_abstraction;
        TextView textView_articledate;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView_articledate = itemView.findViewById(R.id.textView_articleDate);
            textView_title = itemView.findViewById(R.id.textView_title);
            textView_abstraction = itemView.findViewById(R.id.textView_abstraction);
            imageView_article = itemView.findViewById(R.id.imageView_article);
        }
    }

    public void setData(List<ArticleThumbnail> list) {
        articleThumbnailList.clear();
        articleThumbnailList.addAll(list);
    }


}