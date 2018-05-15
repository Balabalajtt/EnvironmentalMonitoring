package com.ute.environmentalmonitoring.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ute.environmentalmonitoring.base.presenter.BasePresenter;
import com.ute.environmentalmonitoring.base.presenter.view.BaseView;
import com.ute.environmentalmonitoring.base.ui.activity.BaseActivity;

/**
 * Created by 江婷婷 on 2018/5/14.
 */

public class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void start() {

    }
}
