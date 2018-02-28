package com.example.pul.bookdemo.mvp.presenter;

import android.os.Handler;

import com.example.pul.bookdemo.mvp.bean.UserBean;
import com.example.pul.bookdemo.mvp.contract.loginContract;
import com.example.pul.bookdemo.mvp.model.LoginModel;


/**
 * @packageName: com.example.pul.bookdemo.mvp.presenter
 * @fileName: LoginPresenter
 * @date: 2018/2/28  10:20
 * @author: ymc
 * @QQ:745612618
 *  login presenter 层
 */

public class LoginPresenter {
    private loginContract.IViewContract viewContract;
    private loginContract.IModelContract modelContract;
    private Handler handler = new Handler();

    public LoginPresenter (loginContract.IViewContract iViewContract){
        this.viewContract = iViewContract;
        this.modelContract = new LoginModel();
    }

    public void login()
    {
        viewContract.showLoading();
        modelContract.login(viewContract.getUserName(), viewContract.getPassword(), new loginContract.IModelContract.OnLoginListener()
        {
            @Override
            public void loginSuccess(final UserBean user)
            {
                //需要在UI线程执行
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        viewContract.toMainActivity(user);
                        viewContract.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed()
            {
                //需要在UI线程执行
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        viewContract.showFailedError();
                        viewContract.hideLoading();
                    }
                });

            }
        });
    }
}
