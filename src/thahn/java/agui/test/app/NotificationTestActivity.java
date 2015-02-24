package thahn.java.agui.test.app;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Context;
import thahn.java.agui.app.Notification;
import thahn.java.agui.app.NotificationManager;
import thahn.java.agui.graphics.Color;
import thahn.java.agui.test.R;
import thahn.java.agui.widget.RemoteViews;

public class NotificationTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		Notification noti = new Notification();
//		noti.icon = R.drawable.ic_launcher;
//		noti.tickerText = "NotificationTestActivity";
//		noti.when = System.currentTimeMillis();
		noti.setLatestEventInfo(this, "NotificationTestActivity", "NotificationTestActivity", null);
		noti.icon = R.drawable.progressbar0;
		noti.backgroundColor = Color.YELLOW;
		noti.contentView = new RemoteViews(getPackageName(), R.layout.notification_text);
//		noti.backgroundImgRes = R.drawable.btn_sel;
		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		nm.notify(0, noti);
		nm.notify(1, noti);
	}
}
