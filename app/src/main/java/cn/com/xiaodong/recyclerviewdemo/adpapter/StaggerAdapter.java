package cn.com.xiaodong.recyclerviewdemo.adpapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import cn.com.xiaodong.recyclerviewdemo.R;

/**
 * Created by Administrator on 2016/8/8.
 */
public class StaggerAdapter extends RecyclerView.Adapter<StaggerAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<String> list;
    private List<Integer> mHeightList = new ArrayList<>();

    public StaggerAdapter(Context context, List<String> list)
    {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.list = list;
        initHeight();
    }

    private void initHeight() {
        for (int i = 0; i < list.size(); i++)
        {
            mHeightList.add(100 + (int)(Math.random() * 200));
        }
    }


    @Override
    public StaggerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.height = mHeightList.get(position);
        holder.itemView.setLayoutParams(params);
        holder.item.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView item;

        public MyViewHolder(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.text_item);
        }
    }
}

