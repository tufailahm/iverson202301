package com.training.cms.filter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.training.cms.constants.CityPortletKeys;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;
import javax.portlet.filter.ResourceFilter;

import org.osgi.service.component.annotations.Component;



@Component(immediate = true, 
	property = {
			"javax.portlet.name=" + CityPortletKeys.CITY,
		},
	service = PortletFilter.class
)

public class MyResourceFilter implements ResourceFilter{

	private static Log _log = LogFactoryUtil.getLog(MyResourceFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws PortletException {
		_log.info("init.....");
	}

	@Override
	public void destroy() {
		_log.info("destroy.....");
	}

	@Override
	public void doFilter(ResourceRequest request, ResourceResponse response, FilterChain chain) throws IOException, PortletException {
		_log.info("ResourceDoFilter.....");
		chain.doFilter(request, response);
	}
}