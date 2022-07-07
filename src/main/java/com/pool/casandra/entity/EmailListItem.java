package com.pool.casandra.entity;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;

@Table(value = "message_by_user_folder")
public class EmailListItem implements Serializable {

    @PrimaryKey
    private EmailListItemKey key;

    @CassandraType(type = Name.LIST, typeArguments = Name.TEXT)
    private List<String> to;

    @CassandraType(type = Name.TEXT)
    private String subject;

    @CassandraType(type = Name.BOOLEAN)
    private boolean isUnread;

    public EmailListItem() {

    }

    public List<String> getTo() {
        return to;
    }

    public EmailListItem setTo(List<String> to) {
        this.to = to;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public EmailListItem setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public boolean isUnread() {
        return isUnread;
    }

    public EmailListItem setUnread(boolean isUnread) {
        this.isUnread = isUnread;
        return this;
    }

    public EmailListItemKey getKey() {
        return key;
    }

    public EmailListItem setKey(EmailListItemKey key) {
        this.key = key;
        return this;
    }

}
