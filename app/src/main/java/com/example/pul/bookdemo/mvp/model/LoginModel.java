package com.example.pul.bookdemo.mvp.model;

import com.example.pul.bookdemo.mvp.bean.UserBean;
import com.example.pul.bookdemo.mvp.contract.loginContract;

/**
 * @packageName: com.example.pul.bookdemo.mvp.model
 * @fileName: LoginModel
 * @date: 2018/2/28  10:05
 * @author: ymc
 * @QQ:745612618
 * 登录 逻辑处理   model
 */

public class LoginModel implements loginContract.IModelContract {

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("ymc".equals(username) && "123".equals(password))
                {
                    UserBean user = new UserBean();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }

}
