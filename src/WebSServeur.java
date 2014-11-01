import javax.xml.ws.Endpoint;

import webservice.WebSBourse;

public class WebSServeur {

	public static void main(String[] args) {

		/**
		 * création d'un serveur pour déploie notre web service
		 */
		String uri = "http://localhost:8888/";
		Endpoint.publish(uri, new WebSBourse());
		System.out.println("Web Service publié à " + uri);
	}

}