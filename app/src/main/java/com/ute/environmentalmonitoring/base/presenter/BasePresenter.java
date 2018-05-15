package com.ute.environmentalmonitoring.base.presenter;

import com.ute.environmentalmonitoring.base.presenter.view.BaseView;

/**
 * Created by 江婷婷 on 2018/5/14.
 */

public class BasePresenter<T extends BaseView> {
    public T mView;
}
