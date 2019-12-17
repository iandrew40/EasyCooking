package iandrew40.easycooking.web.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class FaviconInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView){

        String faviconURL = "https://github.com/iandrew40/EasyCooking/blob/master/src/main/resources/static/image/logo-green.png?raw=true";


        if (modelAndView != null){
            modelAndView.addObject("favicon", faviconURL);
        }
    }
}
