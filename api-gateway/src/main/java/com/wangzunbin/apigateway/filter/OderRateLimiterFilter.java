package com.wangzunbin.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * ClassName:OderRateLimiterFilter  <br/>
 * Funtion: 使用谷歌guava框架限流(学习) <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/25 10:24   <br/>
 */

@Component
public class OderRateLimiterFilter extends ZuulFilter {

    private static final RateLimiter rateLimiter = RateLimiter.create(1000);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -4;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        String requestURI = currentContext.getRequest().getRequestURI();
          if("/apigateway/order/api/v1/order/save".equalsIgnoreCase(requestURI)) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext currentContext = RequestContext.getCurrentContext();
        if(!rateLimiter.tryAcquire()) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        }

        return null;
    }
}
