package com.gzn.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.gzn.mvp_core.net.rx.databus.RxBus;
import com.gzn.mvpdemo.adapter.GirlAdapter;
import com.gzn.mvpdemo.bean.Girl;
import com.gzn.mvpdemo.di.component.DaggerGirlComponent;
import com.gzn.mvpdemo.di.modules.GirlModule;
import com.gzn.mvpdemo.presenter.GirlPresenter;
import com.gzn.mvpdemo.view.IGirlView;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IGirlView{

    private ListView listView;

    @Inject
    GirlPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        DaggerGirlComponent.builder()
                .girlModule(new GirlModule(this)).build()
                .inject(this);
        RxBus.getInstance().register(presenter);
        presenter.loadGirls();
    }

    @Override
    public void showGirls(List<Girl> girls) {
        listView.setAdapter(new GirlAdapter(this,girls));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unRegister(presenter);
    }
}
