package bo.com.ahosoft.entitys;

import bo.com.ahosoft.utils.reflextion.Entity;
import bo.com.ahosoft.utils.reflextion.annotations.Key;
import bo.com.ahosoft.utils.reflextion.annotations.TableName;

@TableName(name = "category")
public class Category extends Entity {

    @Key
    private Long id;
    private String name;
    private Boolean removed;

    public Category() {
        removed = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", removed=" + removed +
                '}';
    }
}
