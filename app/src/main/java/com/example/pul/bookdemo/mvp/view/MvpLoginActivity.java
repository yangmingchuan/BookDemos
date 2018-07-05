package com.example.pul.bookdemo.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pul.bookdemo.R;
import com.example.pul.bookdemo.mvp.bean.UserBean;
import com.example.pul.bookdemo.mvp.contract.loginContract;
import com.example.pul.bookdemo.mvp.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录界面
 */

public class MvpLoginActivity extends AppCompatActivity implements loginContract.IViewContract {


    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.et_pass_word)
    EditText etPassWord;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.pb)
    ProgressBar pb;

    private LoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_login})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                loginPresenter.login();
                break;
        }

    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassWord.getText().toString();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(UserBean user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
