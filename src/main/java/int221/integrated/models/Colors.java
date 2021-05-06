package int221.integrated.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "colors")
public class Colors {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "colorid")
	private String colorid;

	@Column(name = "colorname")
	private String colorname;

	@Column(name = "hexcode")
	private String hexcode;

	@OneToMany(mappedBy = "colors", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Productcolors> productcolors;

	public Colors() {
	}

	public Colors(String colorId, String colorName, String hexCode) {
		this.colorid = colorId;
		this.colorname = colorName;
		this.hexcode = hexCode;
	}

	public String getColorid() {
		return colorid;
	}

	public void setColorid(String colorid) {
		this.colorid = colorid;
	}

	public String getColorname() {
		return colorname;
	}

	public void setColorname(String colorname) {
		this.colorname = colorname;
	}

	public String getHexcode() {
		return hexcode;
	}

	public void setHexcode(String hexcode) {
		this.hexcode = hexcode;
	}
}