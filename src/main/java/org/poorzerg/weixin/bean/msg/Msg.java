package org.poorzerg.weixin.bean.msg;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.poorzerg.weixin.bean.msg.out.OutMsg;
import org.poorzerg.weixin.utils.XStreamFactory;

import com.thoughtworks.xstream.XStream;

public abstract class Msg {
	@SuppressWarnings("unchecked")
	public static <T extends OutMsg> T fromXml(String xml, Class<T> clazz) {
		XStream xs = XStreamFactory.init(true);
		xs.processAnnotations(clazz);
		return (T) xs.fromXML(xml);
	}

	public String toXml() {
		XStream xs = XStreamFactory.init(true);
		xs.autodetectAnnotations(true);
		return xs.toXML(this);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
