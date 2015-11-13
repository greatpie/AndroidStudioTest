# 武汉大学android开发课程作业
作者：武汉大学新闻与传播学院 张丽婧
标签（空格分隔）： android whu zlj

---
**开发环境**

 1. 开发工具：android studio
 2. SDK版本：API15，android4.0.3
 3. 运行要求：RAM>256MB

**功能概述**

 1. 实现启动页面（*HellowWordActivity*），通过按钮点击事件跳转到邮箱登录界面(*MainActivity*)
 2. 邮箱登录界面正则匹配正确的邮箱及密码格式，并有错误提示。
 3. 正确邮箱名为zlj@gmail.com，密码为whu2015，此值可在string.xml中修改。

**重要代码**

 1.启动页面
 
>HelloWordActivity.java
```java
public class HelloWorldActivity extends AppCompatActivity {

    private Button buttonToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        buttonToLogin = (Button) findViewById(R.id.button_to_login);
        buttonToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(HelloWorldActivity.this, MainActivity.class);
                startActivity(in);
            }
        });
    }
}
```
>activity_hello_word.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:background="@color/colorGreen"
    tools:context="club.greatpie.www.helloworldforzhang.HelloWorldActivity">

    <TextView
        android:id="@+id/hello"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:gravity="center_horizontal"
        android:text="@string/hello_text"
        android:textSize="25dp"
        android:textColor="@color/white" />

    <TextView
        android:id="@+id/to_click"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="70dp"
        android:gravity="center_horizontal"
        android:text="@string/to_click"
        android:textSize="25dp"
        android:textColor="@color/white" />

    <Button
        android:id="@+id/button_to_login"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="130dp"
        android:gravity="center_horizontal"
        android:text="@string/button_to_login"
        android:textSize="25dp"
        android:textColor="@color/black" />
</RelativeLayout>
```
2.登录页面
 
>MainActivity.java
```java
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
```
>activity_main.xml
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools" android:layout_width="match_parent"
    android:layout_height="match_parent" android:gravity="center_horizontal"
    android:orientation="vertical" android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin" tools:context=".LoginActivity">

    <!-- Login progress -->
    <ProgressBar android:id="@+id/login_progress" style="?android:attr/progressBarStyleLarge"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:layout_marginBottom="8dp" android:visibility="gone" />

    <ScrollView android:id="@+id/login_form" android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout android:id="@+id/email_login_form" android:layout_width="match_parent"
            android:layout_height="wrap_content" android:orientation="vertical">

            <android.support.design.widget.TextInputLayout android:layout_width="match_parent"
                android:layout_height="wrap_content">

                <AutoCompleteTextView android:id="@+id/email" android:layout_width="match_parent"
                    android:layout_height="wrap_content" android:hint="@string/prompt_email"
                    android:inputType="textEmailAddress" android:maxLines="1"
                    android:singleLine="true" />

            </android.support.design.widget.TextInputLayout>

            <android.support.design.widget.TextInputLayout android:layout_width="match_parent"
                android:layout_height="wrap_content">

                <EditText android:id="@+id/password" android:layout_width="match_parent"
                    android:layout_height="wrap_content" android:hint="@string/prompt_password"
                    android:imeActionId="@+id/login"
                    android:imeActionLabel="@string/action_sign_in_short"
                    android:imeOptions="actionUnspecified" android:inputType="textPassword"
                    android:maxLines="1" android:singleLine="true" />

            </android.support.design.widget.TextInputLayout>

            <Button android:id="@+id/email_sign_in_button" style="?android:textAppearanceSmall"
                android:layout_width="match_parent" android:layout_height="wrap_content"
                android:layout_marginTop="16dp" android:text="@string/action_sign_in"
                android:textStyle="bold" />

        </LinearLayout>
    </ScrollView>
</LinearLayout>
```
3.资源文件
>string.xml
```xml
<resources>
    <string name="app_name">HelloWorldForZhang</string>
    
    <!-- Strings related to login -->
    <string name="prompt_email">邮箱账号</string>
    <string name="prompt_password">密码</string>
    <string name="action_sign_in">登陆</string>
    <string name="action_sign_in_short">Sign in</string>
    <string name="error_invalid_email">This email address is invalid</string>
    <string name="error_invalid_password">This password is too short</string>
    <string name="error_incorrect_password">This password is incorrect</string>
    <string name="error_field_required">This field is required</string>
    <string name="permission_rationale">"Contacts permissions are needed for providing email
        completions."
    </string>
    <string name="email_account">zlj@gamil.com</string>
    <string name="email_password">whu2015</string>
    <string name="email_input_error">邮箱格式错误</string>
    <string name="password_input_error">密码格式错误</string>
    <string name="hello_text">这是张丽婧的app</string>
    <string name="to_click">点击下面按钮进入邮箱登陆页面</string>
    <string name="button_to_login">点我进入</string>
</resources>
```
>color.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#3F51B5</color>
    <color name="colorPrimaryDark">#303F9F</color>
    <color name="colorAccent">#FF4081</color>
    <color name="colorGreen">#248A8A</color>
    <color name="white">#FFFFFF</color>
    <color name="black">#000000</color>
</resources>

```