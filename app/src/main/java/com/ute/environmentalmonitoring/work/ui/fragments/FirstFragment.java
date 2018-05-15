package com.ute.environmentalmonitoring.work.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.ute.environmentalmonitoring.R;
import com.ute.environmentalmonitoring.base.ui.fragment.BaseMvpFragment;
import com.ute.environmentalmonitoring.work.data.gson.FirstData;
import com.ute.environmentalmonitoring.work.presenter.FirstPresenter;
import com.ute.environmentalmonitoring.work.presenter.view.FirstView;
import com.ute.environmentalmonitoring.work.ui.adapter.PopAdapter;

import java.util.ArrayList;

/**
 * Created by 江婷婷 on 2018/5/10.
 */

public class FirstFragment extends BaseMvpFragment<FirstPresenter> implements FirstView {

    private static final String TAG = "FirstFragment";
    private View view;

    private ArrayList<String> locations;

    private String nowLocation = "";
    private String[] locationArray = {"nationalaqi", "blueaqi", "aroundaqi"};

    private PopAdapter adapter;

    private TextView mTvLocation;
    private ImageView mImLocation;
    private ListView mListView;
    private PopupWindow mPopupWindow;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private TextView mTvAqi;
    private TextView mTvStatus;
    private TextView mTvTemp;
    private TextView mTvHum;
    private TextView mTvPm25;
    private TextView mTvPm10;
    private TextView mTvSo2;
    private TextView mTvO3;
    private TextView mTvNo2;
    private TextView mTvCo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = new FirstPresenter();
        mPresenter.mView = this;

        view = inflater.inflate(R.layout.fragment_one, container, false);

        initData();
        initPop();
        initView();

        nowLocation = "nationalaqi";
        mPresenter.getFirstData(nowLocation);

        return view;
    }

    private void initView() {

        mTvAqi = view.findViewById(R.id.tv_aqi);
        mTvStatus = view.findViewById(R.id.tv_status);
        mTvTemp = view.findViewById(R.id.tv_temp);
        mTvHum = view.findViewById(R.id.tv_hum);
        mTvPm25 = view.findViewById(R.id.tv_pm25);
        mTvPm10 = view.findViewById(R.id.tv_pm10);
        mTvSo2 = view.findViewById(R.id.tv_so2);
        mTvO3 = view.findViewById(R.id.tv_o3);
        mTvNo2 = view.findViewById(R.id.tv_no2);
        mTvCo = view.findViewById(R.id.tv_co);

        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getFirstData(nowLocation);
            }
        });
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
                nowLocation = locationArray[i];
                mPopupWindow.dismiss();
                mPresenter.getFirstData(nowLocation);
            }

        });

    }

    private void initData() {
        locations = new ArrayList<>();
        locations.add("国控点");
        locations.add("蓝居");
        locations.add("环科院");

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
        if (mSwipeRefreshLayout != null && !mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void onGetDataFail() {
        Toast.makeText(getContext(), "获取数据失败，请重试。", Toast.LENGTH_SHORT).show();
        if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onGetDataSucc(FirstData data) {

        mTvAqi.setText(data.getAqi() + "");
        mTvStatus.setText(data.getStatus() + "");
        mTvTemp.setText(data.getTemperature() + "℃");
        mTvHum.setText(data.getHumidity() + "%");
        mTvPm25.setText(data.getPm25() + "ug/m3");
        mTvPm10.setText(data.getPm10() + "ug/m3");
        mTvSo2.setText(data.getSo2() + "ug/m3");
        mTvO3.setText(data.getO3() + "ug/m3");
        mTvNo2.setText(data.getNo2() + "ug/m3");
        mTvCo.setText(data.getCo() + "ug/m3");

        if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }

    }
}
