import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "d2LogicalModel", namespace = "http://datex2.eu/schema/2/2_0")
@XmlType(propOrder = { "exchange", "payloadPublication" })
public class D2LogicalModel {

    private Exchange exchange;
    private PayloadPublication payloadPublication;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public PayloadPublication getPayloadPublication() {
        return payloadPublication;
    }

    public void setPayloadPublication(PayloadPublication payloadPublication) {
        this.payloadPublication = payloadPublication;
    }

    @Override    
    public String toString() {    
        // TODO Auto-generated method stub    
        return "\"d2LogicalModel [exchange "+ exchange + ", payloadPublication = " + payloadPublication + "]";    
    }  
}