package com.example.a10ngawang.top10downloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by 10ngawang on 2/14/2019.
 */

public class ParseApplication {
    private static final String TAG = "ParseApplication";
    private ArrayList<FeedEntry> application;

    public ParseApplication() {
        this.application = new ArrayList<>();
    }

    public ArrayList<FeedEntry> getApplication() {
        return application;
    }

    public boolean parse(String xmlData){
        boolean status = true;
        FeedEntry currentRecord = null;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(xmlData));
            int evenType = xpp.getEventType();

            while (evenType != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();

                switch (evenType){

                    case XmlPullParser.START_TAG:
                        Log.d(TAG, "parse: Starting tag for " + tagName);
                        if("entry".equalsIgnoreCase(tagName)){
                            inEntry = true;
                            currentRecord = new FeedEntry();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        Log.d(TAG, "parse: Ending tag for " + tagName);
                        if(inEntry){
                            if("entry".equalsIgnoreCase(tagName)){
                                application.add(currentRecord);
                                inEntry = false;
                            }else  if("name".equalsIgnoreCase(tagName)){
                                currentRecord.setName(textValue);
                            }else if("artist".equalsIgnoreCase(tagName)){
                                currentRecord.setArtist(textValue);
                            }else if("releaseDate".equalsIgnoreCase(tagName)){
                                currentRecord.setReleaseDate(textValue);
                            }else if("summary".equalsIgnoreCase(tagName)){
                                currentRecord.setSummary(textValue);
                            }else if("image".equalsIgnoreCase(tagName)){
                                currentRecord.setImageURL(textValue);
                            }
                        }
                        break;

                    default:
                        //Nothing is to d
                }//switch
                evenType = xpp.next(); 
            }//while
            for (FeedEntry app: application){
                Log.d(TAG, "********************");
                Log.d(TAG, app.toString());
            }

        }catch (Exception e){
            status = false;
            e.printStackTrace();
        }

        return status;
    }
}
