package thahn.java.agui.test;

import thahn.java.agui.app.BroadcastReceiver;
import thahn.java.agui.app.Context;
import thahn.java.agui.app.Context;
import thahn.java.agui.app.Intent;
import thahn.java.agui.utils.Log;

public class BroadcastReceiverTest extends BroadcastReceiver {
	
	private Context 										mContext;

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.e("BroadcastReceiverTest : onReceive");
		if (intent.getAction().equals("com.google.agui.c2dm.intent.REGISTRATION")) {
			handleRegistration(context, intent);
		} else if (intent.getAction().equals("com.google.agui.c2dm.intent.RECEIVE")) {
			handleMessage(context, intent);
		}
	}

	private void handleRegistration(Context context, Intent intent) {
//		Log.e(TAG, "handleRegistration");
//		String registration = intent.getStringExtra("registration_id");
//		if (intent.getStringExtra("error") != null) {
//			// Registration failed, should try again later.
//		} else if (intent.getStringExtra("unregistered") != null) {
//			Log.e(TAG, "unregistered");
//		} else if (registration != null) {
//			// Send the registration ID to the 3rd party site that is sending
//			// the messages.
//			// This should be done in a separate thread.
//			// When done, remember that all registration is done.
//			Log.e(TAG, registration);
//			
//			if(Global.getNumber() != null) {
//				MyHttp.getInstance().registerC2DMid(Global.getNumber(), registration);
//			} else {
//				MyToast.show("register c2dm error");
//			}
//		}
	}

	private void handleMessage(Context context, Intent arg1) {
//		Log.e(TAG, "handleMessage");
//		MyToast.show("c2dm received");
//
//		Intent intent = null;
//		mContext = context;
//		
//		String msg = arg1.getStringExtra("msg");
//		try {
//			JSONObject obj = new JSONObject(msg);
//			int type = Integer.parseInt(obj.getString("type"));
//			
//			switch(type) {
//			case Event.C2DM_NOTIFY_EVENT_CREATE:					// event
//				processPEventCreate(obj);
//				break;
//			case Event.C2DM_NOTIFY_EVENT_END:
//				processPEventEnd(obj);
//				break;
//			case Event.C2DM_NOTIFY_CHATTING_ARRIVE:
//				processChattingArrive(obj);
//				break;
//			case Event.C2DM_NOTIFY_POLL_CREATE:
//				processPollCreate(obj);
//				break;
//			case Event.C2DM_NOTIFY_POLL_END:
//				processPollEnd(obj);
//				break;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
