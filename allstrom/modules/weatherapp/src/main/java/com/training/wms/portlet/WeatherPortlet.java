package com.training.wms.portlet;

import com.training.wms.constants.WeatherPortletKeys;

import java.io.IOException;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author tufai
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Weather",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + WeatherPortletKeys.WEATHER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-public-render-parameter=cityName",
		"com.liferay.portlet.private-session-attributes=false"

	},
	service = Portlet.class
)
public class WeatherPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String cityName = ParamUtil.getString(renderRequest, "cityName","CityNameNotAvailable");
		System.out.println("City name recvd is :"+cityName);
		super.doView(renderRequest, renderResponse);
	}
	
	
	public void setTemparature(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
			String temperature = ParamUtil.getString(actionRequest, "temperature");
			PortletSession portletSession =actionRequest.getPortletSession();
			portletSession.setAttribute("CURRENT_TEMPERATURE", temperature, PortletSession.APPLICATION_SCOPE);
			System.out.println("Set Temperature to PortletSession value of temperature set to :"+temperature);
	}
}