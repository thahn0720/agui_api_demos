package thahn.java.agui.test.media;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.media.MediaPlayer;
import thahn.java.agui.test.R;
import thahn.java.agui.view.View;
import thahn.java.agui.view.View.OnClickListener;

public class MediaPlayerTestActivity extends Activity {

	private MediaPlayer mMp;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.mediaplayer);
		mMp = MediaPlayer.create(this, R.raw.test);
//		mMp = new MediaPlayer();
//		mMp.setDataSource(Global.projectPath+"/res/raw/test.mp3");
//		mMp.prepare();
		findViewById(R.id.play).setOnClickListener(onClickListener);
		findViewById(R.id.pause).setOnClickListener(onClickListener);
		findViewById(R.id.stop).setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			int id = v.getId();
			switch (id) {
			case R.id.play:
				mMp.start();						
				break;
			case R.id.pause:
				mMp.pause();	
				break;
			case R.id.stop:
				mMp.stop();	
				break;
			}
		}
	};
}
