import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "exchange", namespace = "http://datex2.eu/schema/2/2_0")
@XmlType(propOrder = { "supplierIdentification", "exchangeVersion" })
public class Exchange {

    private String supplierIdentification;
    private String exchangeVersion;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getSupplierIdentification() {
        return supplierIdentification;
    }

    public void setSupplierIdentification(String supplierIdentification) {
        this.supplierIdentification = supplierIdentification;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getExchangeVersion() {
        return exchangeVersion;
    }

    public void setExchangeVersion(String exchangeVersion) {
        this.exchangeVersion = exchangeVersion;
    }
}