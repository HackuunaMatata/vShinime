package utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by HackuunaMatata on 21.01.2017.
 */
public class DatetimeTag extends TagSupport {
    private String mFormat;
    private Timestamp mDatetime;

    public void setFormat(String pFormat) {
        mFormat = pFormat;
    }

    public void setDatetime(Timestamp pDatetime) {
        mDatetime = pDatetime;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            SimpleDateFormat sdf = new SimpleDateFormat(mFormat);
            out.print(sdf.format(mDatetime));
        } catch (IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }
}
