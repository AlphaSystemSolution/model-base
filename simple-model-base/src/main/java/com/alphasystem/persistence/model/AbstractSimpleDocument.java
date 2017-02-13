package com.alphasystem.persistence.model;

import java.io.Serializable;

import static com.alphasystem.util.HashCodeUtil.hash;
import static com.alphasystem.util.IdGenerator.nextId;

/**
 * Super class of all documents.
 *
 * @author sali
 */
public abstract class AbstractSimpleDocument implements Serializable, Comparable<AbstractSimpleDocument> {

    protected String id;

    /**
     *
     */
    public AbstractSimpleDocument() {
        this(null);
    }

    /**
     * @param id ID of this document
     */
    public AbstractSimpleDocument(String id) {
        setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = (id == null) ? nextId() : id;
    }

    @Override
    public int hashCode() {
        return hash(id);
    }

    @Override
    public int compareTo(AbstractSimpleDocument o) {
        return (o == null) ? 1 : id.compareTo(o.getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof AbstractSimpleDocument) {
            AbstractSimpleDocument other = (AbstractSimpleDocument) obj;
            return id.equals(other.getId());
        }
        return false;
    }

    @Override
    public String toString() {
        return getId();
    }
}
