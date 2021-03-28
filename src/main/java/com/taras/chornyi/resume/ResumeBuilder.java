package com.taras.chornyi.resume;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfWriter;
import lombok.SneakyThrows;
import lombok.val;
import lombok.var;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.Map;

/**
 * Resume builder
 *
 * @author Taras Chornyi
 */
public class ResumeBuilder {

    private final Font ANCHOR = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL, new Color(220, 0, 0));
    private final static float DIVIDE = 156f;

    private final Document document;
    private final PdfWriter writer;
    private float currentY;

    @SneakyThrows
    public ResumeBuilder(String fileName, String title, String author, String keywords) {
        document = new Document();
        writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.addTitle(title);
        document.addAuthor(author);
        document.addKeywords(keywords);
        document.open();

        currentY = document.top();
    }

    public void build() {
        if (document != null) {
            document.close();
        }
    }

    @SneakyThrows
    public ResumeBuilder addPageNumber(String number) {
        val img = Image.getInstance("src/main/resources/images/box.gif");
        img.scalePercent(60f);
        img.setAbsolutePosition(document.right() - 10, document.bottom()-5);
        document.add(img);

        val cb = writer.getDirectContent();
        val ct = new ColumnText(cb);

        val p = new Phrase(new Chunk(number, new Font(FontHelper.getBfTitle(), 16)));
        ct.setSimpleColumn(p, document.right() - 5, document.bottom() - 140, document.right() + 20, document.bottom() + 20, 24, Element.ALIGN_LEFT);
        ct.go();

        return this;
    }

    @SneakyThrows
    public ResumeBuilder addNewPage() {
        document.newPage();

        currentY = document.top() - 20;

        val cb = writer.getDirectContent();

        cb.setLineWidth(1);
        cb.moveTo(DIVIDE, currentY);
        cb.lineTo(DIVIDE, document.bottom() + 20);
        cb.stroke();

        return this;
    }

    @SneakyThrows
    public ResumeBuilder addHeader(String header) {
        val img = Image.getInstance("src/main/resources/images/header.gif");
        img.scalePercent(60f);
        img.setAbsolutePosition(0, document.top());
        document.add(img);

        val cb = writer.getDirectContent();
        val ct = new ColumnText(cb);

        val p = new Phrase(new Chunk(header, new Font(FontHelper.getBfTitle(), 16)));
        ct.setSimpleColumn(p, 15, document.top() + 37, 200, 200, 24, Element.ALIGN_LEFT);
        ct.go();

        currentY = ct.getYLine();

        return this;
    }

    @SneakyThrows
    public ResumeBuilder addTitle(String name, String emailName, String skype, String image, Map<String, String> links) {
        val img = Image.getInstance(image);
        img.scalePercent(30f);
        img.setAbsolutePosition(document.left() + 0, document.top() - 80);
        document.add(img);

        val email = new Anchor(emailName, ANCHOR);
        email.setReference(emailName);

        val skypeAnchor = new Anchor(skype, ANCHOR);
        skypeAnchor.setReference(skype);

        val cb = writer.getDirectContent();
        val ct = new ColumnText(cb);

        var p = new Phrase(new Chunk(name + ", ", new Font(FontHelper.getBfTitle(), 14)));
        p.add(new Chunk("e-mail: ", new Font(FontHelper.getBfText(), 11)));
        p.add(email);
        p.add(new Chunk(", Skype: ", new Font(FontHelper.getBfText(), 11)));
        p.add(skypeAnchor);
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), document.top(), 24, Element.ALIGN_LEFT);
        ct.go();

        currentY = document.top() - 17;

        if (links != null) {
            for (val entry: links.entrySet()) {
                val link = new Anchor(entry.getValue(), ANCHOR);
                link.setReference(entry.getValue());
                p = new Phrase(new Chunk(entry.getKey(), new Font(FontHelper.getBfText(), 11)));
                p.add(link);
                ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_LEFT);
                ct.go();
                currentY -= 17;
            }
        }

        currentY = ct.getYLine() - 15;
        cb.setLineWidth(1);
        cb.moveTo(document.left(), currentY);
        cb.lineTo(document.right(), currentY);
        cb.stroke();

        currentY -= 8;
        cb.setLineWidth(1);
        cb.moveTo(DIVIDE, currentY);
        cb.lineTo(DIVIDE, document.bottom() + 20);
        cb.stroke();

        return this;
    }

    @SneakyThrows
    public ResumeBuilder addChapter(String title, int offset) {
        currentY -= offset;
        doChapter(currentY, title);

        return this;
    }

    @SneakyThrows
    public ResumeBuilder addChapter(String title, String text, int offset) {
        addChapter(title, offset);
        doDescription(currentY, text);
        
        return this;
    }

    @SneakyThrows
    public ResumeBuilder addExperience(String period, String position,
                                       String company, String link, String location,
                                       String project, String technologies, int offset) {
        currentY -= offset;
        val cb = writer.getDirectContent();
        val ct = new ColumnText(cb);

        var p = new Phrase(new Chunk(period, new Font(FontHelper.getBfTextBold(), 11)));
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        currentY = ct.getYLine();
        p = new Phrase(new Chunk("Position: ", new Font(FontHelper.getBfTextBold(), 11)));
        p.add(new Chunk(position, new Font(FontHelper.getBfText(), 11)));
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        currentY = ct.getYLine();
        p = new Phrase(new Chunk("Company: ", new Font(FontHelper.getBfTextBold(), 11)));
        p.add(new Chunk(company, new Font(FontHelper.getBfText(), 11)));
        Anchor anchor = new Anchor(" " + link, ANCHOR);
        anchor.setReference(link);
        p.add(anchor);
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        currentY = ct.getYLine();
        p = new Phrase(new Chunk("Location: ", new Font(FontHelper.getBfTextBold(), 11)));
        p.add(new Chunk(location, new Font(FontHelper.getBfText(), 11)));
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        currentY = ct.getYLine();
        p = new Phrase(new Chunk("Project: ", new Font(FontHelper.getBfTextBold(), 11)));
        p.add(new Chunk(project, new Font(FontHelper.getBfText(), 11)));
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        currentY = ct.getYLine();
        p = new Phrase(new Chunk("Technologies: ", new Font(FontHelper.getBfTextBold(), 11)));
        p.add(new Chunk(technologies, new Font(FontHelper.getBfText(), 11)));
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        currentY = ct.getYLine();

        return this;
    }

    @SneakyThrows
    public ResumeBuilder addCompanyExperience(String period,
                                       String company, String link, String location, int offset) {
        currentY -= offset;
        val cb = writer.getDirectContent();
        val ct = new ColumnText(cb);

        var p = new Phrase(new Chunk(period, new Font(FontHelper.getBfTextBold(), 11)));
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        currentY = ct.getYLine();
        p = new Phrase(new Chunk("Company: ", new Font(FontHelper.getBfTextBold(), 11)));
        p.add(new Chunk(company, new Font(FontHelper.getBfText(), 11)));
        Anchor anchor = new Anchor(" " + link, ANCHOR);
        anchor.setReference(link);
        p.add(anchor);
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();


        currentY = ct.getYLine();
        p = new Phrase(new Chunk("Location: ", new Font(FontHelper.getBfTextBold(), 11)));
        p.add(new Chunk(location, new Font(FontHelper.getBfText(), 11)));
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        currentY = ct.getYLine();

        return this;
    }

    @SneakyThrows
    public ResumeBuilder addProjectExperience(String date,
                                              String title,
                                              String position,
                                              String project, String technologies, int offset) {
        currentY -= offset;
        val cb = writer.getDirectContent();
        val ct = new ColumnText(cb);

        var p = new Phrase(new Chunk("Date: ", new Font(FontHelper.getBfTextBold(), 11)));
        p.add(new Chunk(date, new Font(FontHelper.getBfText(), 11)));
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        currentY = ct.getYLine();
        currentY -= 2;
        p = new Phrase(new Chunk("Project: ", new Font(FontHelper.getBfTextBold(), 11)));
        p.add(new Chunk(title, new Font(FontHelper.getBfText(), 11)));
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        currentY = ct.getYLine();
        currentY -= 2;
        p = new Phrase(new Chunk("Position: ", new Font(FontHelper.getBfTextBold(), 11)));
        p.add(new Chunk(position, new Font(FontHelper.getBfText(), 11)));
        ct.setSimpleColumn(p, DIVIDE + 10, 0, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        currentY = ct.getYLine();
        currentY -= 2;
        p = new Phrase(new Chunk("Description: ", new Font(FontHelper.getBfTextBold(), 11)));
        p.add(new Chunk(project, new Font(FontHelper.getBfText(), 11)));
        ct.setSimpleColumn(p, DIVIDE + 10, 5, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        currentY = ct.getYLine();
        currentY -= 2;
        p = new Phrase(new Chunk("Technologies: ", new Font(FontHelper.getBfTextBold(), 11)));
        p.add(new Chunk(technologies, new Font(FontHelper.getBfText(), 11)));
        ct.setSimpleColumn(p, DIVIDE + 10, 20, document.right(), currentY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();

        return this;
    }

    @SneakyThrows
    private void doChapter(float lineY, String name) {
        val cb = writer.getDirectContent();
        val ct = new ColumnText(cb);

        val p = new Phrase(new Chunk(name, new Font(FontHelper.getBfChapter(), 11)));
        ct.setSimpleColumn(p, document.left(), 0, DIVIDE-10, lineY, 24, Element.ALIGN_RIGHT);
        ct.setLeading(14);
        ct.go();
    }

    @SneakyThrows
    private void doDescription(float lineY, String description) {
        val cb = writer.getDirectContent();
        ColumnText ct = new ColumnText(cb);

        val p = new Phrase(new Chunk(description, new Font(FontHelper.getBfText(), 11)));
        ct.setSimpleColumn(p, DIVIDE+10, 0, document.right(), lineY, 24, Element.ALIGN_JUSTIFIED);
        ct.setLeading(14);
        ct.go();
    }

}
