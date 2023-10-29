package com.digital.coffee.shop.jpa.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QueueQueueItemEntity implements Serializable {
    @Id private Long relationshipId;

    private Long queueItemId;
    private Long queueId;

    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public Long getQueueItemId() {
        return queueItemId;
    }

    public void setQueueItemId(Long queueItemId) {
        this.queueItemId = queueItemId;
    }

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }
}
