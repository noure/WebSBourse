
package webservice.jaxws;

import java.util.Vector;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAllResponse", namespace = "http://banque/ws")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllResponse", namespace = "http://banque/ws")
public class GetAllResponse {

    @XmlElement(name = "return", namespace = "")
    private Vector _return;

    /**
     * 
     * @return
     *     returns Vector
     */
    public Vector getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Vector _return) {
        this._return = _return;
    }

}
