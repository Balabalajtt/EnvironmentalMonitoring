package com.ute.environmentalmonitoring.work.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.ute.environmentalmonitoring.R;
import com.ute.environmentalmonitoring.base.common.ChartUtil;
import com.ute.environmentalmonitoring.base.ui.fragment.BaseMvpFragment;
import com.ute.environmentalmonitoring.work.data.gson.SecondData;
import com.ute.environmentalmonitoring.work.presenter.SecondPresenter;
import com.ute.environmentalmonitoring.work.presenter.view.SecondView;
import com.ute.environmentalmonitoring.work.ui.adapter.CompareDataAdapter;
import com.ute.environmentalmonitoring.work.ui.adapter.PopAdapter;
import com.ute.environmentalmonitoring.work.data.CompareData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/10.
 */

public class SecondFragment extends BaseMvpFragment<SecondPresenter> implements View.OnClickListener, SecondView {

    private static final String TAG = "SecondFragment";

    private ArrayList<SecondData> mSecondDatas;

    private RecyclerView mRecyclerView;
    private CompareDataAdapter mAdapter;

    private Button mBtDay;
    private Button mBtWeek;
    private Button mBtMonth;

    private TextView mTvAQI;
    private TextView mTvPM25;
    private TextView mTvPM10;
    private TextView mTvSO2;
    private TextView mTvO3;
    private TextView mTvNO2;
    private TextView mTvCO;

    private ArrayList<String> locations;
    private PopAdapter adapter;
    private TextView mTvLocation;
    private ImageView mImLocation;
    private ListView mListView;
    private PopupWindow mPopupWindow;

    private LineChart mChart;

    private String[] locationArray = {"blueaqi", "aroundaqi"};
    private String position = "blueaqi";
    private String target = "aqi";
    private int type = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mPresenter = new SecondPresenter();
        mPresenter.mView = this;

