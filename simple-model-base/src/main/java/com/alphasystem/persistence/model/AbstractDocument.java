/**
 *
 */
package com.alphasystem.persistence.model;

import static java.lang.String.format;

/**
 * @author sali
 */
public abstract class AbstractDocument extends AbstractSimpleDocument {

    private static final long serialVersionUID = 2893119511804709470L;

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
        initDisplayName();
        return getDisplayName();
    }

}
