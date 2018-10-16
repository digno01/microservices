package com.stefanini.zuulserver;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.core.Main;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter{
	 private static final Logger logger = LoggerFactory.getLogger(Main.class);
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
		logger.info("http-metod: " + request.getMethod() +
				" user-ip: " + request.getRemoteAddr() + 
				" body = " + extractRequestBody(request) + 
				" url = " + request.getRequestURL() + 
				" response-body = " + RequestContext.getCurrentContext().getResponseBody() + 
				" response-status" + response.getStatus()) ;
		return null;
	}

	private String extractRequestBody(HttpServletRequest request) {
		String value  = "";
		if(!HttpMethod.GET.name().equals(request.getMethod()) &&
				request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){
			try {
				value = IOUtils.toString(request.getInputStream(), "UTF-8");
				
			} catch (IOException e) {
				logger.error("erro parse boby request");
			}
		}else{
			value = "body to large";
		}
		return value;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "post";
	}

}
