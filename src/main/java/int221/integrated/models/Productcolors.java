package int221.integrated.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productcolors")
public class Productcolors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productcolors_id")
	private String productcolors_id;

	@Column(name = "product_productcode")
	private String product_productcode;

	@Column(name = "color_colorid")
	private String color_colorid;

	@ManyToOne
	@JoinColumn(name = "color_colorid", insertable = false, updatable = false)
	Colors colors;

	@ManyToOne
	@JoinColumn(name = "product_productcode", insertable = false, updatable = false)
	Products products;

	public String getHexcode() {
		return colors.getHexcode();
	}

	public String getColorname() {
		return colors.getColorname();
	}

	public Productcolors() {
	}

	public String getColorid() {
		return colors.getColorid();
	}
}