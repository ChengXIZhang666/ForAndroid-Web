package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CharSetFilter", urlPatterns = {"/*"})
public class CharSetFilter implements Filter {
    private String characterEncoding;
    private String contentType;

    public void init(FilterConfig config) {
        characterEncoding = "utf-8";
        contentType = "text/html;charset=utf-8";
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(characterEncoding);
        resp.setCharacterEncoding(characterEncoding);
        resp.setContentType(contentType);
        chain.doFilter(req, resp);
    }

    public void destroy() {
    }
}
