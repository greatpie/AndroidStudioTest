package club.greatpie.www.helloworldforzhang;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    private EditText emailText;
    private EditText passwordText;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        Button signButton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //对but进行实例化
        signButton =(Button)findViewById(R.id.email_sign_in_button);
        //创建but的单击事件，参数要传匿名内部类
        emailText =(EditText)findViewById(R.id.email);
        passwordText =(EditText)findViewById(R.id.password);
        emailText.setError(getString(R.string.email_input_error));
        passwordText.setError(getString(R.string.password_input_error));

        signButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //测试使用System.out.println("hello..........");
                //要成功进行跳转到intent这个对象
                //第一个参数是原来的类，出发站以.this结尾
                //第二个参数是要跳转的类，结束站以class结尾
                //Intent in=new Intent(MainActivity.this,SecActivity.class);
                //startActivity(in);
                String username = emailText.getText().toString();
                String pwd = passwordText.getText().toString();
                if (username.equals(getString(R.string.email_account)) && pwd.equals(getString(R.string.email_password))) {
                    //密码确认
                }
            }

        });
    }
}
