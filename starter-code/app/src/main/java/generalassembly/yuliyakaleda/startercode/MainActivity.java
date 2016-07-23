package generalassembly.yuliyakaleda.startercode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText wish_edittext;
    Button  wish_button;
    TextView wish_textview;
    ListView wish_listview;
    ArrayList<String> wishArrayList;
    BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          //TODO: set up all the view and event listeners.

          wish_edittext = (EditText) findViewById(R.id.wish_edittext);
          wish_button = (Button) findViewById(R.id.wish_button);
          wish_textview = (TextView) findViewById(R.id.wish_textview);
          wish_listview = (ListView) findViewById(R.id.wish_listview);
          wishArrayList = new ArrayList<>();


          wish_button.setOnClickListener(this);

          adapter = new BaseAdapter() {
              @Override
              public int getCount() {
                  return wishArrayList.size();
              }

              @Override
              public Object getItem(int position) {
                  return wishArrayList.get(position);
              }

              @Override
              public long getItemId(int position) {
                  return position;
              }

              @Override
              public View getView(int position, View convertView, ViewGroup parent) {
                  View view = convertView;
                  if(view == null) {
                      view = getLayoutInflater().inflate(
                              android.R.layout.simple_list_item_1,parent, false);
                  }
                  TextView wish_textview = (TextView) view.findViewById(android.R.id.text1);
                  wish_textview.setText(wishArrayList.get(position));
                  return view;
              }
          };

        wish_listview.setAdapter(adapter);

        }

    @Override
    public void onClick(View v) {
        String wish = wish_edittext.getText().toString().trim();
        wishArrayList.add(0, wish);
        wish_textview.setText(wish);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        wish_textview.startAnimation(animation);
        adapter.notifyDataSetChanged();
        wish_edittext.setText("");

      // TODO: 1. get the text from the input field
      //       2. animate it in the center of the screen
      //       3. add it to the list wish
      //       4. clear the input field


    }
}
