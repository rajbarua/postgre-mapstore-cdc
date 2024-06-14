package com.hz.sample.domain;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.hazelcast.nio.serialization.compact.CompactReader;
import com.hazelcast.nio.serialization.compact.CompactSerializer;
import com.hazelcast.nio.serialization.compact.CompactWriter;

public class DashboardSerializer implements CompactSerializer<Dashboard>{

    @Override
    public Class<Dashboard> getCompactClass() {
        return Dashboard.class;
    }

    @Override
    public String getTypeName() {
        return "dashboard";
    }

    @Override
    public Dashboard read(CompactReader reader) {
        //best to read and write alphabetically but not necessary.
        Dashboard dashboard = new Dashboard();
        dashboard.setBankcode(reader.readInt32("bankcode"));
        dashboard.setBrnchcode(reader.readString("brnchcode"));
        dashboard.setReckey(reader.readInt64("reckey"));
        dashboard.setScanref(reader.readString("scanref"));
        LocalDate scndate = reader.readDate("scndate");
        Date date = Date.from(scndate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        dashboard.setScndate(date);
        return dashboard;
    }

    @Override
    public void write(CompactWriter writer, Dashboard dashboard) {
        writer.writeInt32("bankcode", dashboard.getBankcode());
        writer.writeString("brnchcode", dashboard.getBrnchcode());
        writer.writeInt64("reckey", dashboard.getReckey());
        writer.writeString("scanref", dashboard.getScanref());
        LocalDate scndate = dashboard.getScndate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        writer.writeDate("scndate", scndate);
    }

}
