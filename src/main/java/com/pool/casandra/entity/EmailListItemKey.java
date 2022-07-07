package com.pool.casandra.entity;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class EmailListItemKey implements Serializable {

    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String id;

    @PrimaryKeyColumn(name = "label", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String label;

    @PrimaryKeyColumn(name = "created_time_uuid", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = CassandraType.Name.TIMEUUID)
    private UUID timeUuid;

    public EmailListItemKey() {

    }

    public String getId() {
        return id;
    }

    public EmailListItemKey setId(String id) {
        this.id = id;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public EmailListItemKey setLabel(String label) {
        this.label = label;
        return this;
    }

    public UUID getTimeUuid() {
        return timeUuid;
    }

    public EmailListItemKey setTimeUuid(UUID timeUuid) {
        this.timeUuid = timeUuid;
        return this;
    }

}
