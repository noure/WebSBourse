package webservice;

import java.sql.Date;
import java.util.Vector;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import model.Cotation;
import model.BourseManager;
@WebService(targetNamespace="http://banque/ws",
		serviceName="Bourse")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
		use=SOAPBinding.Use.LITERAL)


public class WebSBourse {
	@WebMethod(operationName="getCotations")
	public Vector getCotations(String d1,String d2,String code){
		BourseManager bm=new BourseManager();
		return bm.getCotations(Date.valueOf(d1),Date.valueOf(d2),code);
	}
	
	@WebMethod(operationName="getAll")
	public Vector getAll(){
		BourseManager bm=new BourseManager();
		return bm.getAllCotations();
	}
	@WebMethod(operationName="ajoutCotation")
	public void ajoutCotation(String code,double val){
		BourseManager bm=new BourseManager();
		bm.addCotation(code,val);
	}
	@WebMethod(operationName="getCotation")
	public Cotation getCotation(int num){
		BourseManager bm=new BourseManager();
		Cotation c=bm.getCotation(num);
		return c;
	}
}
