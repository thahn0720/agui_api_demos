package thahn.java.agui.test.http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;


public class HttpTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		JSONObject ret;
		try {
			ret = new JSONObject(MyHttp.getInstance().checkAnnounce(0));
			int code = ret.getInt(ResponseCode.RESPONSE_CODE);
			
			switch (code) {
			case ResponseCode.RESPONSE_CODE_SUCCESS:
				JSONArray jarray = ret.getJSONArray(ResponseCode.JSON_ANNOUNCE_ARRAY);
				int length = jarray.length();
				
				for(int i=0;i<length;++i) {
					JSONObject temp = jarray.getJSONObject(i);
					String title = temp.getString(ResponseCode.JSON_TITLE);
					String content = temp.getString(ResponseCode.JSON_CONTENT);
				}
				break;
			case ResponseCode.RESPONSE_CODE_FAIL:
				break;
			case ResponseCode.RESPONSE_CODE_INTERNET_NOT_CONNECTED:
				break;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
}
