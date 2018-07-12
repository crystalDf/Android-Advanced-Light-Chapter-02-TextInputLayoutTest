package com.star.textinputlayouttest;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";

    private TextInputLayout mUsername;
    private TextInputLayout mPassword;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mLogin = findViewById(R.id.login);
        mLogin.setOnClickListener(v -> login());
    }

    private void login() {

        String username = mUsername.getEditText().getText().toString();
        String password = mPassword.getEditText().getText().toString();

        if (!validateUserName(username)) {

            mUsername.setErrorEnabled(true);
            mUsername.setError("请输入正确的邮箱地址");
        } else if (!validatePassword(password)) {

            mPassword.setErrorEnabled(true);
            mPassword.setError("密码数字过少");

        } else {

            mUsername.setErrorEnabled(false);
            mPassword.setErrorEnabled(false);

            Snackbar.make(mLogin, "登录成功", Snackbar.LENGTH_LONG).show();
        }
    }

    private boolean validateUserName(String username) {

        return Pattern.compile(EMAIL_PATTERN).matcher(username).matches();
    }

    private boolean validatePassword(String password) {

        return password.length() > 6;
    }
}
