package com.istinye.week8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.istinye.week8.databinding.ActivityMainBinding;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private final String LISTVIEW_TAG = "LISTVIEW_TAG";
    private ActivityMainBinding binding;

    private String[] classRoom = {"Ceyhun Emir Aygan", "Doğukan İnce", "Pelin Gürkut", "Umut Ergün", "Yusuf Aktan", "Burkan Yılmaz",
            "Week8", "Learning ListView", "İstinye Üniversitesi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.getLogger(TAG).log(Level.INFO,"onCreate invoked");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View rootView = binding.getRoot();
        setContentView(rootView);

        binding.myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, android.view.View view, int position, long l) {
                Toast.makeText(getApplicationContext(), classRoom[position], Toast.LENGTH_SHORT).show();
            }
        });

        binding.myListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return classRoom.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                ViewHolder viewHolder = null;
                if (convertView == null) {
                    convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.single_item_layout, parent, false);
                    viewHolder = new ViewHolder(convertView);
                    convertView.setTag(viewHolder);
                    Logger.getLogger(LISTVIEW_TAG).log(Level.INFO,"ConvertView is null for: " + position);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                    Logger.getLogger(LISTVIEW_TAG).log(Level.INFO,"ConvertView is not null and reusing for: " + position);
                }
                viewHolder.labelTextView.setText(classRoom[position]);
                viewHolder.dateView.setText(new Date().toString());
                if (position % 2 == 0) {
                    convertView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                } else {
                    convertView.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                }
                return convertView;
            }
        });

    }

    private class ViewHolder {

        public TextView labelTextView;
        public TextView dateView;

        public ViewHolder(View view){
            labelTextView = view.findViewById(R.id.single_item_textView);
            dateView = view.findViewById(R.id.single_item_dateView);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.getLogger(TAG).log(Level.INFO,"onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.getLogger(TAG).log(Level.INFO,"onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.getLogger(TAG).log(Level.INFO,"onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.getLogger(TAG).log(Level.INFO,"onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.getLogger(TAG).log(Level.INFO,"onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.getLogger(TAG).log(Level.INFO,"onDestroy invoked");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.getLogger(TAG).log(Level.INFO,"onSaveInstanceState invoked");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Logger.getLogger(TAG).log(Level.INFO,"onRestoreInstanceState invoked");
    }
}