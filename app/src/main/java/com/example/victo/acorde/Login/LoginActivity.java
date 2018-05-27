package com.example.victo.acorde.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.victo.acorde.Main.MainActivity;
import com.example.victo.acorde.Nutricionista.NutricionistaActivity;
import com.example.victo.acorde.R;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginActivity extends AppCompatActivity implements LoginView{
    @BindView(R.id.text_input_layout_username) TextInputLayout usernameTextInputLayout;
    @BindView (R.id.edit_text_username) TextInputEditText usernameEditText;
    @BindView (R.id.text_input_layout_password) TextInputLayout passwordTextInputLayout;
    @BindView (R.id.edit_text_password) TextInputEditText passwordEditText;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind( this );

        loginPresenter = new LoginPresenter(this);
    }

    @OnTextChanged (R.id.edit_text_username)
    public void validaUsuario (){
        usernameTextInputLayout.setErrorEnabled( false );
        usernameTextInputLayout.setError( "" );
    }

    @OnTextChanged (R.id.edit_text_password)
    public void validaSenha (){
        passwordTextInputLayout.setErrorEnabled( false );
        passwordTextInputLayout.setError( "" );
    }

    @OnClick (R.id.button_login)
    public void fazLogin (){
        loginPresenter.login(usernameEditText.getText().toString(), passwordEditText.getText().toString());
    }

    public void erroUsuario(){
        usernameTextInputLayout.setErrorEnabled( true );
        usernameTextInputLayout.setError(getString(R.string.invalid_username));
    }

    public void erroSenha(){
        passwordTextInputLayout.setErrorEnabled( true );
        passwordTextInputLayout.setError(getString(R.string.invalid_password));
    }

    public void loginComSucesso(){
        Intent abrirMainActivity = new Intent(LoginActivity.this , MainActivity.class);
        startActivity(abrirMainActivity);
    }
}
