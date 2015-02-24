package thahn.java.agui.test.view;

import thahn.java.agui.app.Activity;
import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.Context;
import thahn.java.agui.test.R;
import thahn.java.agui.test.R.drawable;
import thahn.java.agui.test.R.id;
import thahn.java.agui.test.R.layout;
import thahn.java.agui.view.View;
import thahn.java.agui.view.ViewGroup;
import thahn.java.agui.widget.BaseAdapter;
import thahn.java.agui.widget.GridView;
import thahn.java.agui.widget.TextView;

public class GridViewTestActivity extends Activity {
    
    @Override
	protected void onCreate(Bundle bundle) {//Bundle savedInstanceState) {
        super.onCreate(bundle);//savedInstanceState);

        setContentView(R.layout.gridview);

        GridView g = (GridView) findViewById(R.id.gridview);
        g.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter {
        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return 41;//mThumbIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
//            ImageView view;
            TextView view;
            if (convertView == null) {
//                view = new ImageView(mContext);
             	view = new TextView(mContext);
             	view.setLayoutParams(new GridView.LayoutParams(45, 45));
//                view.setAdjustViewBounds(false);
//                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                view.setPadding(8, 8, 8, 8);
            } else {
//            	view = (ImageView) convertView;
            	view = (TextView) convertView;
            }

//            view.setImageResource(mThumbIds[position]);
            view.setText(""+position);

            return view;
        }

        private Context mContext;

        private Integer[] mThumbIds = {
                R.drawable.progressbar0, 
                R.drawable.progressbar1,
                R.drawable.progressbar2, 
                R.drawable.progressbar3,
                R.drawable.progressbar4, 
                R.drawable.progressbar5,
                R.drawable.progressbar6, 
                R.drawable.progressbar0,
                R.drawable.progressbar0, 
                R.drawable.progressbar1,
                R.drawable.progressbar2, 
                R.drawable.progressbar3,
                R.drawable.progressbar4, R.drawable.progressbar5,
                R.drawable.progressbar6, R.drawable.progressbar0,
                R.drawable.progressbar0, R.drawable.progressbar1,
                R.drawable.progressbar2, R.drawable.progressbar3,
                R.drawable.progressbar4, R.drawable.progressbar5,
                R.drawable.progressbar6, R.drawable.progressbar0,
                R.drawable.progressbar0, R.drawable.progressbar1,
//                R.drawable.progressbar2, R.drawable.progressbar3,
//                R.drawable.progressbar4, R.drawable.progressbar5,
//                R.drawable.progressbar6, R.drawable.progressbar0,
//                R.drawable.progressbar0, R.drawable.progressbar1,
//                R.drawable.progressbar2, R.drawable.progressbar3,
//                R.drawable.progressbar4, R.drawable.progressbar5,
//                R.drawable.progressbar6, R.drawable.progressbar0,
//                R.drawable.progressbar0, R.drawable.progressbar1,
//                R.drawable.progressbar2, R.drawable.progressbar3,
//                R.drawable.progressbar4, R.drawable.progressbar5,
//                R.drawable.progressbar6, R.drawable.progressbar0,
//                R.drawable.progressbar0, R.drawable.progressbar1,
//                R.drawable.progressbar2, R.drawable.progressbar3,
//                R.drawable.progressbar4, R.drawable.progressbar5
        };
    }
}
