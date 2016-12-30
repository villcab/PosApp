package bo.com.ahosoft.entitys.inventory;

import bo.com.ahosoft.utils.reflextion.Entity;
import bo.com.ahosoft.utils.reflextion.annotations.Key;
import bo.com.ahosoft.utils.reflextion.annotations.TableName;

@TableName(name = "product")
public class Product extends Entity {

    @Key
    private Long id;
    private Long id_product;
    private String name;
    private String generic_name;
    private String description;
    private String url_logo;
    private Boolean removed;
    private String code;

    public Product() {
        removed = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneric_name() {
        return generic_name;
    }

    public void setGeneric_name(String generic_name) {
        this.generic_name = generic_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public void setUrl_logo(String url_logo) {
        this.url_logo = url_logo;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", id_product=" + id_product +
                ", name='" + name + '\'' +
                ", generic_name='" + generic_name + '\'' +
                ", description='" + description + '\'' +
                ", url_logo='" + url_logo + '\'' +
                ", removed=" + removed +
                ", code='" + code + '\'' +
                '}';
    }

}