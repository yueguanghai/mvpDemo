package com.gzn.mvpdemo.di.modules;

import com.gzn.mvpdemo.MainActivity;
import com.gzn.mvpdemo.presenter.GirlPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class GirlModule {


    private MainActivity mainActivity;

    public GirlModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    public GirlPresenter providePresenter(){
        return new GirlPresenter(mainActivity);
    }
}
