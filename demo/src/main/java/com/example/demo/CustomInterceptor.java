import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在请求处理之前进行拦截，可以进行身份验证、权限检查等操作
        System.out.println("Pre-handle method is called");

        // 返回 true 表示继续执行请求处理，返回 false 表示中断请求处理
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在请求处理之后但在视图渲染之前进行拦截，可以修改模型数据或视图
        System.out.println("Post-handle method is called");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在请求处理完毕后进行拦截，无论是否发生异常都会被调用，一般用于资源清理操作
        System.out.println("After-completion method is called");
    }
}
