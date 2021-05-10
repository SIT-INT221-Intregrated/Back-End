package int221.integrated.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "productcolors")
public class Productcolors {
    @Id
    @Column(name = "productcolors_id")
    private String productcolorsid;

    @Column(name = "product_productcode")
    private String productcode;

    @Column(name = "color_colorid")
    private String colorid;

    @ManyToOne
    @JoinColumn(name = "color_colorid", insertable = false, updatable = false)
    Colors colors;

	@ManyToOne
    @JoinColumn(name = "product_productcode", insertable = false, updatable = false)
    Products products;

    public Productcolors() {
    }

	public String getProductcolorsid() {
		return productcolorsid;
	}

	public void setProductcolorsid(String productcolorsid) {
		this.productcolorsid = productcolorsid;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getColorid() {
		return colorid;
	}

	public void setColorid(String colorid) {
		this.colorid = colorid;
	}
    
	public void setColors(Colors colors) {   
		this.colors = colors;
	}
    
	public String getHexcode() {
        return colors.getHexcode();
    }
}