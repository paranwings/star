package com.forwiz.star;

import com.forwiz.star.Util.HttpUtil;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class LogIn extends Activity {
	EditText loginIdEt, loginPwEt;
	private HttpUtil httpUtil;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
//		setContentView(R.layout.login);
//		loginIdEt = (EditText) findViewById(R.id.login_id);
//		loginPwEt = (EditText) findViewById(R.id.login_pw);
		super.onCreate(savedInstanceState);
	}

}
