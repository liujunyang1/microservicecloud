package com.ly.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {

    //请求的类型：pre表示请求服务之前先执行过滤器
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器的顺序，当有多个过滤器时，按照order顺序执行
    @Override
    public int filterOrder() {
        return 1;
    }

    //这个方法判断一个请求是否直接放行，false时：请求直接放行，
    // 当为true时：请求不能放行，需要执行run方法进行再一次的交验。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if (token == null || token.trim().equals("")){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }else if(!token.equals("123456")){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.NOT_FOUND.value());
        }
        return null;
    }
}
