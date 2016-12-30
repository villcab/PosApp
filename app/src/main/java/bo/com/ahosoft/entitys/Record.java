package bo.com.ahosoft.entitys;

import java.util.Date;

import bo.com.ahosoft.utils.reflextion.Entity;
import bo.com.ahosoft.utils.reflextion.annotations.Key;
import bo.com.ahosoft.utils.reflextion.annotations.TableName;

/**
 * Created by villcab on 30-12-16.
 */

@TableName(name = "record")
public class Record extends Entity {

    @Key
    private Long id;
    private Double amount;
    private String description;
    private Date date;
    private String createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }

}
