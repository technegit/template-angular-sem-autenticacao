package agenda.rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;


/**
 * Realiza disponibiliza os pacotes rest.
 * @generated
 */

@ApplicationPath("/api/rest/agenda")
public class RESTApplication extends ResourceConfig {

    /**
     * @generated
     */
	public RESTApplication() {
		packages("agenda.rest");
	}

}