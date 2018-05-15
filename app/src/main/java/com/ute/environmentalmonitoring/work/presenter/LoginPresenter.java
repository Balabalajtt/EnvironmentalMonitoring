package com.ute.environmentalmonitoring.work.presenter;

import android.util.Log;
import android.widget.Toast;

import com.ute.environmentalmonitoring.base.common.Constant;
import com.ute.environmentalmonitoring.base.presenter.BasePresenter;
import com.ute.environmentalmonitoring.base.rx.BaseSubscriber;
import com.ute.environmentalmonitoring.work.presenter.view.LoginView;
import com.ute.environmentalmonitoring.work.service.impl.LoginServiceImpl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    private static final String TAG = "LoginPresenter";

    public void login(String phone, String pwd) {
        new LoginServiceImpl().login(phone, pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        super.onNext(responseBody);
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            int status = jsonObject.getInt("status");
                            String msg = jsonObject.getString("msg");
                            if (status == 0) {
                                mView.onLoginFail(msg);
                            } else {
                                mView.onLoginSucc(msg);
                            }

                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }
}
