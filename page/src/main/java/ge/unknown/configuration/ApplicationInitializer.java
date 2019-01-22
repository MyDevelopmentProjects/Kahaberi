package ge.unknown.configuration;

/**
 * Created by user on 7/24/17.
 */
/*public class ApplicationInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.setServletContext(servletContext);
        ServletRegistration.Dynamic dispatcher  = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
         ctx.register(ApplicationInitializer.class);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        // UTF8 Character Filter.
        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);

        fr.setInitParameter("encoding", "UTF-8");
        fr.setInitParameter("forceEncoding", "true");
        fr.addMappingForUrlPatterns(null, true, "/*");
    }
}*/
