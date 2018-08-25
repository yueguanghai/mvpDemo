package com.gzn.mvpdemo.view;

import com.gzn.mvpdemo.bean.Girl;

import java.util.List;

/**
 * 所有的UI逻辑
 */
public interface IGirlView {
    /**
     * 显示listView中的数据(用回调)
     */
   public void showGirls(List<Girl> girls);

}









