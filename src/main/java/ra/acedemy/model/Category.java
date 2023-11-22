package ra.acedemy.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Category {
    private Long id;
    private String name;
    private String des;
    private LocalDate createDate;

    public Category() {
    }
    public Category(Long id, String name, String des) {
        this.id = id;
        this.name = name;
        this.des = des;
    }

    public Category(Long id, String name, String des, LocalDate createDate) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.createDate = createDate;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    public String formatTime(){
        return createDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
