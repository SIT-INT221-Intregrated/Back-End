package int221.integrated.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productcolors")
public class Productcolors {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String productcolors_id;
	private String product_productCode;
	private String color_colorId;

	public Productcolors() {
	}

	public String getProduct_productcode() {
		return product_productCode;
	}

	public void setProduct_productcode(String product_productcode) {
		this.product_productCode = product_productcode;
	}

	public String getColor_colorid() {
		return color_colorId;
	}

	public void setColor_colorid(String color_colorid) {
		this.color_colorId = color_colorid;
	}
}
