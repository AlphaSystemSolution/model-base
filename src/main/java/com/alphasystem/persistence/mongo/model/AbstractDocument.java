/**
 * 
 */
package com.alphasystem.persistence.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

import static com.alphasystem.util.HashCodeUtil.hash;
import static com.alphasystem.util.IdGenerator.nextId;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author sali
 * 
 */
public abstract class AbstractDocument implements Serializable,
		Comparable<AbstractDocument> {

	private static final long serialVersionUID = 2893119511804709470L;

	@Id
	protected String id;

	@Indexed(unique = true, name = "dis_name")
	protected String displayName;

	/**
	 * 
	 */
	public AbstractDocument() {
		this(nextId());
	}

	/**
	 * @param id
	 */
	public AbstractDocument(String id) {
		setId(id);
	}

	@Override
	public int compareTo(AbstractDocument o) {
		return (o == null) ? 1 : id.compareTo(o.getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof AbstractDocument) {
			AbstractDocument other = (AbstractDocument) obj;
			return id.equals(other.getId());
		}
		return false;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? nextId() : id;
	}

	@Override
	public int hashCode() {
		return hash(id);
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
