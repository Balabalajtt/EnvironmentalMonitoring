package com.ute.environmentalmonitoring.work.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ute.environmentalmonitoring.R;
import com.ute.environmentalmonitoring.base.common.Constant;
import com.ute.environmentalmonitoring.base.ui.activity.BaseMvpActivity;
import com.ute.environmentalmonitoring.work.presenter.LoginPresenter;
import com.ute.environmentalmonitoring.work.presenter.view.LoginView;

public class LogActivity extends BaseMvpActivity<LoginPresenter> implements LoginView, View.OnClickListener {

    private ImageView mImBack;
    private TextView mTitle;

    private Button mBtGoRegister;
    private LinearLayout mLlLogin;
    private LinearLayout mLlRegister;
    private EditText mEtPhoneLogin;
    private EditText mEditPwdLogin;
    private Button mBtLogin;

    private RadioGroup mRadioGroup;
    private String mUserType;
    private EditText mEtCodeRegister;
    private EditText mEditNameRegister;
    private EditText mEtPhoneRegister;
    private EditText mEditPwdRegister;
    private Button mBtRegister;

    private static final String TAG = "LogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);


        Constant.context = this;

        mPresenter = new LoginPresenter();
        mPresenter.mView = this;

        initView();
    }

    private void initView() {
        mImBack = findViewById(R.id.im_back);
        mBtGoRegister = findViewById(R.id.bt_go_register);
        mBtRegister = findViewById(R.id.bt_register);
        mBtLogin = findViewById(R.id.bt_login);
        mImBack.setOnClickListener(this);
        mBtGoRegister.setOnClickListener(this);
        mBtRegister.setOnClickListener(this);
        mBtLogin.setOnClickListener(this);

        mTitle = findViewById(R.id.tv_title);
        mLlLogin = findViewById(R.id.ll_login);
        mLlRegister = findViewById(R.id.ll_register);
        mEtPhoneLogin = findViewById(R.id.et_phone);
        mEditPwdLogin = findViewById(R.id.et_pwd);
        mEtCodeRegister = findViewById(R.id.et_code);
        mEditNameRegister = findViewById(R.id.et_name);
        mEtPhoneRegister = findViewById(R.id.et_phone_register);
        mEditPwdRegister = findViewById(R.id.et_pwd_register);
        mRadioGroup = findViewById(R.id.radio_group);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.rb_zhengfu:
                        mUserType = "政府用户";
                        break;
                    case R.id.rb_qiye:
                        mUserType = "企业用户";
                        break;
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.im_back:
                mImBack.setVisibility(View.INVISIBLE);
                mLlLogin.setVisibility(View.VISIBLE);
                mLlRegister.setVisibility(View.GONE);
                mTitle.setText("登录");
                break;
            case R.id.bt_go_register:
                mLlLogin.setVisibility(View.GONE);
                mLlRegister.setVisibility(View.VISIBLE);
                mImBack.setVisibility(View.VISIBLE);
                mTitle.setText("注册");
                break;
            case R.id.bt_login:
                mPresenter.login(mEtPhoneLogin.getText().toString(), mEditPwdLogin.getText().toString());
                break;
            case R.id.bt_register:
                break;
        }
    }

    @Override
    public void onLoginFail(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSucc(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LogActivity.this, MainActivity.class));
        finish();
    }
}
