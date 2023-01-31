package com.mycompany.pdfsplitter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;



public class PDFSplitter {

    public static void main(String[] args)throws IOException {

         File oldFile = new File("C:\\PDFSplitter\\sample.pdf");

         PDDocument document = PDDocument.load(oldFile);
         
         File newFileDestination = new File("C:\\PDFSplitter\\extract");
         newFileDestination.mkdirs();
         
         Splitter splitter = new Splitter();
         splitter.setStartPage(11);
         splitter.setEndPage(20);
         
         List<PDDocument> splitPage = splitter.split(document);
         
         PDDocument newDoc = new PDDocument();
         for(PDDocument mydoc : splitPage)
             
         {
             newDoc.addPage(mydoc.getPage(0));
         }   
         newDoc.save(newFileDestination+"//split.pdf");
         newDoc.close();
         System.out.println("PDF Created");
        
    }
}
