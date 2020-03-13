package com.ceshi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.ceshi.bean.TopicListBean;
import com.ceshi.view.View;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new zhauntiFragment());
        fragmentList.add(new MineFragment());

        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragmentList);
        vp.setAdapter(vpAdapter);

        tab.setupWithViewPager(vp);

        tab.getTabAt(0).setText("专题");
        tab.getTabAt(1).setText("我的");


    }
}
