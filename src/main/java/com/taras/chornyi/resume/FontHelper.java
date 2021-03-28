package com.taras.chornyi.resume;

import com.lowagie.text.pdf.BaseFont;
import lombok.SneakyThrows;

public final class FontHelper {

    private static BaseFont bfTitle;
    private static BaseFont bfChapter;
    private static BaseFont bfText;
    private static BaseFont bfTextBold;

    private FontHelper() {
    }

    @SneakyThrows
    public static BaseFont getBfChapter() {
        if (bfChapter == null) {
            bfChapter = BaseFont.createFont("src/main/resources/fonts/arialbd.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        }
        return bfChapter;
    }

    @SneakyThrows
    public static BaseFont getBfText() {
        if (bfText == null) {
            bfText = BaseFont.createFont("src/main/resources/fonts/georgia.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        }
        return bfText;
    }

    @SneakyThrows
    public static BaseFont getBfTitle() {
        if (bfTitle == null) {
            bfTitle = BaseFont.createFont("src/main/resources/fonts/COPRGTB.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        }
        return bfTitle;
    }

    @SneakyThrows
    public static BaseFont getBfTextBold() {
        if (bfTextBold == null) {
            bfTextBold = BaseFont.createFont("src/main/resources/fonts/georgiab.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        }
        return bfTextBold;
    }

}
