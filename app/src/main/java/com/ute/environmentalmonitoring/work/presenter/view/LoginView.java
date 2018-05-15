package com.ute.environmentalmonitoring.work.presenter.view;

import com.ute.environmentalmonitoring.base.presenter.view.BaseView;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public interface LoginView extends BaseView {
    void onLoginFail(String msg);
    void onLoginSucc(String msg);

}
