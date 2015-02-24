package thahn.java.agui.test.view;

import thahn.java.agui.app.Bundle;
import thahn.java.agui.app.ListActivity;
import thahn.java.agui.app.Menu;
import thahn.java.agui.utils.Log;
import thahn.java.agui.view.ActionMode;
import thahn.java.agui.view.MenuItem;
import thahn.java.agui.widget.ArrayAdapter;
import thahn.java.agui.widget.ListView;

/**
 * This demo illustrates the use of CHOICE_MODE_MULTIPLE_MODAL, a.k.a. selection mode on ListView
 * couple with the new simple_list_item_activated_1 which uses a highlighted border for selected
 * items.
 */
public class ListViewMultipleActivatedTestActivity extends ListActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView lv = getListView();
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        lv.setMultiChoiceModeListener(new ModeCallback());
        setListAdapter(new ArrayAdapter<String>(this,
                thahn.java.agui.R.layout.simple_list_item_activated_1, Cheeses.sCheeseStrings));
    }
    
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        getActionBar().setSubtitle("Long press to start selection");
//    }
    
    private class ModeCallback implements ListView.MultiChoiceModeListener {

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//            MenuInflater inflater = getMenuInflater();
//            inflater.inflate(R.menu.list_select_menu, menu);
//            mode.setTitle("Select Items");
            return true;
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return true;
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//            switch (item.getItemId()) {
//            case R.id.share:
//                Toast.makeText(SelectionModeListViewTestActivity.this, "Shared " + getListView().getCheckedItemCount() +
//                        " items", Toast.LENGTH_SHORT).show();
//                mode.finish();
//                break;
//            default:
//                Toast.makeText(SelectionModeListViewTestActivity.this, "Clicked " + item.getTitle(),
//                        Toast.LENGTH_SHORT).show();
//                break;
//            }
            return true;
        }

        public void onDestroyActionMode(ActionMode mode) {
        }

        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
            final int checkedCount = getListView().getCheckedItemCount();
            switch (checkedCount) {
                case 0:
//                    mode.setSubtitle(null);
                    break;
                case 1:
//                    mode.setSubtitle("One item selected");
                    Log.i("One item selected");
                    break;
                default:
//                    mode.setSubtitle("" + checkedCount + " items selected");
                    Log.i("" + checkedCount + " items selected");
                    break;
            }
        }
        
    }
}
