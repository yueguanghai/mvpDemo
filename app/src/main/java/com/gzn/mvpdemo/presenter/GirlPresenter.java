package com.gzn.mvpdemo.presenter;

import com.gzn.mvp_core.net.rx.databus.RegisterRxBus;
import com.gzn.mvpdemo.bean.Girl;
import com.gzn.mvpdemo.model.IGirlModel;
import com.gzn.mvpdemo.model.IGirlModelImpl;
import com.gzn.mvpdemo.view.IGirlView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class GirlPresenter<T extends IGirlView> {
    WeakReference<T> mView;

    IGirlModel iGirlModel=new IGirlModelImpl();
    public GirlPresenter(T view){
        this.mView = new WeakReference<>(view);

    }

    public void loadGirls(){
        iGirlModel.loadGirl();
    }
    @RegisterRxBus
    public void showGirls(ArrayList<Girl> list){
        mView.get().showGirls(list);
    }
}
