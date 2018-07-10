package com.oocl.XMLReader;

import static org.junit.Assert.*;

import org.junit.Test;
import org.xml.sax.SAXException;

public class XmlReaderTest {

	private XmlReader reader = new XmlReader();



	@Test
	public void testCharacters() throws SAXException {
		String s = "1324143124311";
		reader.characters(s.toCharArray(), 0, s.length());
		assertEquals(s, reader.value);
	}

}
