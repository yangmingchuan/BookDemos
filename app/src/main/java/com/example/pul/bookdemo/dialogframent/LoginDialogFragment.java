package com.example.pul.bookdemo.dialogframent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.pul.bookdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yangmingchuan on 2018/3/5.
 * Email:18768880074@163.com
 * com.example.pul.bookdemo.dialogframent
 */

public class LoginDialogFragment extends DialogFragment {

    @BindView(R.id.id_txt_username)
    EditText idTxtUsername;
    @BindView(R.id.id_txt_password)
    EditText idTxtPassword;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface LoginInputListener {
        void onLoginInputComplete(String username, String password);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_dialog_orgen, null);
        unbinder = ButterKnife.bind(this, view);
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Sign in",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                LoginInputListener listener = (LoginInputListener) getActivity();
                                listener.onLoginInputComplete(idTxtUsername
                                        .getText().toString(), idTxtPassword
                                        .getText().toString());
                            }
                        }).setNegativeButton("Cancel", null);
        return builder.create();
    }
}
