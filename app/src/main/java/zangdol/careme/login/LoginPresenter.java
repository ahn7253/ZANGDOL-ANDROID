package zangdol.careme.login;


import android.widget.Toast;

import zangdol.careme.model.Login;

public class LoginPresenter implements LoginContract.Presenter, Login.OnLoginListener {
    private Login login;
    private LoginActivity loginActivity;

    public LoginPresenter(LoginActivity view) {
        loginActivity = view;
        login = new Login();
        login.setLoginListener(this);
    }

    /*
     * 로그인 버튼 눌렸을 때 실행되는 과정
     * */
    @Override
    public void login(String id, String pw) {
        login.login(id, pw);
    }

    @Override
    public void onLogin(boolean isSuccess) {

        final String message;

        if (isSuccess)
            message = "로그인 성공";
        else
            message = "로그인 실패";

        loginActivity.runOnUiThread(new Runnable() { // Toast를 띄우기 위해서 runOnUiThead를 사용.
            @Override
            public void run() {
                Toast toast = Toast.makeText(loginActivity, message, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        if(isSuccess)
            loginActivity.moveMainActivity();

    }
}