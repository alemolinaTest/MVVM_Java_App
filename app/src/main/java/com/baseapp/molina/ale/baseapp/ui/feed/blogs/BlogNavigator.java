package com.baseapp.molina.ale.baseapp.ui.feed.blogs;

import com.baseapp.molina.ale.baseapp.data.model.api.BlogResponse;

import java.util.List;


/**
 * Created by Amolina on 10/10/17.
 */


public interface BlogNavigator {

    void updateBlog(List<BlogResponse.Blog> blogList);

    void handleError(Throwable throwable);

}
