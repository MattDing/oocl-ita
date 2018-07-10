package com.oocl.main;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.oocl.XMLReader.XmlReader;
import com.oocl.model.Book;


public class Main {
	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
        	SAXParser parser = factory.newSAXParser();
            XmlReader handler = new XmlReader();
            parser.parse("res/book.xml", handler);
            for (Book book : handler.getBookList()) {
                System.out.println(book.getId());
                System.out.println(book.getName());
                System.out.println(book.getPrice());
                System.out.println("----finish----");
            }
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
