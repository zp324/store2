package cn.store.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletTest extends HttpServlet {

    /**
     * The doGet method of the servlet. <br>
     * 
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 在Tomcat中配置URIEncoding解决GET方式的中文乱码，代码中不再做处理
        String uName = request.getParameter("username");
        if (uName == null) {
            uName = "游客";
        }
        // 设置响应内容的类型并指定字符集，以免浏览器展示中文内容时出现乱码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("  <head><title>Servlet</title></head>");
        out.println("  <body>");
        out.println("你好,欢迎" + uName + "来到Servlet世界");
        out.println("  </body>");
        out.println("</html>");
        out.flush();
        out.close();

    }

    /**
     * The doPost method of the servlet. <br>
     * 
     * This method is called when a form has its tag value method equals to
     * post.
     * 
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 对POST方式提交的数据统一设置字符集，解决中文乱码问题
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
    
}
