package com.airy.saltedfish.interceptor;

import com.airy.saltedfish.utils.TokenUtil;
import com.auth0.jwt.interfaces.Claim;
import com.google.gson.JsonObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Airy on 2018/8/7
 */

public class TokenVerifyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletResponse.setContentType("application/json:charset=UTF-8");
        String token = httpServletRequest.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        boolean valid = false;
        if (claims != null) {
            if (TokenUtil.isCloseToExpire(claims)) {
                String newToken = TokenUtil.createToken(claims.get("uid").asInt());
                httpServletResponse.addHeader("access_token", newToken);
            } else {
                httpServletRequest.setAttribute("uid", claims.get("uid").asInt());
                valid = true;
            }
        } else {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("code", "40008");
            jsonObject.addProperty("msg", "无效的token");
            PrintWriter out = httpServletResponse.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
        }
        return valid;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
