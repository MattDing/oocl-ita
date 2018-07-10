package com.oocl.XMLReader;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.oocl.model.Book;

public class XmlReader extends DefaultHandler {
    String value = null;
    Book book = null;
    private ArrayList<Book> bookList = new ArrayList<Book>();
    public ArrayList<Book> getBookList() {
        return bookList;
    }

    @Override
    public void startDocument() throws SAXException {
        // TODO Auto-generated method stub
        super.startDocument();
        System.out.println("SAX start");
    }
  
    @Override
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub
        super.endDocument();
        System.out.println("SAX end");
    }
   
    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("Book")) {

            book = new Book();
            System.out.println("======================start one book=================");
        }
        else if (!qName.equals("Name") && !qName.equals("Books")) {
            System.out.println("element name is：" + qName + "---");
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("Book")) {
            bookList.add(book);
            book = null;
            System.out.println("======================end one book=================");
        }
        else if (qName.equals("Id")) {
            book.setId(value);
        }
        else if (qName.equals("Name")) {
            book.setName(value);
        }
        else if (qName.equals("Price")) {
            book.setPrice(value);
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // TODO Auto-generated method stub
        super.characters(ch, start, length);
        value = new String(ch, start, length);
        if (!value.trim().equals("")) {
            System.out.println("element value is " + value);
        }
    }
}
