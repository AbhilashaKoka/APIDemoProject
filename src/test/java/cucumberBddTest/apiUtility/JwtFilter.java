package cucumberBddTest.apiUtility;
import io.jsonwebtoken.Claims;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Integrate authorization checks into your middleware
// to enforce rules before granting access to resources
public class JwtFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer")) {
            String token = authHeader.substring(7);
            Claims claims = JwtUtils.validateToken(token);
            if ("admin".equals(claims.get("role"))) {
                chain.doFilter(req, res);  // Proceed if role is admin
                return;
            }
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}