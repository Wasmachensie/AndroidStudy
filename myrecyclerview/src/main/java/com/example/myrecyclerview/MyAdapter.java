package com.example.myrecyclerview;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Bean> data;
    private Context context;

    public MyAdapter(List<Bean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    //创建ViewHolder
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //拿到布局
        View view = View.inflate(context, R.layout.recyclerview_item, null);
        return new MyViewHolder(view);
    }

    @Override
    //绑定数据
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(data.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv1);

            //监听方法回调
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onRecyclerItemClick((getAdapterPosition()));
                    }
                }
            });
        }
    }


    //设置监听的接口
    public interface onRecyclerItemClickListener{
        void onRecyclerItemClick(int position);
    }
    //设置监听的对象
    private onRecyclerItemClickListener onItemClickListener;
    //设置监听的方法
    public void setRecyclerItemClickListener(onRecyclerItemClickListener listener){
        this.onItemClickListener = listener;
    }
}
