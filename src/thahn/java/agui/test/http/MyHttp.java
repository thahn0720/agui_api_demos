package thahn.java.agui.test.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import thahn.java.agui.utils.Log;


public class MyHttp {
	private static final String FORMAT = HTTP.UTF_8;
	private static final String URL = "http://210.118.56.97/AndroLockBoyServer/";
	private static final Charset CHARSET = Charset.forName(FORMAT);
	
//	private MyHttpVal mMyHttpVal; 
	private HttpClient mClient;
	private HttpPost mRequest;
		
	private static MyHttp mMyHttp;
	public static MyHttp getInstance() {			// singleton
		if(mMyHttp == null) {
			mMyHttp = new MyHttp();
			mMyHttp.setClient(new DefaultHttpClient());
			mMyHttp.setRequest(new HttpPost());
		}
		return mMyHttp;
	}
	
	
	private HttpClient getClient() {
		return mClient;
	}
	private void setClient(HttpClient mClient) {
		this.mClient = mClient;
	}
	private HttpPost getRequest() {
		return mRequest;
	}
	private void setRequest(HttpPost mRequest) {
		this.mRequest = mRequest;
	}

	private String setHttpPost(String method, List<NameValuePair> params) {
		StringBuilder ret = new StringBuilder();
		try {
			mRequest.setURI(URI.create( new StringBuilder(URL).append(method).toString() ));
			mRequest.setEntity(new UrlEncodedFormEntity(params, FORMAT));

			HttpResponse response = mClient.execute(mRequest);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
//				System.out.println(line);
				Log.e("MyHttp", method + ":" + line);
				ret.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("MyHttp", method + ": Internet is not good or server die.");
			return "-1";
//			mHandler.sendEmptyMessage(0);
		}
		
		return ret.toString();
	}
	
	private String setHttpPostWithMultipart(String method, MultipartEntity params) {
		StringBuilder ret = new StringBuilder();
		try {
			mRequest.setURI(URI.create( new StringBuilder(URL).append(method).toString() ));
	        mRequest.setEntity(params);
	        
			HttpResponse response = mClient.execute(mRequest);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
//				System.out.println("upload : " + line);
				Log.e("MyHttp", method + ":" + line);
				ret.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("MyHttp", method + ": Internet is not good or server die.");
			return "-1";
//			mHandler.sendEmptyMessage(0);
		}
		
		return ret.toString();
	}
	
	public String checkAnnounce(long created) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(ResponseCode.JSON_CREATED, String.valueOf(created)));
		return setHttpPost("announce/check", params);
	}
//	
//	public String registerCommunity(String title, String content, String path) {
//		MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);	        
//		FileBody bin = new FileBody(new File(path));
//        try {
//			reqEntity.addPart("process", new StringBody("write_community", CHARSET));
//	        reqEntity.addPart("grauthor", new StringBody(Global.number, CHARSET));
//	        reqEntity.addPart("grtitle", new StringBody(title, CHARSET));
//	        reqEntity.addPart("grcontent", new StringBody(content, CHARSET));
//	        reqEntity.addPart("grimage", bin);
//        } catch (UnsupportedEncodingException e) {
//        	e.printStackTrace();
//        }
//        return setHttpPostWithMultipart("dbpool.php", reqEntity);
//	}

}
