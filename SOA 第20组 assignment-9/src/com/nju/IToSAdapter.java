package com.nju;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IToSAdapter extends XmlAdapter<String, Integer>{


        public Integer unmarshal(String value) {
            return new Integer(value); }

        public String marshal(Integer value) {
            return value.toString(); }



}
