/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.openvpn.ovpn3;

public class ExternalPKISignRequest extends ExternalPKIRequestBase {
	private transient long swigCPtr;

	protected ExternalPKISignRequest(long cPtr, boolean cMemoryOwn) {
		super(ovpncliJNI.ExternalPKISignRequest_SWIGUpcast(cPtr), cMemoryOwn);
		swigCPtr = cPtr;
	}

	protected static long getCPtr(ExternalPKISignRequest obj) {
		return (obj == null) ? 0 : obj.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (swigCPtr != 0) {
			if (swigCMemOwn) {
				swigCMemOwn = false;
				ovpncliJNI.delete_ExternalPKISignRequest(swigCPtr);
			}
			swigCPtr = 0;
		}
		super.delete();
	}

	public void setData(String value) {
		ovpncliJNI.ExternalPKISignRequest_data_set(swigCPtr, this, value);
	}

	public String getData() {
		return ovpncliJNI.ExternalPKISignRequest_data_get(swigCPtr, this);
	}

	public void setSig(String value) {
		ovpncliJNI.ExternalPKISignRequest_sig_set(swigCPtr, this, value);
	}

	public String getSig() {
		return ovpncliJNI.ExternalPKISignRequest_sig_get(swigCPtr, this);
	}

	public ExternalPKISignRequest() {
		this(ovpncliJNI.new_ExternalPKISignRequest(), true);
	}

}
