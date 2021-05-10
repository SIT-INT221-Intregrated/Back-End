package int221.integrated.models;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class Brands {

	@Id
	@Column(name = "brandid")
	private String brandid;

	@Column(name = "brandname")
	private String brandname;

	@OneToMany(mappedBy = "brands_brandid", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Products> products;

	public String getBrandid() {
		return brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
}