package com.pool.casandra.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;

@Table(value = "folder_by_user")
public class Folder {
    @PrimaryKeyColumn(name = "user_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private String userid;
    @PrimaryKeyColumn(name="label",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    private String lable;
    @CassandraType(type = Name.TEXT)
    private String color;
    public Folder(){

    }
    public String getUserid() {
        return userid;
    }
    public String getColor() {
        return color;
    }
    public String getLable() {
        return lable;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setLable(String lable) {
        this.lable = lable;
    }
}
