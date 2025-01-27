package com.getir.utils;

import java.text.Normalizer;

public class TextUtils {
    public static String normalizeText(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFKC)
                .replace("ÅŸ", "ş")
                .replace("Å", "Ş")
                .replace("Ä±", "ı")
                .replace("Ä", "İ")
                .replace("Ã¶", "ö")
                .replace("Ã¼", "ü")
                .replace("Ã§", "ç")
                .replace("Ã", "Ç");
    }
}