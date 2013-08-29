package com.example.android_listview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("ServiceCast")
public class MainActivity extends Activity {
	ListView listView;
	TextView showinfo;
	String[] titles = { "jack", "john", "lily" };
	String[] texts = { "123456789", "321456987", "456789123" };
	int buf = R.drawable.ic_launcher;
	int[] resIds = { buf, buf, buf };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) this.findViewById(R.id.list);
		showinfo = (TextView) this.findViewById(R.id.T1);
		listView.setAdapter(new MyAdapter(titles, texts, resIds));
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				TextView title = (TextView) arg1.findViewById(R.id.itemTitle);
				String info = "单击的联系人是：" + title.getText();

				TextView text = (TextView) arg1.findViewById(R.id.itemText);
				info = info + "\n 联系电话:" + text.getText();

				showinfo.setText(info);

			}
		});

	}

	public class MyAdapter extends BaseAdapter {
		String[] itemTitle, itemTexts;
		int[] itemImageRes;

		public MyAdapter(String[] itemTitles, String[] itemTexts,
				int[] itemImageRes) {
			this.itemImageRes = itemImageRes;
			this.itemTitle = itemTitles;
			this.itemTexts = itemTexts;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return itemTitle.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return itemTitle[arg0];
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			if (arg1 == null) {
				LayoutInflater inflater = (LayoutInflater) MainActivity.this
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View itemView = inflater.inflate(R.layout.item, null);

				TextView title = (TextView) itemView
						.findViewById(R.id.itemTitle);
				title.setText(itemTitle[arg0]);

				TextView text = (TextView) itemView.findViewById(R.id.itemText);
				text.setText(itemTexts[arg0]);

				ImageView image = (ImageView) itemView
						.findViewById(R.id.itemImage);
				image.setImageResource(itemImageRes[arg0]);

				return itemView;

			} else {
				TextView title = (TextView) arg1.findViewById(R.id.itemTitle);
				title.setText(itemTitle[arg0]);

				TextView text = (TextView) arg1.findViewById(R.id.itemText);
				text.setText(itemTexts[arg0]);

				ImageView image = (ImageView) arg1.findViewById(R.id.itemImage);
				image.setImageResource(itemImageRes[arg0]);

				return arg1;
			}

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
