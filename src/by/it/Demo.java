package by.it;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Demo {
    public static void main(String[] args) throws Exception {

//        DateFormat dtf = SimpleDateFormat.getDateTimeInstance(
//                DateFormat.FULL,  //формат даты
//                DateFormat.SHORT, //формат времени
//                Locale.getDefault() //локаль (можно свою указать)
//        );
//        Clock clock = Clock.systemUTC();
//
//
//        LocalDateTime localDateTime = LocalDateTime.ofInstant(clock.instant(), clock.getZone());
//        DateTimeFormatter dtf2 = DateTimeFormatter.ISO_DATE;
//        String f = localDateTime.format(dtf2);
//        System.out.println(f);
//        Object date = new Date(clock.millis());
//        System.out.println(dtf.format(date));
//
//        if (Math.random() > 1e-10) System.exit(0);

        HomeWorkChecker hm = new HomeWorkChecker();
        JFrame frame = new JFrame("EstimatesFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object[] colNames = {"User", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Map<String, Integer[]> resultMap = hm.getResultMap();
        Object[][] data = new Object[resultMap.size()][];
        int i = 0;
        for (Map.Entry<String, Integer[]> row : resultMap.entrySet()) {
            data[i] = new Object[colNames.length];
            data[i][0] = row.getKey();
            for (int j = 1; j < data[i].length; j++) {
                data[i][j] = hm.getEstimate(j - 1, row.getValue()[j - 1]);
            }
            i++;
        }
        JTable table = new JTable(data, colNames);
        frame.add(table);
        table.getColumnModel().getColumn(0).setMaxWidth(75);
        Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
        for (int j = 0; columns.hasMoreElements(); j++) {
            TableColumn col = columns.nextElement();
            int widthCol = j == 0 ? 100 : 33;
            col.setMaxWidth(widthCol);
            col.setPreferredWidth(widthCol);
        }
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
