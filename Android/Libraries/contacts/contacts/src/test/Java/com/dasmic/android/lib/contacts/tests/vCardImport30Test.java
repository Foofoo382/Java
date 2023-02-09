package com.dasmic.android.lib.contacts.tests;

import com.dasmic.android.lib.contacts.Data.DataContactTransfer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Chaitanya Belwal on 11/23/2015.
 */
public class vCardImport30Test {
    private static final String CrLf ="\r\n";

    private final String vCard30=
            "BEGIN:VCARD" + CrLf +
                    "VERSION:3.0" + CrLf +
                    "N:Gump;Forrest;Middle;Mr." + CrLf +
                    "FN:Forrest Gump" + CrLf +
                    "ORG:Bubba Gump Shrimp Co." + CrLf +
                    "TITLE:Shrimp Man" + CrLf +
                    "BDAY:1976-12-03" + CrLf +
                    "ANNIVERSARY:2007-12-04" + CrLf +
                    "PHOTO;VALUE=URL;TYPE=GIF:http://www.example.com/dir_photos/my_photo.gif" + CrLf +
                    "TEL;TYPE=WORK,VOICE:(111) 555-1212" + CrLf +
                    "TEL;TYPE=HOME,VOICE:(404) 555-1212" + CrLf +
                    "ADR;TYPE=WORK:;;100 Waters Edge;Baytown;LA;30314;United States of America" + CrLf +
                    "LABEL;TYPE=WORK:100 Waters Edge\nBaytown, LA 30314\nUnited States of America" + CrLf +
                    "ADR;TYPE=HOME:;;42 Plantation St.;Baytown;LA;30314;United States of America" + CrLf +
                    "LABEL;TYPE=HOME:42 Plantation St.\nBaytown, LA 30314\nUnited States of America" + CrLf +
                    "EMAIL;TYPE=PREF,INTERNET:forrestgump@example.com" + CrLf +
                    "REV:2008-04-24T19:52:43Z" + CrLf +
                    "END:VCARD";

    @Test
    public void testSetFromVCard30String() throws Exception {
        String testId="testSetFromVCard30String";
        DataContactTransfer dct = new DataContactTransfer(0);
        dct.setFromVCardString(vCard30);

        assertTrue(testId,
                dct.getVCardName().equals("Forrest Middle Gump"));
        assertTrue(testId,
                dct.getEmailAddresses().getVCardString().equals(
                        "EMAIL;TYPE=home:forrestgump@example.com\r\n")
        );
        assertTrue(testId,
                dct.getPhoneNumbers().getVCardString().equals(
                        "TEL;TYPE=work,voice;VALUE=uri:tel:(111) 555-1212" + "\r\n" +
                                "TEL;TYPE=home,voice;VALUE=uri:tel:(404) 555-1212"
                                + "\r\n"));
        String value= dct.getPostalAddress().getVCardString();
        assertTrue(testId,
                value.equals(
                            "ADR;TYPE=work;LABEL=\"100 Waters Edge\\nBaytown, LA 30314\\nUnited States of America\":;;100 Waters Edge;Baytown;LA;30314;United States of America"
                                + "\r\n" +
                                "ADR;TYPE=home;LABEL=\"42 Plantation St.\\nBaytown, LA 30314\\nUnited States of America\":;;42 Plantation St.;Baytown;LA;30314;United States of America"
                                + "\r\n"));
            value= dct.getEvents().getVCardString();
            assertTrue(testId,
                value.equals(
                        "BDAY:1976-12-03" + "\r\n" +
                                "ANNIVERSARY:2007-12-04" + "\r\n"));



    }
}