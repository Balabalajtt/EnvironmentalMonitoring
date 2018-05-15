package com.ute.environmentalmonitoring.work.presenter.view;

import com.ute.environmentalmonitoring.base.presenter.view.BaseView;
import com.ute.environmentalmonitoring.work.data.gson.FirstData;
import com.ute.environmentalmonitoring.work.data.gson.SecondData;

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public interface SecondView extends BaseView {
    void onRefresh();

    void onGetDataFail();
    void onGetDataSucc(List<SecondData> datas);
}
