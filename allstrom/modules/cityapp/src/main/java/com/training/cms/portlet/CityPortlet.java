package com.training.cms.portlet;

import com.training.cms.constants.CityPortletKeys;

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
		"javax.portlet.display-name=City",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CityPortletKeys.CITY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-public-render-parameter=cityName",
		"com.liferay.portlet.private-session-attributes=false"

	},
	service = Portlet.class
)
public class CityPortlet extends MVCPortlet {
	
	@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			System.out.println("###DoView of CityPortlet called");
			super.doView(renderRequest, renderResponse);
		}
	
	public void recieveTemperature(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
	
		PortletSession portletSession =actionRequest.getPortletSession();
		String temperature = (String) portletSession.getAttribute("CURRENT_TEMPERATURE", PortletSession.APPLICATION_SCOPE);
		
		System.out.println("Getting Temperature from PortletSession value of temperature is :"+temperature);
		portletSession.setAttribute("temp", temperature);
	}


	public void send(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
			String cityName = ParamUtil.getString(actionRequest, "cityName");
			actionResponse.getRenderParameters().setValue("cityName", cityName);
			System.out.println("Done PRP value of cityName set to :"+cityName);
	}
}