package com.traiming.mvs.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.traiming.mvs.constants.MoviePortletKeys;
import com.training.mms.model.Movie;
import com.training.mms.service.MovieLocalService;
import com.training.mms.service.MovieLocalServiceUtil;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author tufai
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.movie",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Movie",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MoviePortletKeys.MOVIE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MoviePortlet extends MVCPortlet {
	 String loggedInStatus;
	 Date loggedInDate;
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		 renderRequest.setAttribute("message", "Liferay is easy and fun");
		
		// loggedInStatus= (String) renderRequest.getAttribute("loggedDateTime");
		 if(loggedInStatus == null)
		 {
			 loggedInStatus="SomeValue";
			 System.out.println("@@@Setting the attribute for logged in "+loggedInStatus);
			 loggedInDate = new Date();
		 }
		 renderRequest.setAttribute("loggedDateTime", loggedInDate.toString());

		 
		 
		 
		 
		 
		 System.out.println("###DoView called");
		 //I can create URL in portlets as well
		 PortletURL portletURL = renderResponse.createActionURL();
		 portletURL.setParameter(ActionRequest.ACTION_NAME, "aboutLiferay");
		 renderResponse.getWriter().println("<a href="+portletURL +">About Liferay</a>");
		super.doView(renderRequest, renderResponse);
	}
	/*
	 * @Override public void processAction(ActionRequest actionRequest,
	 * ActionResponse actionResponse) throws IOException, PortletException {
	 * System.out.println("###process action called");
	 * //super.processAction(actionRequest, actionResponse); }
	 */
	
		@Reference
		private MovieLocalService movieLocalService;
	
	public void addMovie(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		//	actionRequest.getParameter("movieName"); It is deprecated
			String movieName = ParamUtil.getString(actionRequest, "movieName","MovieNameNotAvailable");
			String directorName = ParamUtil.getString(actionRequest, "directorName","directorNameNA");
			String yearReleased = ParamUtil.getString(actionRequest, "yearReleased","yearReleasedNA");
			String actorName = ParamUtil.getString(actionRequest, "actorName","actorNameNA");

			System.out.println("###Add Movie called "+movieName+ "  "+directorName+ "  "+yearReleased+ "  "+actorName);
			
		
				Movie movie = MovieLocalServiceUtil.createMovie(CounterLocalServiceUtil.increment());
				movie.setMovieName(movieName);
				movie.setDirectorName(directorName);
				movie.setYearReleased(yearReleased);
				movie.setActorName(actorName);
				
				MovieLocalServiceUtil.addMovie(movie);

				System.out.println("###Movie added successfully");
		//super.processAction(actionRequest, actionResponse);
	}
	
	public void deleteMovie(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
	 System.out.println("###Delete Movie called");
		//super.processAction(actionRequest, actionResponse);
	}
	public void updateMovie(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
	 System.out.println("###Update Movie called");
		//super.processAction(actionRequest, actionResponse);
	}
	public void aboutLiferay(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
	 System.out.println("###aboutLiferay called");
		//super.processAction(actionRequest, actionResponse);
	}
	
	
	@Override
		public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
				throws IOException, PortletException {
		 System.out.println("###serve resoource  called");
		}
}