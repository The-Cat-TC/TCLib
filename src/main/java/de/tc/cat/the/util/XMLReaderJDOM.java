/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.util;

import java.io.*;
import java.util.List;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;
/**
 *The XMLParser class represents a JDOM Parser used to read XML Documents.
 * It enables the XML Document to be read out in a targeted manner.
 *
 * @author Christian Trostmann
 * @since 1.8
 * @version 1.0
 * @see org.jdom2.input.SAXBuilder
 * @see org.jdom2.output.XMLOutputter
 * @see org.jdom2.Document
 * @see org.jdom2.Element
 */
public class XMLReaderJDOM {
    private final XMLOutputter fmt;
    private final Document doc;
    private final Element elm;
    /**
     * It provides all the Components needed to read an XML Document.
     *
     * @param f Provides the File or XML Document to be read in.
     * @throws org.jdom2.JDOMException if any.
     * @throws java.io.IOException if any.
     */
    public XMLReaderJDOM(java.io.File f) throws JDOMException, IOException
    {
       
       var builder = new SAXBuilder();
       doc = builder.build(f); 
       fmt = new XMLOutputter();
       elm = doc.getRootElement();
       
    }
     /**
      * Read the full XML Document.
      *
      * @return Returns the XML As XMLOutputter.
      * @throws java.io.IOException if any.
      */
     public XMLOutputter XMLRead() throws IOException
     {
         return fmt;
     }
     /**
      * Read the Root Element of the XML Document.
      *
      * @return Returns the Root Element as a string.
      */
     public String readRootName()
     {
         
         return elm.getName();
     }
     /**
      * Reads the Children elmente Of the XML Document.
      *
      * @return Returns the Children elements as a List.
      */
     public List<Element> listChilderen()
     {
         return elm.getChildren();
     }
     /**
      * Reads the Children elmente Of the XML Document.
      *
      * @param s The Children's Element as should be read.
      * @return Returns the Children elements as a List.
      */
     public List<Element> listChilderen(String s)
     {
         return elm.getChildren(s);
     }
     /**
      * Reads the Children elmente Of the XML Document.
      *
      * @param s The Children's Element as should be read.
      * @param i The Index of the Children's Element to be read.
      * @return Returns the Children elements as a Object.
      */
     public Object listChilderen(String s, Integer i)
     {
         return listChilderen(s).get(i);
     }
     /**
      * Reads the Value of the Children's Element.
      *
      * @return Returns the Value of the Children'S element as a String.
      */
     public String readValue()
     {
         return elm.getValue();
     }
     /**
      * Reads the Value of the Children's Element.
      *
      * @param s Returns the Value of the Children's Element.
      * @return Returns the Value of the Children'S element as a String.
      */
     public String readValue(String s)
     {
         return elm.getChildText(s);
     }
     /**
      * Reads the Value of the Children's Element.
      *
      * @param s Returns the Value of the Children's Element.
      * @param i Indicates the Index of the Child Element.
      * @return Returns the Value of the Children'S element as a String.
      */
     public String readValue(String s, Integer i)
     {
         return elm.getChildren(s).get(i).getText();
     }
     
     /**
      * Reads the Attribute of a Children'S element.
      *
      * @param Child Enlists the Child Element to be read from.
      * @param Attribut Enlists The Atrribut to be read from.
      * @return Returns the Value of the Attribute as a String.
      */
     public String readAttributsValue(String Child, String Attribut)
     {
         var elm2 = elm.getChild(Child);
         return elm2.getAttributeValue(Attribut);
     }
     /**
      * Reads the Attribute of a Children'S element.
      *
      * @param Child Enlists the Child Element to be read from.
      * @param Attribut Enlists The Atrribut to be read from.
      * @param i give the Index of the children's element.
      * @return Returns the Value of the Attribute as a String.
      */
     public String readAttributsValue(String Child, String Attribut, Integer i)
     {
         var elm2 = (Element) listChilderen(Child, i);
         return elm2.getAttributeValue(Attribut);
     }
             
}
