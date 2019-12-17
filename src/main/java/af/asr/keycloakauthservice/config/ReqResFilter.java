package af.asr.keycloakauthservice.config;

import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class is for input logging of all parameters in HTTP requests
 */
public class ReqResFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// init method overriding
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		ContentCachingRequestWrapper requestWrapper = null;
		ContentCachingResponseWrapper responseWrapper = null;

		// Default processing for url ends with .stream
		if (httpServletRequest.getRequestURI().endsWith(".stream")) {
			chain.doFilter(request, response);
			return;
		}
		requestWrapper = new ContentCachingRequestWrapper(httpServletRequest);
		responseWrapper = new ContentCachingResponseWrapper(httpServletResponse);
		chain.doFilter(requestWrapper, responseWrapper);
		responseWrapper.copyBodyToResponse();

	}

	@Override
	public void destroy() {
		// Auto-generated method stub
	}
}
