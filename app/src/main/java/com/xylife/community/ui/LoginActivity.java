package com.xylife.community.ui;

import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.xylife.community.R;
import com.xylife.community.base.BaseTextActivity;

import butterknife.BindView;

public class LoginActivity extends BaseTextActivity {

    @BindView(R.id.forget_pwd)
    AppCompatTextView forgetPwd;
    @BindView(R.id.login)
    Button loginBtn;

    @BindView(R.id.account_editor)
    EditText accountText;
    @BindView(R.id.psw_editor)
    EditText passwordText;

    private String mUserName = "";
    private String mPassword = "";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        mBackBtn.setVisibility(View.GONE);
        mTitleText.setText(R.string.login);
        mRightText.setText(R.string.register);

        //forgetPwd.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        forgetPwd.getPaint().setAntiAlias(true);

        mRightText.setOnClickListener(this);
        forgetPwd.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void initData() {
        accountText.setText("15001066722");
        passwordText.setText("123456");
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.forget_pwd:
                gotoActivity(ForgetPwdActivity.class);
                break;
            case R.id.login:
                handleLogin();
                break;
            case R.id.right_text:
                gotoActivity(RegisterActivity.class);
                break;
            default:
                break;
        }
    }

    private void handleLogin() {

        if (prepareForLogin()) {
            return;
        }

        // if the data has ready
        mUserName = accountText.getText().toString();
        mPassword = passwordText.getText().toString();

        gotoActivity(MainActivity.class,true);
    }

    private boolean prepareForLogin() {
        /*if (!NetUtil.isNetConnected(this)) {
            AppToast.showShortText(LoginActivity.this,"没有网络");
            return true;
        }
        if (accountText.getText().length() == 0) {
            AppToast.showShortText(LoginActivity.this,"邮箱不能为空!");
            accountText.requestFocus();
            return true;
        }

        if (passwordText.getText().length() == 0) {
            AppToast.showShortText(LoginActivity.this,"密码不能为空");
            passwordText.requestFocus();
            return true;
        }

        if (passwordText.getText().toString().length() < 6) {
            AppToast.showShortText(LoginActivity.this,"密码过短，请重新输入!");
            passwordText.requestFocus();
            return true;
        }*/


        return false;
    }

}
