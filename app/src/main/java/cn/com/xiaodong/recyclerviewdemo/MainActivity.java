package cn.com.xiaodong.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

import cn.com.xiaodong.recyclerviewdemo.adpapter.SimpleAdapter;
import cn.com.xiaodong.recyclerviewdemo.adpapter.StaggerAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
        initData();

        mRecycleView.setAdapter(new SimpleAdapter(this, mList));
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
//        mRecycleView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initData() {

        mRecycleView = (RecyclerView) findViewById(R.id.recycleView);

    }

    private void initView() {

        for(int i = 'A'; i < 'a'; i++)
        {
            mList.add((char)i + "");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       switch (id)
       {
           case R.id.action_linearLayout:
               break;
           case R.id.action_GrideLayout:
               mRecycleView.setLayoutManager(new GridLayoutManager(this, 4));
               break;
           case R.id.action_StaggeredLayout:
//               Intent intent = new Intent(MainActivity.this, StaggerActivity.class);
//               startActivity(intent);
               mRecycleView.setAdapter(new StaggerAdapter(this, mList));
               mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
               break;
       }
        return super.onOptionsItemSelected(item);
    }
}
