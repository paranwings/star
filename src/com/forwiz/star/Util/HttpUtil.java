package com.forwiz.star.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.forwiz.star.MainActivity;
import com.forwiz.star.R;

import android.content.Context;
import android.os.AsyncTask;
import android.webkit.WebView;

public class HttpUtil {
	public static final String HOME_URL_STAR = "http://m.cafe.daum.net/kim8804";
	public static final String DAUM_URL_API = "https://apis.daum.net";
	public static final String DAUM_URL_OAUTH_REQUESTTOKEN = "https://apis.daum.net/oauth/requestToken";
	public static final String DAUM_URL_OAUTH_AUTHORIZE = "https://apis.daum.net/oauth/authorize";
	public static final String DAUM_URL_OAUTH_ACCESSTOKEN = "https://apis.daum.net/oauth/accessToken";
	public static final String DAUM_URL_OAUTH_CONSUMER_KEY = "1001f5f3-66b4-40de-a2d3-4cdd5c489c53";
	public static final String DAUM_URL_OAUTH_CONSUMER_SECRET = "PyDIN8bhyXawk7JuI64lp6hxc8AhSfwj8vjpRhtJm6Jh7akCPMi8kg00";

	private OAuthProvider provider;
	private OAuthConsumer consumer;

	private Context ctx;
	private MainActivity act;

	public HttpUtil(Context ctx) {
		this.ctx = ctx;
	}

	public void daumAuthorize(MainActivity act) {
		this.act = act;
		async.execute();
	}

	public void requestPost(String postUrl, HashMap<String, String> paramMap) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(postUrl);
		Iterator<String> keyItr = paramMap.keySet().iterator();
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		while (keyItr.hasNext()) {
			String key = keyItr.next();
			params.add(new BasicNameValuePair(key, paramMap.get(key)));
		}
		UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
		post.setEntity(ent);
		HttpResponse responsePost = client.execute(post);
		HttpEntity resEntity = responsePost.getEntity();
		if (resEntity != null) {
			String res = EntityUtils.toString(resEntity);
		}
	}

	AsyncTask<String, String, String> async = new AsyncTask<String, String, String>() {

		@Override
		protected void onPreExecute() {
			System.out.println("start!!!!!!!!!!!!!!!!!!");
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... params) {
			System.out.println("params : " + params);
			String authUrl = "";
			try {
				provider = new DefaultOAuthProvider(DAUM_URL_OAUTH_REQUESTTOKEN, DAUM_URL_OAUTH_ACCESSTOKEN, DAUM_URL_OAUTH_AUTHORIZE);
				consumer = new DefaultOAuthConsumer(DAUM_URL_OAUTH_CONSUMER_KEY, DAUM_URL_OAUTH_CONSUMER_SECRET);
				System.out.println("consumer : " + consumer);
				System.out.println("provider : " + provider);
				authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
				System.out.println("authUrl : " + authUrl);
			} catch (OAuthMessageSignerException e) {
				e.printStackTrace();
			} catch (OAuthNotAuthorizedException e) {
				e.printStackTrace();
			} catch (OAuthExpectationFailedException e) {
				e.printStackTrace();
			} catch (OAuthCommunicationException e) {
				e.printStackTrace();
			}
			return authUrl;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
		}

		@Override
		protected void onCancelled(String result) {
			super.onCancelled(result);
		}

		@Override
		protected void onPostExecute(String result) {
			WebView mainWebView = (WebView) act.findViewById(R.id.mainWebView);
			mainWebView.loadUrl(result);
			super.onPostExecute(result);
		}
	};
}
