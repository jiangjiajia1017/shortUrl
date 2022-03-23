package com.jiang.interceptor;

import com.jiang.config.IpConfig;
import com.jiang.controller.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IpInterceptor implements HandlerInterceptor {

    @Autowired
    private IpConfig ipConfig;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if ("POST".equals(request.getMethod())) {
            //未开启 ip白名单
            if (!ipConfig.isOpen()) {
                return true;
            } else {
                String clientIp = Utils.getIp(request);
                boolean ret = ipConfig.getIps().contains(clientIp);
                if (!ret) {
                    System.out.println(clientIp + "不允许访问，请配置正确的ip白名单");
                }
                return ret;
            }
        } else {
            return true;
        }
    }

}
