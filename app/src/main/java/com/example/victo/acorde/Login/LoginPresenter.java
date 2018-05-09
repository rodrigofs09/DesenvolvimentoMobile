package com.example.victo.acorde.Login;

import android.text.TextUtils;

public class LoginPresenter {
    LoginView loginView;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
    }

    public void login(String username, String password){
        if (TextUtils.isEmpty(username)) {
            loginView.erroUsuario();
        }
        else if (TextUtils.isEmpty(password)) {
            loginView.erroSenha();
        }
        else{
            loginView.loginComSucesso();
        }
    }
}
