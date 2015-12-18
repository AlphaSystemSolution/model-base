/**
 * 
 */
package com.alphasystem.persistence.model;

import com.alphasystem.util.HashCodeUtil;
import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author Syed F Ali
 */
@QueryEntity
@Document(collection = "sequence")
public class Sequence implements Serializable, Comparable<Sequence> {

	private static final long serialVersionUID = 3039368170170933550L;

	@Field(value = "block_size", order = 2)
	protected long blockSize;

	@Field(value = "initial", order = 1)
	protected long initial;

	@Id
	protected String name;

	@Field(value = "prefix", order = 3)
	protected String prefix;

	@Field(value = "suffix", order = 4)
	protected String suffix;

	public Sequence() {
	}

	public int compareTo(Sequence o) {
		return o.getName().compareTo(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Sequence) {
			Sequence o = (Sequence) obj;
			return o.getName().equals(name);
		}
		return false;
	}

	/**
	 * @return the blockSize
	 */
	public long getBlockSize() {
		return blockSize;
	}

	/**
	 * @param blockSize
	 *            the blockSize to set
	 */
	public void setBlockSize(long blockSize) {
		this.blockSize = blockSize;
	}

	/**
	 * @return the initial
	 */
	public long getInitial() {
		return initial;
	}

	/**
	 * @param initial
	 *            the initial to set
	 */
	public void setInitial(long initial) {
		this.initial = initial;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix
	 *            the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * @param suffix
	 *            the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public long getValueAfterIncrementing() {
		long temp = initial;
		initial += blockSize;
		return temp;
	}

	@Override
	public int hashCode() {
		return HashCodeUtil.hash(name);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": NAME = " + name
				+ ", BLOCK SIZE = " + blockSize + ", INITIAL = " + initial
				+ ", PREFIX = " + prefix + ", SUFFIX = " + suffix;
	}
}