        initData();
        initPop();
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        mImLocation = view.findViewById(R.id.im_location);
        mImLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPopupWindow.isShowing()){
                    mPopupWindow.dismiss();
                }else{
                    mPopupWindow.showAsDropDown(mImLocation);
                }
            }
        });
        mTvLocation = view.findViewById(R.id.tv_location);
        mTvLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPopupWindow.isShowing()){
                    mPopupWindow.dismiss();
                }else{
                    mPopupWindow.showAsDropDown(mImLocation);
                }
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mTvLocation.setText(locations.get(i) + "");
                position = locationArray[i];
                mPopupWindow.dismiss();
                mPresenter.getSecondData(position, type, target);
            }
        });

        mTvAQI = view.findViewById(R.id.tv_aqi);
        mTvPM25 = view.findViewById(R.id.tv_pm25);
        mTvPM10 = view.findViewById(R.id.tv_pm10);
        mTvSO2 = view.findViewById(R.id.tv_so2);
        mTvO3 = view.findViewById(R.id.tv_o3);
        mTvNO2 = view.findViewById(R.id.tv_no2);
        mTvCO = view.findViewById(R.id.tv_co);
        mTvAQI.setOnClickListener(this);
        mTvPM25.setOnClickListener(this);
        mTvPM10.setOnClickListener(this);
        mTvSO2.setOnClickListener(this);
        mTvO3.setOnClickListener(this);
        mTvNO2.setOnClickListener(this);
        mTvCO.setOnClickListener(this);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mAdapter = new CompareDataAdapter(getContext(), mSecondDatas);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);

        mBtDay = view.findViewById(R.id.bt_day);
        mBtDay.setOnClickListener(this);
        mBtWeek = view.findViewById(R.id.bt_week);
        mBtWeek.setOnClickListener(this);
        mBtMonth = view.findViewById(R.id.bt_month);
        mBtMonth.setOnClickListener(this);


        mChart = view.findViewById(R.id.chart);
        Log.d(TAG, "onCreateView: " + mChart);
        ChartUtil.initChart(mChart);
        ChartUtil.notifyDataSetChanged(mChart, getChartData(), ChartUtil.dayValue);

        mPresenter.getSecondData(position, 0, target);

        return view;
    }

    private List<Entry> getChartData() {
        List<Entry> values = new ArrayList<>();
        values.add(new Entry(0, 15));
        values.add(new Entry(1, 15));
        values.add(new Entry(2, 15));
        values.add(new Entry(3, 20));
        values.add(new Entry(4, 25));
        values.add(new Entry(5, 20));
        values.add(new Entry(6, 20));
        return values;
    }

    private void initData() {

        locations = new ArrayList<>();
        locations.add("蓝居");
        locations.add("环科院");

        mSecondDatas = new ArrayList<>();
//        int count = 10;
//        while(count > 0) {
//            mCompareData.add(new CompareData("05-01 11:00", 77, 75));
//            count--;
//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_day:
                setAllBtUnSelect();
                setBtSelect(mBtDay);
                type = 0;
                mPresenter.getSecondData(position, 0, target);
                break;
            case R.id.bt_week:
                setAllBtUnSelect();
                setBtSelect(mBtWeek);
                type = 1;
                mPresenter.getSecondData(position, 1, target);
                break;
            case R.id.bt_month:
                setAllBtUnSelect();
                setBtSelect(mBtMonth);
                type = 2;
                mPresenter.getSecondData(position, 2, target);
                break;
            case R.id.tv_aqi:
                setAllTvUnSelect();
                setTvSelect(mTvAQI);
                target = "aqi";
                mPresenter.getSecondData(position, type, target);
                break;
            case R.id.tv_pm25:
                setAllTvUnSelect();
                setTvSelect(mTvPM25);
                target = "pm25";
                mPresenter.getSecondData(position, type, target);
                break;
            case R.id.tv_pm10:
                setAllTvUnSelect();
                setTvSelect(mTvPM10);
                target = "pm10";
                mPresenter.getSecondData(position, type, target);
                break;
            case R.id.tv_so2:
                setAllTvUnSelect();
                setTvSelect(mTvSO2);
                target = "so2";
                mPresenter.getSecondData(position, type, target);
                break;
            case R.id.tv_o3:
                setAllTvUnSelect();
                setTvSelect(mTvO3);
                target = "o3";
                mPresenter.getSecondData(position, type, target);
                break;
            case R.id.tv_no2:
                setAllTvUnSelect();
                setTvSelect(mTvNO2);
                target = "no2";
                mPresenter.getSecondData(position, type, target);
                break;
            case R.id.tv_co:
                setAllTvUnSelect();
                setTvSelect(mTvCO);
                target = "co";
                mPresenter.getSecondData(position, type, target);
                break;
        }
    }

    private void setAllTvUnSelect() {
        mTvAQI.setTextColor(getResources().getColor(R.color.colorTrans));
        mTvPM25.setTextColor(getResources().getColor(R.color.colorTrans));
        mTvPM10.setTextColor(getResources().getColor(R.color.colorTrans));
        mTvSO2.setTextColor(getResources().getColor(R.color.colorTrans));
        mTvO3.setTextColor(getResources().getColor(R.color.colorTrans));
        mTvNO2.setTextColor(getResources().getColor(R.color.colorTrans));
        mTvCO.setTextColor(getResources().getColor(R.color.colorTrans));
    }

    private void setTvSelect(TextView textView) {
        textView.setTextColor(getResources().getColor(R.color.colorGreen));
    }

    private void setAllBtUnSelect() {
        mBtDay.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        mBtDay.setTextColor(getResources().getColor(R.color.colorGreen));
        mBtWeek.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        mBtWeek.setTextColor(getResources().getColor(R.color.colorGreen));
        mBtMonth.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        mBtMonth.setTextColor(getResources().getColor(R.color.colorGreen));
    }
    private void setBtSelect(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.colorGreen));
        button.setTextColor(getResources().getColor(R.color.colorWhite));

    }

    private void initPop() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.popwindow_layout, null);
        adapter = new PopAdapter(getContext(), locations);
        mListView = view.findViewById(R.id.list_view);
        mListView.setAdapter(adapter);
        mPopupWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setContentView(view);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onGetDataFail() {
        Toast.makeText(getContext(), "获取失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetDataSucc(List<SecondData> datas) {
        Log.d(TAG, "onGetDataSucc: " + datas.size());
        mSecondDatas.clear();
        mSecondDatas.addAll(datas);
        mAdapter.notifyDataSetChanged();
        ChartUtil.notifyDataSetChanged(mChart, getChartData(), ChartUtil.dayValue);
    }
}
