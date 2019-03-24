package com.wangzunbin.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * ClassName:LoginFilter  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/24 23:01   <br/>
 */

@Component
public class LoginFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 4;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
//        String requestURI = currentContext.getRequest().getRequestURI();
        HttpServletRequest request = currentContext.getRequest();
//        System.out.println(requestURI);
//        System.out.println(requestURL);
       /* if("/apigateway/order/api/v1/order/save".equalsIgnoreCase(requestURI)) {
            return true;
        }*/
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)) {
            token = request.getParameter("token"); 
        }
        if(StringUtils.isBlank(token)) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }

        return false;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("拦截了.....");
        return null;
    }
}
