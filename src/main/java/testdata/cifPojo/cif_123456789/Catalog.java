package testdata.cifPojo.cif_123456789;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;



@XmlRootElement(name = "catalog")
public class Catalog {
    private List<Data> data;

    @XmlElement(name = "data")
    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
