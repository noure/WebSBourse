
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCotationResponse", namespace = "http://banque/ws")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCotationResponse", namespace = "http://banque/ws")
public class GetCotationResponse {

    @XmlElement(name = "return", namespace = "")
    private model.Cotation _return;

    /**
     * 
     * @return
     *     returns Cotation
     */
    public model.Cotation getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(model.Cotation _return) {
        this._return = _return;
    }

}
