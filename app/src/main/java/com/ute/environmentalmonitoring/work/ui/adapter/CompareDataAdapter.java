package com.ute.environmentalmonitoring.work.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ute.environmentalmonitoring.R;
import com.ute.environmentalmonitoring.work.data.CompareData;
import com.ute.environmentalmonitoring.work.data.gson.SecondData;

import java.util.ArrayList;

/**
 * Created by 江婷婷 on 2018/5/13.
 */

public class CompareDataAdapter extends RecyclerView.Adapter<CompareDataAdapter.MyHolder> {

    private Context mContext;
    private ArrayList<SecondData> mDatas;

    public CompareDataAdapter(Context context, ArrayList<SecondData> datas) {
        super();
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.mTvTime.setText(mDatas.get(position).getTimestamp().substring(5, 16) + "");
        holder.mTvLocal.setText(mDatas.get(position).getPositionTarget() + "");
        holder.mTvNation.setText(mDatas.get(position).getNationalTarget() + "");
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.two_rv_itm, null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView mTvTime;
        private TextView mTvLocal;
        private TextView mTvNation;

        public MyHolder(View view) {
            super(view);
            mTvTime = view.findViewById(R.id.tv_time);
            mTvLocal = view.findViewById(R.id.tv_local);
            mTvNation = view.findViewById(R.id.tv_nation);

        }
    }

}