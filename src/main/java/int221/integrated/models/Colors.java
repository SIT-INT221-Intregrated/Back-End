package int221.integrated.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "colors")
public class Colors {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String colorId;
	private String colorName;
	private String HexCode;

	public Colors() {
	}

	public Colors(String colorId, String colorName, String hexCode) {
		this.colorId = colorId;
		this.colorName = colorName;
		HexCode = hexCode;
	}

	public String getColorid() {
		return colorId;
	}

	public void setColorid(String colorid) {
		this.colorId = colorid;
	}

	public String getColorname() {
		return colorName;
	}

	public void setColorname(String colorname) {
		this.colorName = colorname;
	}

	public String getHexcode() {
		return HexCode;
	}

	public void setHexcode(String hexcode) {
		this.HexCode = hexcode;
	}
	
}





