package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {

        try
        {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            StringWriter writer = new StringWriter();

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(obj, writer);

            String xml = writer.toString();
            String commentPut = "<!--"+comment+"-->";
            String tag = "<"+tagName+">";

            //Создаю регулярку для поиска CDATA
            Pattern pattern = Pattern.compile("(<!\\[CDATA\\[(.|\n)*?]]>)");
            Matcher matcher = pattern.matcher(xml);
            //Все найденные CDATA кладу в лист
            List<String> cdatas = new ArrayList<>();
            while (matcher.find()){
                cdatas.add(matcher.group());
            }
            //Заменяю все CDATA на другой тег
            xml = (xml.replaceAll(pattern.pattern(),"<URURU/>"));

            //ставлю комментарии в xml в котором нету CDATA и есть URURU teg
            List<String> list = new ArrayList<>(Arrays.asList(xml.split("\n")));
            List<String> copy = new ArrayList<>(list);
            for(int i =0;i<copy.size();i++){
                String s = copy.get(i);
                if(s.contains(tag)){
                    int count = spaceCount(s);
                    for(int j =0;j<count;j++){
                        commentPut = " "+commentPut;
                    }
                    list.set(i,commentPut+"\n"+s);
                    commentPut = commentPut.trim();
                }

            }
            //делаю новый xml который уже с комментами
            StringBuilder comments = new StringBuilder();
            for(String elem : list){
                comments.append(elem+"\n");
            }
            xml = comments.toString();


            //заменяю все URURU обратно на CDATA
            List<String> ururu = new ArrayList<>(Arrays.asList(xml.split("<URURU/>")));
            for(int i =0;i<cdatas.size();i++){
                String s = ururu.get(i);
                s+=cdatas.get(i);
                ururu.set(i,s);
            }

            //Делаю финальный xml
            StringBuilder result = new StringBuilder();
            for(String cdata : ururu)
                result.append(cdata);


            return result.toString().replace("standalone=\"yes\"","standalone=\"no\"");

        }
        catch (JAXBException e)
        {
            e.printStackTrace();
            return "";
        }
    }
    //штука для счета пробелов
    public static int spaceCount(String word){
        word = word.substring(0,word.indexOf("<"));
        int count = 0;
        char[] array = word.toCharArray();
        for(Character charc : array){
            if(charc == ' ')count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
