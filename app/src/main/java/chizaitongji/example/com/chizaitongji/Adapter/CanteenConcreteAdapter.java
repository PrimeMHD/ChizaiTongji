package chizaitongji.example.com.chizaitongji.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chizaitongji.example.com.chizaitongji.Bean.CanteenThumbnail;
import chizaitongji.example.com.chizaitongji.Bean.SubCanteenInfo;
import chizaitongji.example.com.chizaitongji.R;

/**
 * Created by Mi HD on 2018/3/24.
 */

public class CanteenConcreteAdapter extends RecyclerView.Adapter<CanteenConcreteAdapter.MyViewHolder> {


    private List<SubCanteenInfo> subCanteenInfoList;

    public CanteenConcreteAdapter(List<SubCanteenInfo> subCanteenInfoList) {
        this.subCanteenInfoList = subCanteenInfoList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_canteen_sub, parent, false);
        final MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    //在这里可以获得每个子项里面的控件的实例，比如这里的TextView,子项本身的实例是itemView，
// 在这里对获取对象进行操作
    //holder.itemView是子项视图的实例，holder.textView是子项内控件的实例
    //position是点击位置
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //设置显示内容为list里的对应项
        SubCanteenInfo subCanteenInfo = subCanteenInfoList.get(position);
        Log.d("CANTEENCON", subCanteenInfoList.size() + "");
        Log.d("CANTEENCON", subCanteenInfo.getSubCanteenName() + "" + position);

        holder.textView_subCanteenName.setText(subCanteenInfo.getSubCanteenName());

//        holder.imageView_canteenthumbnail.setImageResource(canteenThumbnail.getImageId());
        //holder.textView_canteeninfo.setText(canteenThumbnail.getCanteenInfo());
        holder.textView_subCanteenDetail.setText(subCanteenInfo.getSubCanteenDetail());
        //子项的点击事件监听
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    //要显示的子项数量
    @Override
    public int getItemCount() {
        return subCanteenInfoList.size();
    }

    //这里定义的是子项的类，不要在这里直接对获取对象进行操作
    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_subCanteenName;
        TextView textView_subCanteenDetail;


        public MyViewHolder(View itemView) {
            super(itemView);
            textView_subCanteenName = itemView.findViewById(R.id.textView_subCanteenName);

            textView_subCanteenDetail = itemView.findViewById(R.id.textView_subCanteenDetail);
        }
    }

    /*之下的方法都是为了方便操作，并不是必须的*/

//    //在指定位置插入，原位置的向后移动一格
//    public boolean addItem(int position, String msg) {
//        if (position < list.size() && position >= 0) {
//            list.add(position, msg);
//            notifyItemInserted(position);
//            return true;
//        }
//        return false;
//    }
//
//    //去除指定位置的子项
//    public boolean removeItem(int position) {
//        if (position < list.size() && position >= 0) {
//            list.remove(position);
//            notifyItemRemoved(position);
//            return true;
//        }
//        return false;
//    }
//
//    //清空显示数据
//    public void clearAll() {
//        list.clear();
//        notifyDataSetChanged();
//    }
}