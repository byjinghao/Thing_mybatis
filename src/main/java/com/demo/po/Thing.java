package com.demo.po;

public class Thing {
    private Integer id;
    private String thingname;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getThingname() {
        return thingname;
    }

    public void setThingname(String thingname) {
        this.thingname = thingname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "id=" + id +
                ", thingname='" + thingname + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
