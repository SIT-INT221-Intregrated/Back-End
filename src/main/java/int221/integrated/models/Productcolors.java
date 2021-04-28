package int221.integrated.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "ProductColors")
public class Productcolors {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String Product_ProductCode;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String Color_ColorId;

	public Productcolors() {
	}

	public Productcolors(String product_ProductCode, String color_ColorId) {
		Product_ProductCode = product_ProductCode;
		Color_ColorId = color_ColorId;
	}

	public String getProduct_productcode() {
		return Product_ProductCode;
	}

	public void setProduct_productcode(String product_productcode) {
		this.Product_ProductCode = product_productcode;
	}

	public String getColor_colorid() {
		return Color_ColorId;
	}

	public void setColor_colorid(String color_colorid) {
		this.Color_ColorId = color_colorid;
	}
}
