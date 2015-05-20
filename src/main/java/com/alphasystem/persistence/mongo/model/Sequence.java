/**
 * 
 */
package com.alphasystem.persistence.mongo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.alphasystem.util.HashCodeUtil;

/**
 * @author Syed F Ali
 */
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
	 * @return the initial
	 */
	public long getInitial() {
		return initial;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
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

	/**
	 * @param blockSize
	 *            the blockSize to set
	 */
	public void setBlockSize(long blockSize) {
		this.blockSize = blockSize;
	}

	/**
	 * @param initial
	 *            the initial to set
	 */
	public void setInitial(long initial) {
		this.initial = initial;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param prefix
	 *            the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @param suffix
	 *            the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": NAME = " + name
				+ ", BLOCK SIZE = " + blockSize + ", INITIAL = " + initial
				+ ", PREFIX = " + prefix + ", SUFFIX = " + suffix;
	}
}
