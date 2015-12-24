/**
 *
 */
package com.alphasystem.persistence.model;

import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author sali
 */
@Entity
@Document
public abstract class AbstractDocument extends AbstractSimpleDocument {

    private static final long serialVersionUID = 2893119511804709470L;


    @Indexed(unique = true, name = "dis_name")
    protected String displayName;

    /**
     *
     */
    public AbstractDocument() {
        this(null);
    }

    /**
     * @param id ID of this document
     */
    public AbstractDocument(String id) {
        super(id);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void initDisplayName() {
        setDisplayName(format("%s:%s", getClass().getSimpleName(), id));
    }

    @Override
    public String toString() {
        if (isBlank(displayName)) {
            initDisplayName();
        }
        return displayName;
    }

}
