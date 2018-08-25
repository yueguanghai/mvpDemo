package com.gzn.mvpdemo.di.component;

import com.gzn.mvpdemo.MainActivity;
import com.gzn.mvpdemo.di.modules.GirlModule;

import dagger.Component;

@Component(modules = GirlModule.class)
public interface GirlComponent {

    void inject(MainActivity mainActivity);
}
