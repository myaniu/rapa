package org.rest.rapa.formatter.JAXB;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringReader;

import javax.xml.bind.JAXB;

import org.rest.rapa.formatter.FormatHandler;
import org.rest.rapa.resource.Resource;

public class XMLHandler implements FormatHandler {

	public Resource deserialize(String content, Class<? extends Resource> clazz) {
		return (Resource) JAXB.unmarshal(new StringReader(content), clazz);
	}

	public String serialize(Resource resource) {
		OutputStream outputStream = new ByteArrayOutputStream();
		JAXB.marshal(resource, outputStream);
		return outputStream.toString();
	}

	public String getExtension() {
		return "xml";
	}

	public String getContentType() {
		return "text/xml";
	}

}
