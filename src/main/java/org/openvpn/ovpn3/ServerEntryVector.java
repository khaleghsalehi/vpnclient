/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.openvpn.ovpn3;

public class ServerEntryVector {
	private transient long swigCPtr;
	protected transient boolean swigCMemOwn;

	protected ServerEntryVector(long cPtr, boolean cMemoryOwn) {
		swigCMemOwn = cMemoryOwn;
		swigCPtr = cPtr;
	}

	protected static long getCPtr(ServerEntryVector obj) {
		return (obj == null) ? 0 : obj.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (swigCPtr != 0) {
			if (swigCMemOwn) {
				swigCMemOwn = false;
				ovpncliJNI.delete_ServerEntryVector(swigCPtr);
			}
			swigCPtr = 0;
		}
	}

	public ServerEntryVector() {
		this(ovpncliJNI.new_ServerEntryVector__SWIG_0(), true);
	}

	public ServerEntryVector(long n) {
		this(ovpncliJNI.new_ServerEntryVector__SWIG_1(n), true);
	}

	public long size() {
		return ovpncliJNI.ServerEntryVector_size(swigCPtr, this);
	}

	public long capacity() {
		return ovpncliJNI.ServerEntryVector_capacity(swigCPtr, this);
	}

	public void reserve(long n) {
		ovpncliJNI.ServerEntryVector_reserve(swigCPtr, this, n);
	}

	public boolean isEmpty() {
		return ovpncliJNI.ServerEntryVector_isEmpty(swigCPtr, this);
	}

	public void clear() {
		ovpncliJNI.ServerEntryVector_clear(swigCPtr, this);
	}

	public void add(ServerEntry x) {
		ovpncliJNI.ServerEntryVector_add(swigCPtr, this, ServerEntry.getCPtr(x), x);
	}

	public ServerEntry get(int i) {
		return new ServerEntry(ovpncliJNI.ServerEntryVector_get(swigCPtr, this, i), false);
	}

	public void set(int i, ServerEntry val) {
		ovpncliJNI.ServerEntryVector_set(swigCPtr, this, i, ServerEntry.getCPtr(val), val);
	}

}