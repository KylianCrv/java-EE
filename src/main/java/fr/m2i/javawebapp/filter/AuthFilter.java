package fr.m2i.javawebapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

    private ServletContext context;

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.context = filterConfig.getServletContext();
        this.context.log("Auth filter init");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        //on cast en httpservletrequest pour ensuite récuperer la session
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        boolean isLoggedIn = session != null && session.getAttribute("user") != null;

        if (!isLoggedIn) {

            this.context.log("User not connected");

            request.getRequestDispatcher("/WEB-INF/notWelcome.jsp").forward(request, response);

            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
