package com.study.springboot.componet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * @author Alfie
 * @date 2019/8/12 16:41
 */
public class CostomLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)) {
            String[] s = l.split("_");
            locale = new Locale(s[0],s[1]);
        } else {
            //没有参数获取系统的locale
            Locale requestLocale = request.getLocale();
            if(requestLocale != null){
                locale = requestLocale;
            }

        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }


}
