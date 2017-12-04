package main.dailynovel.Objects;

import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;

import java.net.URI;

public class Crawler {
    private static String[] argTagStart = {"src=\"https", "href=\"", "itle=\"", "hor\">Tá", "hor\">Th", "ate\">T", "update\"><a"};
    private static String[] argTagEnd = {"\"", "\"", "\" itemprop", "</p", "</p", "</p", "</a"};

    public Crawler() {

    }

    public static Novel getNovelList(int page, int sort, int id) throws Exception {
        return processNovel(crawNovel(page, sort)[id]);
    }

    public static String getChapterContent (String novel, int chapter) throws Exception {
        URI uri = new URI(novel + "/chuong-" + chapter);
        String s = IOUtils.toString(uri, "UTF-8");

        String content = s.substring(s.indexOf("box-chap\">") + ("box-chap\">".length()));
        content =  content.substring(0, content.indexOf("</div"));

        return StringEscapeUtils.unescapeHtml(content);
    }

    public static String getChapterTitle (String novel, int chapter) throws Exception {
        URI uri = new URI(novel + "/chuong-" + chapter);
        String s = IOUtils.toString(uri, "UTF-8");

        String title = s.substring(s.indexOf("h2>") + ("h2>".length()));
        title = title.substring(0, title.indexOf("</h2"));

        return StringEscapeUtils.unescapeHtml(title);
    }

    public static String getNovelDesc(String novel) throws Exception {
        URI uri = new URI(novel);
        String s = IOUtils.toString(uri, "UTF-8");

        String desc = s.substring(s.indexOf("tion\" st") + 28);
        desc = desc.substring(0, desc.indexOf("</div"));

        return StringEscapeUtils.unescapeHtml(desc);
    }

    public static String[] crawNovel (int page, int sort) throws Exception {
        URI uri = new URI("https://truyen.tangthuvien.vn/trang-truyen-dich/" + "trang-" + page + "/" + sort);
        String s = IOUtils.toString(uri, "UTF-8");
        s = s.substring(s.indexOf("item-image")+ ("item-image".length()));
        try {
            s = s.substring(0, s.indexOf("nav-pagination"));
        } catch (IndexOutOfBoundsException e) {
            Log.e ("crawNovel", s , e);
        }
        String[] array = s.split("item-image");
        return array;
    }

    public static Novel processNovel(String element) {
        Novel novel = new Novel();
        int i = 0;
        String siteURL;

        switch (i) {
            case 0:
                siteURL = element.substring(element.indexOf(argTagStart[0]) + 5);
                siteURL = siteURL.substring(0, siteURL.indexOf(argTagEnd[0]));
                novel.setNovelCover(siteURL);
            case 1:
                siteURL = element.substring(element.indexOf(argTagStart[1]) + 6);
                siteURL = StringEscapeUtils.unescapeHtml(siteURL.substring(0, siteURL.indexOf(argTagEnd[1])));
                novel.setNovelID(siteURL);
            case 2:
                siteURL = element.substring(element.indexOf(argTagStart[2]) + 6);
                siteURL = StringEscapeUtils.unescapeHtml(siteURL.substring(0, siteURL.indexOf(argTagEnd[2])));
                novel.setNovelName(siteURL);
            case 3:
                siteURL = element.substring(element.indexOf(argTagStart[3]) + 13);
                siteURL = StringEscapeUtils.unescapeHtml(siteURL.substring(0, siteURL.indexOf(argTagEnd[3])));
                novel.setNovelAuthors(siteURL);
            case 4:
                siteURL = element.substring(element.indexOf(argTagStart[4]) + 14);
                siteURL = StringEscapeUtils.unescapeHtml(siteURL.substring(0, siteURL.indexOf(argTagEnd[4])));
                novel.setNovelType(siteURL);
            case 5:
                siteURL = element.substring(element.indexOf(argTagStart[5]) + 16);
                siteURL = StringEscapeUtils.unescapeHtml(siteURL.substring(0, siteURL.indexOf(argTagEnd[5])));
                novel.setNovelStatus(siteURL);
            case 6:
                siteURL = element.substring(element.indexOf(argTagStart[6]) + 8);
                siteURL = siteURL.substring(siteURL.indexOf("chuong-")+7, siteURL.indexOf("\">"));
                if(siteURL.matches("[0-9]{1,5}")) {
                    novel.setNovelChapter(Integer.parseInt(siteURL));
                }
        }
        return novel;
    }
}
