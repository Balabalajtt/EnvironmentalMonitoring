package com.ute.environmentalmonitoring.work.presenter.view;

import com.ute.environmentalmonitoring.base.presenter.view.BaseView;
import com.ute.environmentalmonitoring.work.data.gson.FirstData;

/**
 * Created by 江婷婷 on 2018/5/14.
 */

public interface FirstView extends BaseView {

    void onRefresh();

    void onGetDataFail();
    void onGetDataSucc(FirstData data);
}
