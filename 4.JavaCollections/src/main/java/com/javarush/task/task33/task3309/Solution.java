package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {

        //писать результат сериализации будем в Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(obj.getClass());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Marshaller marshaller = null;
        try {
            marshaller = context.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        // сама сериализация
        try {
            marshaller.marshal(obj, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        InputStream stream = new ByteArrayInputStream(writer.toString().getBytes(StandardCharsets.UTF_8));
        //преобразовываем в строку все записанное в StringWriter
        // String result = writer.toString();

        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //проверяет, сконфигурирован ли DOM-анализатор для преобразования узлов типа CDATA в узлы типа Text
        // и присоединяют их к соседнему узлу (если он существует) в документе XML
        // или устанавливают режим такого преобразования в документе XML (при значении coalescing, равном true)
        // По умолчанию значение coalescing установлено в false.)
        dbf.setCoalescing(true);

        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document doc = null;
        try {
            doc = db.parse(stream);
            doc.getDocumentElement().normalize();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Получение списка всех элементов tagName внутри корневого элемента
        // (getDocumentElement возвращает ROOT элемент XML файла).
        NodeList nodeList = doc.getElementsByTagName(tagName);

        // Перебор всех элементов tagName
        for (int s = 0; s < nodeList.getLength(); s++) {
            Node node = nodeList.item(s);

            if (node.getNodeName().equals(tagName)) {
                node.getParentNode().insertBefore(doc.createComment(comment), node);
                node.getParentNode().insertBefore(doc.createTextNode("\n"), node);
                if (node.getTextContent().matches(".*[<>&'\"].*")) {
                    String textCDATA = String.format("<![CDATA[%s]]>", node.getTextContent());
                    node.setTextContent(textCDATA);
                    //node.getParentNode().appendChild(doc.createCDATASection(textCDATA));
                }
            }
        }

        DOMSource source = new DOMSource(doc);
        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = factory.newTransformer();

            //перенос строки
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution.toXmlWithComment(new First(), "second", "it's a comment"));
    }

    @XmlRootElement(name = "first")
    public static class First {

        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
        @XmlElement(name = "second")
        public String item3 = "";
        @XmlElement(name = "third")
        public String item4;
        @XmlElement(name = "forth")
        public Second[] third = new Second[]{new Second()};
        @XmlElement(name = "fifth")
        public String item5 = "need CDATA because of \"";
    }

    public static class Second {

        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
    }
}
