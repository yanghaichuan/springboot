package com.yhc.learn.springboot.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthInterceptor implements WebMvcConfigurer {

    @Bean
    public InterfaceAuthCheckInterceptor getInterfaceAuthCheckInterceptor() {
        return new InterfaceAuthCheckInterceptor();
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 多个拦截器组成一个拦截器链
//        // addPathPatterns 用于添加拦截规则
//        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(getInterfaceAuthCheckInterceptor()).addPathPatterns("/goods/**");
//        // registry.addInterceptor(new InterfaceAuthCheckInterceptor()).addPathPatterns("/api/**");
//        // 如果interceptor中不注入redis或其他项目可以直接new，否则请使用上面这种方式
//        super.addInterceptors(registry);
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterfaceAuthCheckInterceptor()).addPathPatterns("/goods/action/**");
    }

    /**
     * 微服务间接口访问密钥验证
     *
     */
    class InterfaceAuthCheckInterceptor implements HandlerInterceptor {

        private Logger logger = LoggerFactory.getLogger(getClass());

        @Resource
        StringRedisTemplate stringRedisTemplate;

        @Override
        public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
                throws Exception {

        }

        @Override
        public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
                throws Exception {

        }

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj)
                throws Exception {
            String key = request.getParameter("token");
            if (StringUtils.isEmpty(key)) {
                JSONObject json = new JSONObject();
                json.put("code",10001);
                json.put("msg","token不能为空");
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(json.toJSONString());
                return false;
            } else {
                logger.info("test redis import :" + stringRedisTemplate.opsForValue().get(key));
                // TODO 验证逻辑
                return true;
            }
        }

    }
}