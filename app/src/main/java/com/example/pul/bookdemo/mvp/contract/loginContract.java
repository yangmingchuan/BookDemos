package com.example.pul.bookdemo.mvp.contract;

import com.example.pul.bookdemo.mvp.bean.UserBean;

/**
 * @packageName: com.example.pul.bookdemo.mvp.contract
 * @fileName: loginContract
 * @date: 2018/2/28  9:38
 * @author: ymc
 * @QQ:745612618
 * 登录模块 view 和 model 接口
 */

public interface loginContract {

    /**
     * view 层 接口
     */
     interface  IViewContract{
        String getUserName();

        String getPassword();

        void showLoading();

        void hideLoading();

        void toMainActivity(UserBean user);

        void showFailedError();
    }

    /**
     *  model  业务处理层 接口
     */
     interface IModelContract{

         void login(String username, String password, OnLoginListener loginListener);

         interface OnLoginListener{

            void loginSuccess(UserBean user);

            void loginFailed();
        }
    }

}
