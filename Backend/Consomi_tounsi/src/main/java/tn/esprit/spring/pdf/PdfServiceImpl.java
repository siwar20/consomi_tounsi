package tn.esprit.spring.pdf;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.reclamation;
import tn.esprit.spring.repository.ReclamationRepository;

import java.io.*;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class PdfServiceImpl implements PdfService {

    @Autowired
    ReclamationRepository reclamationRepository;
    @Override
    public String toPDF(int idReclamaion)
    {
        String URL_file = null;

        reclamation Reclamation = reclamationRepository.findById(idReclamaion).get();


        Date d = new Date();
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("yyyyMMdd_HHmmss");


        try {
            try {
                try {
                    try {

                        URL_file = "C:\\Users\\Oussema\\reclamation\\" + idReclamaion + "_" + formater.format(d)
                                + ".pdf";

                        OutputStream file = new FileOutputStream(new File(URL_file));


                        Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.GRAY);
                        Font catFont15B = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
                        Font subFontPara13B = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
                        Font subFontPara13N = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
                        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);

                        Document my_pdf_report = new Document();
                        PdfWriter.getInstance(my_pdf_report, file);
                        my_pdf_report.open();

                        // Dateeee
                        DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
                        String dt = df.format(new Date());
                        Paragraph dateStr = new Paragraph("Date: " + dt, smallBold);
                        dateStr.setAlignment(Element.ALIGN_RIGHT);


                        Paragraph description = new Paragraph(Reclamation.getStatus(), subFont);
                        description.setAlignment(Element.ALIGN_LEFT);

                        // espaceee
                        Paragraph espace = new Paragraph(" ", subFont);
                        espace.setAlignment(Element.ALIGN_LEFT);

                        // para1
                        Paragraph para1 = new Paragraph("Your Claim has been submited", catFont15B);
                        para1.setAlignment(Element.ALIGN_LEFT);
                        Paragraph para2 = new Paragraph(
                                "Consomi Tounsi Thank you for You Trust ", subFontPara13N);
                        para2.setAlignment(Element.ALIGN_LEFT);

                        // espaceee



                        // titreee
                        Paragraph titre1 = new Paragraph("Your Claim Status is "+Reclamation.getStatus(), catFont15B);
                        titre1.setAlignment(Element.ALIGN_CENTER);

                        // espaceee

                        espace.setAlignment(Element.ALIGN_LEFT);

                        // table declaration
                        PdfPTable table = new PdfPTable(3);
                        table.setWidthPercentage(90);


                        //Ligne 1
                        /*PdfPCell Cellnom = new PdfPCell(new Phrase("Your Order weight is :\r\n " + payment.getOrder().getWeight() + " ", subFontPara13N));
                        Cellnom.setBorder(Rectangle.NO_BORDER);
                        Cellnom.setBackgroundColor(BaseColor.WHITE);
                        table.addCell(Cellnom);

                         */

                       /* //Ligne 2
                        PdfPCell CellEmail = new PdfPCell(new Phrase("Your Payment Type :\r\n" + payment.getOrder().getPaymentType(), subFontPara13N));
                        CellEmail.setBorder(Rectangle.NO_BORDER);
                        CellEmail.setBackgroundColor(BaseColor.WHITE);
                        table.addCell(CellEmail);

                        */

                        //Ligne 3
                        PdfPCell Celsal = new PdfPCell(new Phrase("The Estimated date is 3 days ", subFontPara13N));
                        Celsal.setBorder(Rectangle.NO_BORDER);
                        Celsal.setBackgroundColor(BaseColor.WHITE);
                        table.addCell(Celsal);

                        //break
                        Paragraph separator = new Paragraph("_____________________________________________________________________",
                                catFont15B);
                        separator.setAlignment(Element.ALIGN_CENTER);


                        Paragraph titrefin = new Paragraph("THANK YOU FOR\r\nUSING OUR SERVICE.", subFont);
                        titrefin.setAlignment(Element.ALIGN_LEFT);


                        // fiin P1
                        Paragraph finPage1 = new Paragraph(" Page 1/1", smallBold);
                        finPage1.setAlignment(Element.ALIGN_RIGHT);



                        my_pdf_report.add(description);
                        my_pdf_report.add(dateStr);

                        my_pdf_report.add(espace);

                        my_pdf_report.add(para1);
                        my_pdf_report.add(para2);
                        my_pdf_report.add(espace);


                        my_pdf_report.add(separator);
                        my_pdf_report.add(espace);
                        my_pdf_report.add(titre1);

                        my_pdf_report.add(espace);
                        my_pdf_report.add(table);
                        my_pdf_report.add(espace);



                        my_pdf_report.close();
                        file.close();

                        Runtime.getRuntime()
                                .exec("rundll32 url.dll,FileProtocolHandlerC:\\Users\\Oussema\\reclamation\\"
                                        + idReclamaion + "_" + formater.format(d) + ".pdf");
                        //p.waitFor(2, TimeUnit.SECONDS);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } catch (DocumentException e) {
                    e.printStackTrace();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "" + idReclamaion + "_" + formater.format(d) + ".pdf";
    }
}