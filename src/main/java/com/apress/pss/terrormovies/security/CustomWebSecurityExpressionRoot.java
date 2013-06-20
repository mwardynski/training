package com.apress.pss.terrormovies.security;

import com.apress.pss.terrormovies.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

public class CustomWebSecurityExpressionRoot extends WebSecurityExpressionRoot {

    public CustomWebSecurityExpressionRoot(Authentication a, FilterInvocation fi) {
        super(a, fi);
    }

    public boolean isOver18(){
        User user = (User)this.getPrincipal();
        return user.getAge() > 18;
    }

}
