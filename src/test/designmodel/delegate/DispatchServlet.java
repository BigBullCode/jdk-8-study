package test.designmodel.delegate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
/**
 * 委派模式模拟Spring的dispatchServlet前端控制器
 *
 * @Author: Zhangdongdong
 * @Date: 2021/4/12 15:28
 */
public class DispatchServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<>();

    //利用策略模式进行优化
    public void init() throws ServletException {

        Class<?> memberControllerClass = MemberController.class;
        try {
            handlerMapping.add(new Handler().setControlle(memberControllerClass)
                    .setMethod(memberControllerClass.getDeclaredMethod("getMemberById", new Class[]{String.class}))
                    .setUrl("/web/getMemberById.json")
            );
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     *
     * @param request
     * @param response
     * @throws Exception
     */
    public void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //这种处理方式，如果业务繁多，不可能全部用这种委派模式无限扩展，下面利用策略模式，进行优化
       /*
       String uri = request.getRequestURI();
        String mid = request.getParameter("mid");

        if ("getMemberById".equals(uri)) {
            new MemberController().getMemberById(mid);
        }
        else if ("getOrderById".equals(uri)) {
            new OrderController().getOrderById(mid);
        }
        else if ("logout".equals(uri)) {
            new SystemController().logout();
        }
        else {
            response.getWriter().write("404 Not Found");
        }*/

        //策略模式优化
        String uri = request.getRequestURI();
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }
        //分发具体任务
        Object obj = null;
        obj = handler.getMethod().invoke(handler.getControlle(), request.getParameter("mid"));
    }

    protected void service(HttpServletRequest req, HttpServletResponse rep) {

        try {
            doDispatch(req, rep);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     配置web.xml
     <Se vlet>
<Se vlet-name>delegateSe vlet</servlet-name>
<ser vlet-class>com.gupaoedu.vip.patte n.delegate.mvc.Dispatche Se vlet</ser vlet-class>
<load-on-sta tup>l</load-on-sta tup>
</se vlet>
<servlet-mapping>
<servlet-name>delegateServlet</se vlet-name>
<u1-patte n>/*</url-patte「 n>
</se vlet-mapping>
     */
    class Handler {
        private Object controller;
        private Method method;
        private String url;
        public Object getControlle() {
            return controller;
        }
        public Handler setControlle(Object controller) {
            this.controller = controller;
            return this;
        }
        public Method getMethod() {
            return method;
        }
        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }
        public String getUrl() {
            return url;
        }
        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
