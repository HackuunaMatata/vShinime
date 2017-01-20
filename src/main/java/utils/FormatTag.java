package utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by HackuunaMatata on 20.01.2017.
 */
public class FormatTag extends TagSupport {
    private String mFormat;
    private Date mDate;
    private Locale mLocale = new Locale("ru", "RU");

    public void setFormat(String pFormat) {
        mFormat = pFormat;
    }

    public void setDate(Date pDate) {
        mDate = pDate;
    }

    public void setLocale(Locale pLocale) {
        mLocale = pLocale;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            SimpleDateFormat sdf = new SimpleDateFormat(mFormat, mLocale);
            out.print(sdf.format(mDate));

        } catch (IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }

}
