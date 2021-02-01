package com.malax;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.security.Security;

public class DnsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String domain = req.getParameter("domain");
        InetAddress address = InetAddress.getByName(domain);

        resp.getWriter().println("networkaddress.cache.negative.ttl = " + Security.getProperty("networkaddress.cache.negative.ttl"));
        resp.getWriter().println("networkaddress.cache.ttl = " + Security.getProperty("networkaddress.cache.ttl"));
        resp.getWriter().println("lookup(" + domain +") = " + address.getHostAddress());
        resp.setStatus(200);
    }
}
