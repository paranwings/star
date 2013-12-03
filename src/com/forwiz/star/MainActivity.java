package com.forwiz.star;

import com.forwiz.star.Util.HttpUtil;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private WebView mainWebView;
	private HttpUtil httpUtil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);

		mainWebView = (WebView) findViewById(R.id.mainWebView);
		mainWebView.setWebChromeClient(new webChromeClient());
		httpUtil = new HttpUtil(getApplicationContext());
		httpUtil.daumAuthorize(MainActivity.this);
	}

	public class webClient extends WebViewClient {

		@Override
		public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
			super.doUpdateVisitedHistory(view, url, isReload);
		}

		@Override
		public void onFormResubmission(WebView view, Message dontResend, Message resend) {
			super.onFormResubmission(view, dontResend, resend);
		}

		@Override
		public void onLoadResource(WebView view, String url) {
			super.onLoadResource(view, url);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
			super.onReceivedError(view, errorCode, description, failingUrl);
		}

		@Override
		public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
			super.onReceivedHttpAuthRequest(view, handler, host, realm);
		}

		@Override
		public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
			super.onReceivedLoginRequest(view, realm, account, args);
		}

		@Override
		public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
			handler.proceed();
			// super.onReceivedSslError(view, handler, error);
		}

		@Override
		public void onScaleChanged(WebView view, float oldScale, float newScale) {
			super.onScaleChanged(view, oldScale, newScale);
		}

		@Override
		public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
			super.onUnhandledKeyEvent(view, event);
		}

		@Override
		public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
			return super.shouldInterceptRequest(view, url);
		}

		@Override
		public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
			return super.shouldOverrideKeyEvent(view, event);
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
			// return super.shouldOverrideUrlLoading(view, url);
		}

	}

	public class webChromeClient extends WebChromeClient {

		@Override
		public Bitmap getDefaultVideoPoster() {
			// TODO Auto-generated method stub
			return super.getDefaultVideoPoster();
		}

		@Override
		public View getVideoLoadingProgressView() {
			// TODO Auto-generated method stub
			return super.getVideoLoadingProgressView();
		}

		@Override
		public void getVisitedHistory(ValueCallback<String[]> callback) {
			// TODO Auto-generated method stub
			super.getVisitedHistory(callback);
		}

		@Override
		public void onCloseWindow(WebView window) {
			// TODO Auto-generated method stub
			super.onCloseWindow(window);
		}

		@Override
		public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
			// TODO Auto-generated method stub
			return super.onConsoleMessage(consoleMessage);
		}

		@Override
		public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
			// TODO Auto-generated method stub
			return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
		}

		@Override
		public void onExceededDatabaseQuota(String url, String databaseIdentifier, long quota, long estimatedDatabaseSize, long totalQuota,
				QuotaUpdater quotaUpdater) {
			// TODO Auto-generated method stub
			super.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);
		}

		@Override
		public void onGeolocationPermissionsHidePrompt() {
			// TODO Auto-generated method stub
			super.onGeolocationPermissionsHidePrompt();
		}

		@Override
		public void onGeolocationPermissionsShowPrompt(String origin, Callback callback) {
			// TODO Auto-generated method stub
			super.onGeolocationPermissionsShowPrompt(origin, callback);
		}

		@Override
		public void onHideCustomView() {
			// TODO Auto-generated method stub
			super.onHideCustomView();
		}

		@Override
		public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
			// TODO Auto-generated method stub
			return super.onJsAlert(view, url, message, result);
		}

		@Override
		public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
			// TODO Auto-generated method stub
			return super.onJsBeforeUnload(view, url, message, result);
		}

		@Override
		public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
			// TODO Auto-generated method stub
			return super.onJsConfirm(view, url, message, result);
		}

		@Override
		public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
			// TODO Auto-generated method stub
			return super.onJsPrompt(view, url, message, defaultValue, result);
		}

		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			// TODO Auto-generated method stub
			super.onProgressChanged(view, newProgress);
		}

		@Override
		public void onReachedMaxAppCacheSize(long requiredStorage, long quota, QuotaUpdater quotaUpdater) {
			// TODO Auto-generated method stub
			super.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater);
		}

		@Override
		public void onReceivedIcon(WebView view, Bitmap icon) {
			// TODO Auto-generated method stub
			super.onReceivedIcon(view, icon);
		}

		@Override
		public void onReceivedTitle(WebView view, String title) {
			// TODO Auto-generated method stub
			super.onReceivedTitle(view, title);
		}

		@Override
		public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
			// TODO Auto-generated method stub
			super.onReceivedTouchIconUrl(view, url, precomposed);
		}

		@Override
		public void onRequestFocus(WebView view) {
			// TODO Auto-generated method stub
			super.onRequestFocus(view);
		}

		@Override
		public void onShowCustomView(View view, CustomViewCallback callback) {
			// TODO Auto-generated method stub
			super.onShowCustomView(view, callback);
		}

	}
}
