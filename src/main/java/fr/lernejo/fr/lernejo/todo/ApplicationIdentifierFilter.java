package fr.lernejo.fr.lernejo.todo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

@Component
public class ApplicationIdentifierFilter implements javax.servlet.Filter{
    final String out;

    public ApplicationIdentifierFilter() {
        this.out = UUID.randomUUID().toString();
    }


    //comment
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
        throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            ((HttpServletResponse) response).addHeader("instance-id",out);
        }
        filterChain.doFilter(request,response);

    }
}
